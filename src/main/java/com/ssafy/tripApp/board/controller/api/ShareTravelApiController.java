package com.ssafy.tripApp.board.controller.api;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
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
import com.ssafy.tripApp.board.travelPlan.dto.TravelplanDto;
import com.ssafy.tripApp.member.dto.MemberDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/sharetravel")
public class ShareTravelApiController {

	@Autowired
	private ShareTravelService shareService;
	
	@Autowired
	private final ShareReplyService sharereplyService;
	
	@PostMapping("/write")
	public  ResponseEntity<?>write(@RequestBody ShareTravelDto sharetravelDto,HttpSession session){
		
		try {
			MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
			sharetravelDto.setUserId(memberDto.getUserId());
			System.out.println(sharetravelDto.toString());
			shareService.writeShare(sharetravelDto);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ResponseEntity<ShareTravelDto>(sharetravelDto, HttpStatus.OK);
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
	public ResponseEntity<?> deleteById(@PathVariable int id){
		
		try {
			shareService.deleteShare(id);
			List<ShareTravelDto> listShare = shareService.listShare(null);
			return new ResponseEntity<List<ShareTravelDto>>(listShare, HttpStatus.OK);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return exceptionHandling(e);
		}
	}
	
	@PostMapping("/{boardId}/reply")
	public ResponseEntity<?> replySave(@RequestBody ShareReplyDto sharereplyDto,Model model,HttpSession session) {
	
		try {
			MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
			sharereplyDto.setUserId(memberDto.getUserId());
//			System.out.println(sharereplyDto.toString());
			sharereplyService.writeReply(sharereplyDto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new ResponseEntity<ShareReplyDto>(sharereplyDto, HttpStatus.OK);
	}
	
	@DeleteMapping("/{boardId}/reply/{replyId}")
	public ResponseEntity<?> replyDelete(@PathVariable int replyId,@PathVariable int boardId){
		
		try {
			sharereplyService.deleteReply(replyId);
			List<ShareReplyDto> listReply = sharereplyService.listReply(boardId);
			return new ResponseEntity<List<ShareReplyDto>>(listReply, HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return exceptionHandling(e);
		}
	}
	
	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
