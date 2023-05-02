package com.ssafy.tripApp.board.controller.api;

import java.io.File;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.tripApp.board.ResponseDto;
import com.ssafy.tripApp.board.hotplace.dto.HotplaceDto;
import com.ssafy.tripApp.board.hotplace.service.HotplaceService;
import com.ssafy.tripApp.member.dto.MemberDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/hotplace")
public class HotplaceApiController {
	@Autowired
	private HotplaceService hotplaceService;
	
	@Autowired
	private ServletContext servletContext;
	
	@PostMapping
	public ResponseDto<Integer>write(@RequestBody HotplaceDto hotplaceDto, HttpSession session, @RequestParam("file") MultipartFile file){
		String userId =  ((MemberDto) session.getAttribute("userinfo")).getUserId();
		System.out.println(userId);
		hotplaceDto.setUserId(userId);
		try {
			if(!file.isEmpty()) {
				String realPath = servletContext.getRealPath("/upload");
				String saveFolder = realPath;
				String saveFileName;
				File folder = new File(saveFolder);
				if (!folder.exists()) folder.mkdirs();
				String origin = file.getOriginalFilename();
				if(!origin.isEmpty()) {
					saveFileName = UUID.randomUUID().toString()
							+ origin;
					file.transferTo(new File(folder, saveFileName));
					hotplaceDto.setImageName(saveFileName);
				}
				hotplaceDto.setImageUrl(saveFolder);
				
			}
			hotplaceService.writeHotple(hotplaceDto);

		}catch(Exception e){
			e.printStackTrace();
		}
		
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}
}
