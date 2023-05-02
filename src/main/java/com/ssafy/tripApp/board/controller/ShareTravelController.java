package com.ssafy.tripApp.board.controller;

import java.io.File;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ssafy.tripApp.board.Sharetravel.dto.ShareReplyDto;
import com.ssafy.tripApp.board.Sharetravel.dto.ShareTravelDto;
import com.ssafy.tripApp.board.Sharetravel.service.ShareReplyService;
import com.ssafy.tripApp.board.Sharetravel.service.ShareTravelService;
import com.ssafy.tripApp.member.dto.MemberDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/board/sharetravel")
public class ShareTravelController {

	@Autowired
	private final ShareTravelService shareService;
	
	@Autowired
	private final ShareReplyService sharereplyService;
	
	@GetMapping("/write")
	public String writeForm(@RequestParam Map<String, String> map, Model model) {
		model.addAttribute("pgno", map.get("pgno"));
		model.addAttribute("key", map.get("key"));
		model.addAttribute("word", map.get("word"));
		return "board/boardWrite";
	}
	
	@GetMapping("/list")
	public ModelAndView list(@RequestParam Map<String, String> map) throws Exception {
		ModelAndView mav = new ModelAndView();
		List<ShareTravelDto> listShare = shareService.listShare(map);
//		System.out.println(listShare.toString());
		mav.addObject("sharetravels", listShare);
		mav.addObject("pgno", map.get("pgno"));
		mav.addObject("key", map.get("key"));
		mav.addObject("word", map.get("word"));
		mav.setViewName("board/board");
		return mav;
	}
	
	@GetMapping("/view/{articleNo}")
	public String viewForm(@PathVariable int articleNo,Model model) {
		try {
			
			ShareTravelDto viewShare = shareService.viewShare(articleNo);
			List<ShareReplyDto> listReply = sharereplyService.listReply(articleNo);
//			System.out.println(listReply.toString());
			shareService.updateHit(articleNo);
			model.addAttribute("sharetravels",viewShare);
			model.addAttribute("sharereply",listReply);
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/board/boardContent";
	}
	@GetMapping("/updateForm/{articleNo}")
	public String modifyForm(@PathVariable int articleNo,Model model) {
		try {
			ShareTravelDto viewShare = shareService.viewShare(articleNo);
			model.addAttribute("sharetravels",viewShare);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/board/boardModify";
	}
	
}
