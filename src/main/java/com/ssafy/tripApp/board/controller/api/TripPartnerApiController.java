package com.ssafy.tripApp.board.controller.api;

import java.io.File;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.tripApp.board.ResponseDto;
import com.ssafy.tripApp.board.Sharetravel.dto.ShareReplyDto;
import com.ssafy.tripApp.board.Sharetravel.dto.ShareTravelDto;
import com.ssafy.tripApp.board.Sharetravel.service.ShareReplyService;
import com.ssafy.tripApp.board.Sharetravel.service.ShareTravelService;
import com.ssafy.tripApp.board.travelPlan.dto.TravelplanDto;
import com.ssafy.tripApp.board.trippartner.dto.TripPartnerDto;
import com.ssafy.tripApp.board.trippartner.service.TripPartnerService;
import com.ssafy.tripApp.member.controller.MemberController;
import com.ssafy.tripApp.member.dto.MemberDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/trippartner")
@CrossOrigin("*")
public class TripPartnerApiController {

	private final Logger logger = LoggerFactory.getLogger(TripPartnerApiController.class);
	private final TripPartnerService trippartnerService;
	
	@Autowired
	private ServletContext servletContext;
	
	@GetMapping("/list")
	public ResponseEntity<?> list(@RequestParam Map<String, String> map) throws Exception {
		ModelAndView mav = new ModelAndView();
		List<TripPartnerDto> listPartner = trippartnerService.listPartner(map);
		
		
//		System.out.println(listShare.toString());
		mav.addObject("pgno", map.get("pgno"));
		mav.addObject("key", map.get("key"));
		mav.addObject("word", map.get("word"));
		mav.setViewName("board/board");
		return new ResponseEntity<List<TripPartnerDto>>(listPartner, HttpStatus.OK);
	}
	@PostMapping("/write")
	public ResponseEntity<?>write(@RequestParam("userId")String userId, @RequestParam("subject")String subject,@RequestParam("content")String content,@RequestParam("partnerObject")String partnerObject,@RequestParam("partnerCount")String partnerCount,@RequestParam("startDate")String startDate,@RequestParam("endDate")String endDate,@RequestParam("file") MultipartFile file){
		TripPartnerDto trippartnerDto = new TripPartnerDto();
		try {
			if(!file.isEmpty()) {
				String realPath = "C:/junho/enjoy_trip_vue/src/assets/img/partnerimg";
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
					trippartnerDto.setPartnerImage(saveFileName);
				}
				trippartnerDto.setLocation("다시짜야돼");
				trippartnerDto.setPartnerUrl(saveFolder);
				trippartnerDto.setUserId(userId);
				trippartnerDto.setSubject(subject);
				trippartnerDto.setContent(content);
				trippartnerDto.setPartnerObject(partnerObject);
				trippartnerDto.setPartnerCount(partnerCount);
				trippartnerDto.setStartDate(startDate);
				trippartnerDto.setEndDate(endDate);
				
			}
			trippartnerService.writePartner(trippartnerDto);
//			MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
//			sharetravelDto.setUserId(memberDto.getUserId());
			System.out.println(trippartnerDto.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ResponseEntity<TripPartnerDto>(trippartnerDto, HttpStatus.OK);
	}
	@GetMapping("/view/{articleNo}")
	public ResponseEntity<?> view(@PathVariable int articleNo,Model model) {
		try {
			
			TripPartnerDto viewPartner = trippartnerService.viewPartner(articleNo);
//			List<ShareReplyDto> listReply = sharereplyService.listReply(articleNo);
//			System.out.println(listReply.toString());
			trippartnerService.updateHit(articleNo);
		
			return new ResponseEntity<TripPartnerDto>(viewPartner, HttpStatus.OK);
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return exceptionHandling(e);
		}
	}
	@PutMapping("/modify")
	public ResponseEntity<?> update(@RequestBody  TripPartnerDto trippartnerDto){
		try {
			trippartnerService.updatePartner(trippartnerDto);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<TripPartnerDto>(trippartnerDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public  ResponseEntity<?> deleteById(@PathVariable int id){
		
		try {
			trippartnerService.deletePartner(id);
			List<TripPartnerDto> listPartner = trippartnerService.listPartner(null);
			return  new ResponseEntity<List<TripPartnerDto>>(listPartner, HttpStatus.OK);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return exceptionHandling(e);
		}
	}
	
//	@PostMapping("/{boardId}/reply")
//	public ResponseDto<Integer> replySave(@RequestBody ShareReplyDto sharereplyDto,Model model,HttpSession session) {
//	
//		try {
//			MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
//			sharereplyDto.setUserId(memberDto.getUserId());
////			System.out.println(sharereplyDto.toString());
//			sharereplyService.writeReply(sharereplyDto);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
//	}
//	
//	@DeleteMapping("/{boardId}/reply/{replyId}")
//	public ResponseDto<Integer> replyDelete(@PathVariable int replyId){
//		
//		try {
//			sharereplyService.deleteReply(replyId);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
//	}
	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
