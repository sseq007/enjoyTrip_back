package com.ssafy.tripApp.board.hotplace.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class HotplaceDto {

	private int articleNo;
	private String user_id;
	private String subject;
	private String content;
	private String imageUrl;
	private String hotple_name;
	private String register_time;
	private int heart_count;
	private int sido_code;
	
	
	
	
}
