package com.ssafy.tripApp.member.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.tripApp.member.dto.MemberDto;
import com.ssafy.tripApp.member.service.MemberService;

import ch.qos.logback.core.net.SocketConnector.ExceptionHandler;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/member")
@CrossOrigin("*")
public class MemberApiController {
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/view/{id}")
	public ResponseEntity<?> view(@PathVariable String id){
		try {
			MemberDto memberDto = memberService.viewMember(id);
			
			return new ResponseEntity<MemberDto>(memberDto, HttpStatus.OK);			
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
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
	public ResponseEntity<?> register(@RequestBody MemberDto memberDto){
		try {
			memberService.registerMember(memberDto);
			return new ResponseEntity<MemberDto>(memberDto, HttpStatus.OK);	
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/modify")
	public ResponseEntity<?> update(@RequestBody MemberDto memberDto){
		try {
			memberService.updateMember(memberDto);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<MemberDto>(memberDto, HttpStatus.OK);	
	}
	
	@DeleteMapping("/delete/{id}")
	public  ResponseEntity<?> delete(@PathVariable String id){
		try {
			memberService.deleteMember(id);
			List<MemberDto> list = memberService.listMember();
			return new ResponseEntity<List<MemberDto>>(list, HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
