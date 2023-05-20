package com.ssafy.tripApp.board.trippartner.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoteDto {
	
	private int noteNo;
	private String fromuserId;
	private String touserId;
	private String Content;
	private boolean isRead;
	private Timestamp registerTime;
	
	
}
