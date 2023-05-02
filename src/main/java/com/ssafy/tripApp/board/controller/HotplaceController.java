package com.ssafy.tripApp.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.tripApp.board.hotplace.dto.HotplaceDto;
import com.ssafy.tripApp.board.hotplace.service.HotplaceService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/board/hotplace")
public class HotplaceController {
	@Autowired
	private final HotplaceService hotplaceService;
	
	@GetMapping("/list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		List<HotplaceDto> list;
		mav.setViewName("/board/hotplace/boardHotple");
		return mav;
	}
	
	@GetMapping("/write")
	public String hotplacewrite() {
		return "/board/hotplace/hotpleWrite";
	}

}
