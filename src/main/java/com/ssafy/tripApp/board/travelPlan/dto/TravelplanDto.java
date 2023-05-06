package com.ssafy.tripApp.board.travelPlan.dto;

import java.sql.Timestamp;
import java.util.List;

import com.ssafy.tripApp.board.hotplace.dto.HotplaceReplyDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TravelplanDto {
	int articleNo;

	String userId;
	String subject;
	double starCount;
	Timestamp startDate;
	Timestamp endDate;
	Timestamp registerTime;
	List<LocalDto> localDto;
		
	
		
}
