package com.ssafy.tripApp.board.hotplace.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class HotplaceDto {

	private int articleNo;
	private String userId;
	private String subject;
	private String content;
	private String imageUrl;
	private String imageName;
	private String registerTime;
	private int heart_count;
	private int reply_count;
	private int sido_code;
}
