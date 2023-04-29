package com.ssafy.tripApp.board.travelPlan.dto;

import com.ssafy.tripApp.board.hotplace.dto.HotplaceReplyDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StarCommentDto {
	String userId;
	int articleNo;
	int count;	
	
	
}
