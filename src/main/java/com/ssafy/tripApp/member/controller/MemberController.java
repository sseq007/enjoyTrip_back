package com.ssafy.tripApp.member.controller;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import javax.servlet.ServletContext;

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
	private MemberService memberService;
	
	@Value("${file.path}")
	private String uploadPath;
	
	@Autowired
	private ServletContext servletContext;
	
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
	public ModelAndView register(MemberDto memberDto, @RequestParam("file") MultipartFile file, ModelAndView mav) {
		logger.debug("memberDto info: {}", memberDto);
		String realPath = servletContext.getRealPath("/upload");

		try {
			if(file != null) {
				UUID uuid = UUID.randomUUID();
				String imageFileName = uuid+"_"+file.getOriginalFilename();
				System.out.println("프로필 파일 이름: " + imageFileName);
				
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
	public String view() {
		return "/user/userPage";
	}
}
