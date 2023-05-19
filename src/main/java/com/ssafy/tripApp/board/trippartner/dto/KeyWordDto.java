package com.ssafy.tripApp.board.trippartner.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KeyWordDto {

	private int articleNo;
	private List<KeywordOneDto> keywordOne;
	private List<KeywordTwoDto> keywordTwo;
	
}
