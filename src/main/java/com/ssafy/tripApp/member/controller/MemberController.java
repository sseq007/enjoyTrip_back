package com.ssafy.tripApp.member.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssafy.tripApp.member.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	private final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/logout")
	public String logout() {
		return "redirect:/";
	}
	
	@GetMapping("/login")
	public String login() {
		return "redirect:/";
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public String idCheck(@PathVariable("id") String id) throws Exception{
		logger.debug("idCheck id : {}", id);
		int cnt = memberService.idCheck(id);
		return cnt + "";
	}
	
	
	@PostMapping("/register")
	public String register() {
		return "redirect:/";
	}
	
	@GetMapping("/view")
	public String view() {
		return "/user/userPage";
	}
}
