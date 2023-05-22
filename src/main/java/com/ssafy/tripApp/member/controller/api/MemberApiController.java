package com.ssafy.tripApp.member.controller.api;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNullApi;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.tripApp.member.controller.MemberController;
import com.ssafy.tripApp.member.dto.MemberDto;
import com.ssafy.tripApp.member.service.JwtServiceImpl;
import com.ssafy.tripApp.member.service.MemberService;

import ch.qos.logback.core.net.SocketConnector.ExceptionHandler;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/member")
@CrossOrigin("*")
public class MemberApiController {
	public static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Value("${file.path}")
	private String uploadPath;
	
	@Autowired
	private JwtServiceImpl jwtService;
	
	@Autowired
	private MemberService memberService;
	
	@ApiOperation(value = "로그인", notes = "Access-token과 로그인 결과 메시지를 반환한다", response = Map.class)
	@PostMapping("/login")
	public ResponseEntity<?> login(
			@RequestBody @ApiParam(value = "로그인 시 필요한 회원 정보(아이디, 비밀번호)", required = true) Map<String, String> map){
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		try {
			MemberDto memberDto = memberService.login(map);
			if(memberDto != null) {
				String accessToken = jwtService.createAccessToken("userId", memberDto.getUserId());// key, data
				String refreshToken = jwtService.createRefreshToken("userId", memberDto.getUserId());// key, data
				memberService.saveRefreshToken(memberDto.getUserId(), refreshToken);
				logger.debug("로그인 accessToken 정보: {}", accessToken);
				logger.debug("로그인 refreshToken 정보: {}", refreshToken);
				resultMap.put("access-token", accessToken);
				resultMap.put("refresh-token", refreshToken);
				resultMap.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;
			}else {
				resultMap.put("message", FAIL);
				status = HttpStatus.ACCEPTED;
			}
			
		}catch(Exception e) {
			logger.error("로그인 실패: {}", e);
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
		return new ResponseEntity<Map<String,Object>>(resultMap, status);
	}
	
	@ApiOperation(value = "로그아웃", notes = "회원 정보를 담은 Token을 제거한다.", response = Map.class)
	@GetMapping("/logout/{id}")
	public ResponseEntity<?> logout(@PathVariable String id){
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		try {
			memberService.deleteRefreshToken(id);
			resultMap.put("message", SUCCESS);
			status = HttpStatus.ACCEPTED;
		} catch(Exception e) {
			logger.error("로그아웃 실패: {}", e);
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String,Object>>(resultMap, status);
	}
	
	@ApiOperation(value = "Access Token 재발급", notes = "만료된 access token을 재발급받는다.", response = Map.class)
	@PostMapping("/refresh")
	public ResponseEntity<?> refreshToken(@RequestBody MemberDto memberDto, HttpServletRequest request) throws Exception{
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		String token = request.getHeader("refresh-token");
		logger.debug("token: {}, memberDto: {}", token, memberDto);
		if(jwtService.checkToken(token)) {
			if(token.equals(memberService.getRefreshToken(memberDto.getUserId()))) {
				String accessToken = jwtService.createAccessToken("userId", memberDto.getUserId());
				logger.debug("token: {}", accessToken);
				logger.debug("정상적으로 액세스토큰 재발급");
				resultMap.put("access-token", accessToken);
				resultMap.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;
			}
		}else {
			logger.debug("refresh token도 사용 불가");
			status = HttpStatus.UNAUTHORIZED;
		}
		return new ResponseEntity<Map<String,Object>>(resultMap, status);
	}
	
	@ApiOperation(value = "회원 인증", notes = "회원 정보를 담은 Token을 반환한다.", response = Map.class)
	@GetMapping("/view/{id}")
	public ResponseEntity<?> view(
			@PathVariable @ApiParam(value ="인증할 회원의 아이디", required = true) String id,
			HttpServletRequest request){
		logger.debug("userId: {}", id);
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.UNAUTHORIZED;
		if(jwtService.checkToken(request.getHeader("access-token"))) {
			logger.info("사용 가능한 토큰");
			try {
				// 로그인 사용자 정보
				MemberDto memberDto = memberService.viewMember(id);
				resultMap.put("userInfo", memberDto);
				resultMap.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;
			}catch(Exception e) {
				logger.error("정보 조회 실패: {}", e);
				resultMap.put("message", e.getMessage());
				status = HttpStatus.INTERNAL_SERVER_ERROR;
			}
		} else {
			logger.error("사용 불가능 토큰");
			resultMap.put("message", FAIL);
			status = HttpStatus.UNAUTHORIZED;
		}
		return new ResponseEntity<Map<String,Object>>(resultMap, status);
	}
	
	@ApiOperation(value = "회원 인증", notes = "회원 정보를 담은 Token을 반환한다.", response = Map.class)
	@GetMapping("/detail/{id}")
	public ResponseEntity<?> detail(
			@PathVariable @ApiParam(value ="인증할 회원의 아이디", required = true) String id){
		logger.debug("userId: {}", id);
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.UNAUTHORIZED;
		try {
			// 로그인 사용자 정보
			MemberDto memberDto = memberService.viewMember(id);
			resultMap.put("userInfo", memberDto);
			resultMap.put("message", SUCCESS);
			status = HttpStatus.ACCEPTED;
		}catch(Exception e) {
			logger.error("정보 조회 실패: {}", e);
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String,Object>>(resultMap, status);
	}
	
	@GetMapping("/list")
	public ResponseEntity<?> list(){
		try {
			List<MemberDto> list = memberService.listMember();
			if(list != null && !list.isEmpty()) {
				return new ResponseEntity<List<MemberDto>>(list, HttpStatus.OK);
			}else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> register(MemberDto memberDto, @RequestParam(value="file", required=false) MultipartFile file){
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.UNAUTHORIZED;
		System.out.println(memberDto);
		try {
			if(file != null) {
				String realPath = uploadPath;
				System.out.println(realPath);
				String saveFolder = realPath;
				String saveFileName;
				logger.debug("저장 폴더 : {}", saveFolder);
				File folder = new File(saveFolder);
				if (!folder.exists()) folder.mkdirs();
				String origin = file.getOriginalFilename();
				if(!origin.isEmpty()) {
					saveFileName = UUID.randomUUID().toString()
							+ origin;
					logger.debug("원본 파일 이름 : {}, 실제 저장 파일 이름 : {}", origin, saveFileName);
					file.transferTo(new File(folder, saveFileName));
					memberDto.setProfileImage(saveFileName);
				}
				memberDto.setProfileUrl(saveFolder);
			}
			memberService.registerMember(memberDto);
			resultMap.put("userInfo", memberDto);
			resultMap.put("message", SUCCESS);
			status = HttpStatus.ACCEPTED;
		}catch(Exception e) {
			logger.error("멤버 등록 실패: {}", e);
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
		return new ResponseEntity<Map<String,Object>>(resultMap, status);
	}
	
	@PutMapping("/modify")
	public ResponseEntity<?> update(/*@RequestBody*/ MemberDto memberDto, @RequestParam(value="file", required=false) MultipartFile file){
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.UNAUTHORIZED;
		System.out.println(memberDto);
		try {
			MemberDto updateMember = memberService.viewMember(memberDto.getUserId());
			if(file != null) {
				String realPath = uploadPath;
				System.out.println(realPath);
				String saveFolder = realPath;
				String saveFileName;
				logger.debug("저장 폴더 : {}", saveFolder);
				File folder = new File(saveFolder);
				if (!folder.exists()) folder.mkdirs();
				String origin = file.getOriginalFilename();
				if(!origin.isEmpty()) {
					saveFileName = UUID.randomUUID().toString()
							+ origin;
					logger.debug("원본 파일 이름 : {}, 실제 저장 파일 이름 : {}", origin, saveFileName);
					file.transferTo(new File(folder, saveFileName));
					memberDto.setProfileImage(saveFileName);
				}
				memberDto.setProfileUrl(saveFolder);
			} else if(updateMember.getProfileImage() != null) {
				memberDto.setProfileImage(updateMember.getProfileImage());
				memberDto.setProfileUrl(updateMember.getProfileUrl());
			}
			memberService.updateMember(memberDto);
			resultMap.put("userInfo", memberDto);
			resultMap.put("message", SUCCESS);
			status = HttpStatus.ACCEPTED;
		}catch(Exception e) {
			logger.error("정보 수정 실패: {}", e);
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
		return new ResponseEntity<Map<String,Object>>(resultMap, status);
	}
	
	@DeleteMapping("/delete/{id}")
	public  ResponseEntity<?> delete(@PathVariable String id){
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.UNAUTHORIZED;
		try {
			memberService.deleteMember(id);
			resultMap.put("message", SUCCESS);
			status = HttpStatus.ACCEPTED;
		}catch(Exception e) {
			logger.error("멤버 삭제 실패: {}", e);
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String,Object>>(resultMap, status);
	}
}
