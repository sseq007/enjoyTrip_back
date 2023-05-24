package com.ssafy.tripApp.board.hotplace.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class HotplaceReplyDto {

	private int replyNo;
	private int articleNo;
	private String userId;
	private String content;
	private String register_time;
	private int reply_depth;	
	
}
