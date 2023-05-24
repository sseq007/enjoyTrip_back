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
	

	
//	@GetMapping(value ="/search/{word}")
//	public ResponseEntity<?> searchLocal(@PathVariable("word") String word) {
//		try {
//			List<LocalDto> areaList = travelplanService.areaList(word);
//			return new ResponseEntity<List<LocalDto>>(areaList, HttpStatus.OK);
//			
//		} catch (Exception e) {
//			return exceptionHandling(e);
//		}
//	}
	@PostMapping(value = "/write")
	public ResponseEntity<?> travelplanRegister(@RequestBody TravelplanDto travelplanDto,HttpSession session) {
		try {
			travelplanService.writePlan(travelplanDto);
			
//			System.out.println(travelplanDto.getArticleNo());
			for (int i = 0; i < travelplanDto.getLocalDto().size(); i++) {
				
				travelplanDto.getLocalDto().get(i).setArticleNo(travelplanDto.getArticleNo());
			}
			System.out.println(travelplanDto.toString());
//			
			travelplanService.writeLocal(travelplanDto.getLocalDto());
			
			return new ResponseEntity<TravelplanDto>(travelplanDto, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
		
	}
	@PostMapping(value = "/write/local")
	public ResponseEntity<?> travelplanRegisterLocal(@RequestBody List<LocalDto> localDto,HttpSession session) {
		try {
			
			travelplanService.writeLocal(localDto);
			return new ResponseEntity<List<LocalDto>>(localDto, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
		
	}
	@GetMapping(value = "/list")
	public ResponseEntity<?> travelplanList() {
		try {
			List<TravelplanDto> listPlan = travelplanService.listPlan();
//			System.out.println(listPlan.toString());
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
//			List<LocalDto> localList = travelplanService.localList(articleNo);
			TravelplanDto viewPlan = travelplanService.viewPlan(articleNo);
//			System.out.println(viewPlan.toString());
			if(viewPlan != null)
				return new ResponseEntity<TravelplanDto>(viewPlan, HttpStatus.OK);
			else
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	@DeleteMapping(value = "/delete/{articleNo}")
	public ResponseEntity<?> travelplanDelete(@PathVariable("articleNo") int articleNo) {
		try {
			travelplanService.deletePlan(articleNo);
			List<TravelplanDto> listPlan = travelplanService.listPlan();

			return new ResponseEntity<List<TravelplanDto>>(listPlan, HttpStatus.OK);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
//	@PutMapping(value = "/modify/{articleNo}")
//	public ResponseEntity<?> userModify(@RequestBody TravelplanDto travelplanDto,@PathVariable("articleNo") int articleNo) {
//		try {
//			TravelplanDto viewPlan = travelplanService.viewPlan(articleNo);
//			travelplanDto.setArticleNo(viewPlan.getArticleNo());
//			List<LocalDto> localDto = travelplanDto.getLocalDto();
//			for (int i = 0; i < localDto.size(); i++) {
//				travelplanDto.setLocalDto(localDto);
//			}
//			System.out.println(travelplanDto.toString());
//			travelplanService.updatePlan(travelplanDto);
//			travelplanService.updateLocal(travelplanDto.getLocalDto());
//			List<TravelplanDto> listPlan = travelplanService.listPlan();
//			return new ResponseEntity<List<TravelplanDto>>(listPlan, HttpStatus.OK);
//		} catch (Exception e) {
//			return exceptionHandling(e);
//		}
//	}
	@GetMapping("/findarticleno")
	public ResponseEntity<?> findarticleno() {
		try {
			
//			List<ShareReplyDto> listReply = sharereplyService.listReply(articleNo);
//			System.out.println(listReply.toString());

			int getarticleNo = travelplanService.getarticleNo();
			return new ResponseEntity<Integer>(getarticleNo, HttpStatus.OK);
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return exceptionHandling(e);
		}
	}
	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
