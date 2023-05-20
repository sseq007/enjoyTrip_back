package com.ssafy.tripApp.board.trippartner.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.tripApp.board.Sharetravel.dto.ShareTravelDto;
import com.ssafy.tripApp.board.trippartner.dto.KeywordOneDto;
import com.ssafy.tripApp.board.trippartner.dto.KeywordTwoDto;
import com.ssafy.tripApp.board.trippartner.dto.NoteDto;
import com.ssafy.tripApp.board.trippartner.dto.TripPartnerDto;

public interface NoteService {

	// 쪽지쓰기
		void writeNote(NoteDto noteDto) throws SQLException;
		// 동행찾기삭제
		void deletePartner(int noteNo) throws SQLException;
		// 동행찾기리스트
		List<NoteDto> listNote(String userid) throws SQLException;
		// 동행찾기가져오기
		NoteDto viewNote(int noteNo) throws SQLException;
		
}
