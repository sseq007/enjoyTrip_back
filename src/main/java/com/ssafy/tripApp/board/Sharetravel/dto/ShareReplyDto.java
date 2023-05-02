package com.ssafy.tripApp.board.Sharetravel.dto;

import java.sql.Timestamp;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ShareReplyDto {
	int replyNo;
	int articleNo;
	int replyDepth;
	String userId;
	String content;
	Timestamp registerTime;

	
	
		
}
