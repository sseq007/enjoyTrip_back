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
	
	@PostMapping("/write")
	public ModelAndView hotplacewrite(HotplaceDto hotplaceDto, @RequestParam("file") MultipartFile file, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		String userId =  ((MemberDto) session.getAttribute("userinfo")).getUserId();
		System.out.println(userId);
		hotplaceDto.setUserId(userId);
		try {
			if(!file.isEmpty()) {
				String realPath = servletContext.getRealPath("/upload");
				String saveFolder = realPath;
				String saveFileName;
				logger.debug("저장 폴더 : {}", saveFolder);
				File folder = new File(saveFolder);
				if (!folder.exists()) folder.mkdirs();
				String origin = file.getOriginalFilename();
				if(!origin.isEmpty()) {
					saveFileName = UUID.randomUUID().toString()
							+ origin;
					logger.debug("원본 파일 이름 : {}, 실제 저장 파일 이름 : {}", origin, saveFileName);
					file.transferTo(new File(folder, saveFileName));
					hotplaceDto.setImageName(saveFileName);
				}
				hotplaceDto.setImageUrl(saveFolder);
				
			}
			hotplaceService.writeHotple(hotplaceDto);
			mav.addObject("writeHotplace", hotplaceDto);
			mav.setViewName("redirect:/board/hotplace/list");
		}catch(Exception e){
			e.printStackTrace();
			mav.setViewName("error/error");
		}
		
		return mav;
	}

}
