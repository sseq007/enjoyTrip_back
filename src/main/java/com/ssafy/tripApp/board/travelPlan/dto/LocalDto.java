package com.ssafy.tripApp.board.travelPlan.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LocalDto {

	private int travelplanId;
	private int articleNo;
	private String title;
	private int contentId;
	private String address;
	private String image;
}
