package com.ssafy.tripApp.member.controller;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.tripApp.member.dto.MemberDto;
import com.ssafy.tripApp.member.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	private final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private ServletContext servletContext;
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@PostMapping("/login")
	public ModelAndView login(@RequestParam Map<String, String> map, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		logger.debug("login map : {}", map);
		
		try {
			MemberDto memberDto = memberService.login(map);
			if(memberDto != null) {
				session.setAttribute("userinfo", memberDto);
				
				mav.addObject("loginMember", memberDto);
				mav.setViewName("redirect:/");
			}else {
				mav.addObject("msg", "아이디 또는 비밀번호 확인 후 다시 로그인하세요!");
			}
		}catch(Exception e) {
			e.printStackTrace();
			mav.setViewName("error/error");
		}
		
		return mav;
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public String idCheck(@PathVariable("id") String id) throws Exception{
		logger.debug("idCheck id : {}", id);
		int cnt = memberService.idCheck(id);
		System.out.println(cnt);
		return cnt + "";
	}
	
	
	@PostMapping("/register")
	public ModelAndView register(MemberDto memberDto, @RequestParam("file") MultipartFile file, ModelAndView mav) {
		logger.debug("memberDto info: {}", memberDto);
		
		try {
			if(!file.isEmpty()) {
				String realPath = servletContext.getRealPath("/upload");
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
			mav.addObject("registerMember", memberDto);
			mav.setViewName("redirect:/");
		}catch(Exception e){
			e.printStackTrace();
			mav.setViewName("error/error");
		}
		return mav;
	}
	
	@GetMapping("/view")
	public ModelAndView view(HttpSession session) throws SQLException {
		ModelAndView mav = new ModelAndView();
		String userId =  ((MemberDto) session.getAttribute("userinfo")).getUserId();
		MemberDto memberDto = memberService.viewMember(userId);
		//System.out.println(memberDto.getProfileImage());
		mav.addObject("user", memberDto);
		mav.setViewName("/user/userPage");
		return mav;
	}
	
	@GetMapping("/delete")
	public ModelAndView delete(HttpSession session) throws SQLException {
		ModelAndView mav = new ModelAndView();
		String userId =  ((MemberDto) session.getAttribute("userinfo")).getUserId();
		memberService.deleteMember(userId);
		mav.setViewName("redirect:/");
		session.invalidate();
		return mav;
	}
	
	@PostMapping("/update")
	public ModelAndView update(MemberDto memberDto, @RequestParam("file") MultipartFile file, ModelAndView mav, HttpSession session) {
		logger.debug("memberDto info: {}", memberDto);
		
		try {			
			if(!file.isEmpty()) {
				String saveFolder = servletContext.getRealPath("/upload");
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
			System.out.println(memberDto.toString());
			memberService.updateMember(memberDto);
			mav.addObject("updateUser", memberDto);
			session.invalidate();
			mav.setViewName("redirect:/");
		}catch(Exception e){
			e.printStackTrace();
			mav.setViewName("error/error");
		}
		return mav;
	}
}
