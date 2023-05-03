package com.ssafy.tripApp.board.controller.api;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.tripApp.board.ResponseDto;
import com.ssafy.tripApp.board.Sharetravel.dto.ShareReplyDto;
import com.ssafy.tripApp.board.Sharetravel.dto.ShareTravelDto;
import com.ssafy.tripApp.board.Sharetravel.service.ShareReplyService;
import com.ssafy.tripApp.board.Sharetravel.service.ShareTravelService;
import com.ssafy.tripApp.board.travelPlan.dto.LocalDto;
import com.ssafy.tripApp.board.travelPlan.dto.TravelplanDto;
import com.ssafy.tripApp.board.travelPlan.service.TravelplanService;
import com.ssafy.tripApp.member.dto.MemberDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/travelplan")
@CrossOrigin("*")
public class TravelPlanApiController {

	private final TravelplanService travelplanService;
	

	
	@GetMapping(value ="/search/{word}")
	public ResponseEntity<?> searchLocal(@PathVariable("word") String word) {
		try {
			List<LocalDto> areaList = travelplanService.areaList(word);
			return new ResponseEntity<List<LocalDto>>(areaList, HttpStatus.OK);
			
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	@PostMapping(value = "/write")
	public ResponseEntity<?> travelplanRegister(@RequestBody TravelplanDto travelplanDto,HttpSession session) {
		try {
//			MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
//			travelplanDto.setUserId(memberDto.getUserId());
			System.out.println(travelplanDto.toString());
			travelplanService.writePlan(travelplanDto);
			return new ResponseEntity<TravelplanDto>(travelplanDto, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
		
	}
	@GetMapping(value = "/list")
	public ResponseEntity<?> travelplanList() {
		try {
			List<TravelplanDto> listPlan = travelplanService.listPlan();
			if(listPlan != null && !listPlan.isEmpty()) {
				return new ResponseEntity<List<TravelplanDto>>(listPlan, HttpStatus.OK);
//				return new ResponseEntity<List<MemberDto>>(HttpStatus.NOT_FOUND);
			} else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return exceptionHandling(e);
		}
		
	}
	@GetMapping(value = "/list/{articleNo}")
	public ResponseEntity<?> travelplanInfo(@PathVariable("articleNo") int articleNo) {
		try {
			TravelplanDto viewPlan = travelplanService.viewPlan(articleNo);
			if(viewPlan != null)
				return new ResponseEntity<TravelplanDto>(viewPlan, HttpStatus.OK);
			else
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
//	@DeleteMapping(value = "/user/{userid}")
//	public ResponseEntity<?> travelplanDelete(@PathVariable("userid") String userId) {
//		try {
//			travelplanService.deletePlan(travelPlanDto);
//			return new ResponseEntity<List<MemberDto>>(list, HttpStatus.OK);
//		} catch (Exception e) {
//			return exceptionHandling(e);
//		}
//	}
	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
