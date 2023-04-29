package com.ssafy.tripApp.board.travelPlan.dto;

import java.sql.Timestamp;

import com.ssafy.tripApp.board.hotplace.dto.HotplaceReplyDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TravelplanDto {
	int articleNo;
	int contentId;
	String userId;
	String subject;
	double starCount;
	Timestamp startDate;
	Timestamp endDate;
	Timestamp registerTime;
		
	
		
}
