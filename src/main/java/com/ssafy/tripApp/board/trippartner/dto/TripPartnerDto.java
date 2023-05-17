package com.ssafy.tripApp.board.trippartner.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TripPartnerDto {

	private int articleNo;
	private String userId;
	private String location;
	private String subject;
	private String content;
	private int hit;
	private Timestamp registerTime;
	private String partnerImage;
	private String partnerUrl;
	private String partnerCount;
	private String partnerObject;
	private String startDate;
	private String endDate;
	
	
}
