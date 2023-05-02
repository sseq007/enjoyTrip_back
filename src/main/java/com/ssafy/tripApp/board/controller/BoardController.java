package com.ssafy.tripApp.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@GetMapping("/hotplace")
	public String hotplace() {
		return "/board/hotplace/boardHotple";
	}
	
	@GetMapping("/hotplace/write")
	public String hotplacewrite() {
		return "/board/hotplace/hotpleWrite";
	}
	
	@GetMapping("/local")
	public String local() {
		return "/board/boardLocation";
	}
	
//	@GetMapping("/sharetravel")
//	public String sharetravel() {
//		return "/board/board";
//	}
	
	@GetMapping("/travelplan")
	public String travelplan() {
		return "/board/boardPlan";
	}
	
	
}
