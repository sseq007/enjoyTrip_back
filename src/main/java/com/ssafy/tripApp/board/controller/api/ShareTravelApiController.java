package com.ssafy.tripApp.board.controller.api;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.tripApp.board.ResponseDto;
import com.ssafy.tripApp.board.Sharetravel.dto.ShareReplyDto;
import com.ssafy.tripApp.board.Sharetravel.dto.ShareTravelDto;
import com.ssafy.tripApp.board.Sharetravel.service.ShareReplyService;
import com.ssafy.tripApp.board.Sharetravel.service.ShareTravelService;
import com.ssafy.tripApp.board.travelPlan.dto.TravelplanDto;
import com.ssafy.tripApp.member.dto.MemberDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/sharetravel")
@CrossOrigin("*")
public class ShareTravelApiController {

	@Autowired
	private ShareTravelService shareService;
	
	@Autowired
	private final ShareReplyService sharereplyService;
	
	@GetMapping("/list")
	public ResponseEntity<?> list(@RequestParam Map<String, String> map) throws Exception {
		ModelAndView mav = new ModelAndView();
		List<ShareTravelDto> listShare = shareService.listShare(map);
//		System.out.println(listShare.toString());
		mav.addObject("sharetravels", listShare);
		mav.addObject("pgno", map.get("pgno"));
		mav.addObject("key", map.get("key"));
		mav.addObject("word", map.get("word"));
		mav.setViewName("board/board");
		return new ResponseEntity<List<ShareTravelDto>>(listShare, HttpStatus.OK);
	}
	@PostMapping("/write")
	public ResponseEntity<?>write(@RequestBody ShareTravelDto sharetravelDto,HttpSession session){
		
		try {
//			MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
//			sharetravelDto.setUserId(memberDto.getUserId());
			System.out.println(sharetravelDto.toString());
			shareService.writeShare(sharetravelDto);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ResponseEntity<ShareTravelDto>(sharetravelDto, HttpStatus.OK);
	}
	@GetMapping("/view/{articleNo}")
	public ResponseEntity<?> view(@PathVariable int articleNo,Model model) {
		try {
			
			ShareTravelDto viewShare = shareService.viewShare(articleNo);
//			List<ShareReplyDto> listReply = sharereplyService.listReply(articleNo);
//			System.out.println(listReply.toString());
			shareService.updateHit(articleNo);
		
			return new ResponseEntity<ShareTravelDto>(viewShare, HttpStatus.OK);
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return exceptionHandling(e);
		}
	}
	@PutMapping("/modify")
	public ResponseEntity<?> update(@RequestBody  ShareTravelDto sharetravelDto){
		try {
			System.out.println(sharetravelDto.toString());
			shareService.updateShare(sharetravelDto);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseEntity<ShareTravelDto>(sharetravelDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public  ResponseEntity<?> deleteById(@PathVariable int id){
		
		try {
			shareService.deleteShare(id);
			List<ShareTravelDto> listShare = shareService.listShare(null);
			return  new ResponseEntity<List<ShareTravelDto>>(listShare, HttpStatus.OK);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return exceptionHandling(e);
		}
	}
	
	@PostMapping("/{boardId}/reply")
	public ResponseDto<Integer> replySave(@RequestBody ShareReplyDto sharereplyDto,Model model,HttpSession session) {
	
		try {
			MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
			sharereplyDto.setUserId(memberDto.getUserId());
//			System.out.println(sharereplyDto.toString());
			sharereplyService.writeReply(sharereplyDto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	
	@DeleteMapping("/{boardId}/reply/{replyId}")
	public ResponseDto<Integer> replyDelete(@PathVariable int replyId){
		
		try {
			sharereplyService.deleteReply(replyId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
