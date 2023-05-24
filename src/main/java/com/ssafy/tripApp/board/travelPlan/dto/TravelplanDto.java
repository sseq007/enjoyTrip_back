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
	private int planNo;
	private int articleNo;
	private String userId;
	private String location;
	private String startDate;
	private String endDate;
	private String registerTime;
	List<LocalDto> localDto;
		
	
		
}
