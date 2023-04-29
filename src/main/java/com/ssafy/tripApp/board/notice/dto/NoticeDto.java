package com.ssafy.tripApp.board.notice.dto;

import com.ssafy.tripApp.board.hotplace.dto.HotplaceReplyDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class NoticeDto {

	private int articleNo;
	private String userId;
	private String subject;
	private String contnet;
	private int hit;
	private String register_time;
	
	
}
