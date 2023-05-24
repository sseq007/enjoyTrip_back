package com.ssafy.tripApp.board.travelPlan.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LocalDto {
	private int articleNo;
	private String title;
	private String tel;
	private String addr1;
	private String firstimage;
//	private int order;
}
