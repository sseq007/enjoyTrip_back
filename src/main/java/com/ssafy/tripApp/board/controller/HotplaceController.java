package com.ssafy.tripApp.board.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.tripApp.board.hotplace.dto.HotplaceDto;
import com.ssafy.tripApp.board.hotplace.service.HotplaceService;
import com.ssafy.tripApp.member.dto.MemberDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/board/hotplace")
public class HotplaceController {
	private final Logger logger = LoggerFactory.getLogger(HotplaceController.class);
	
	@Autowired
	private final HotplaceService hotplaceService;
	
	@Autowired
	private ServletContext servletContext;
	
	@GetMapping("/list")
	public ModelAndView list() throws Exception {
		ModelAndView mav = new ModelAndView();
		List<HotplaceDto> hotplaceList = hotplaceService.listHotple();
		mav.addObject("hotplaceList", hotplaceList);
		mav.setViewName("/board/hotplace/boardHotple");
		return mav;
	}
	
	@GetMapping("/write")
	public String hotplacewrite() {
		return "/board/hotplace/hotpleWrite";
	}


}
