package com.ssafy.tripApp.board.Sharetravel.dto;

import java.sql.Timestamp;

import com.ssafy.tripApp.board.hotplace.dto.HotplaceReplyDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ShareTravelDto {
	int articleNo;
	String userId;
	String subject;
	String content;
	int hit;
	String registerTime;
		
	
	
	
	
	
}
