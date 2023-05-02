package com.ssafy.tripApp.board.controller.api;

import java.sql.SQLException;

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
	public ResponseDto<Integer>write(@RequestBody ShareTravelDto sharetravelDto,HttpSession session){
		
		try {
			MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
			sharetravelDto.setUserId(memberDto.getUserId());
			System.out.println(sharetravelDto.toString());
			shareService.writeShare(sharetravelDto);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	@PutMapping("/modify")
	public ResponseDto<Integer> update(@RequestBody  ShareTravelDto sharetravelDto){
		try {
			System.out.println(sharetravelDto.toString());
			shareService.updateShare(sharetravelDto);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseDto<Integer> deleteById(@PathVariable int id){
		
		try {
			shareService.deleteShare(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
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
}
