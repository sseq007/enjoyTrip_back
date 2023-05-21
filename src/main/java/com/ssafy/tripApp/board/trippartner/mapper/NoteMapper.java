package com.ssafy.tripApp.board.trippartner.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.tripApp.board.trippartner.dto.KeywordOneDto;
import com.ssafy.tripApp.board.trippartner.dto.KeywordTwoDto;
import com.ssafy.tripApp.board.trippartner.dto.NoteDto;
import com.ssafy.tripApp.board.trippartner.dto.TripPartnerDto;

@Mapper
public interface NoteMapper {

	// 쪽지쓰기
	void writeNote(NoteDto noteDto) throws SQLException;
	// 동행찾기삭제
	void deleteNote(int noteNo) throws SQLException;
	// 동행찾기리스트
	List<NoteDto> listNote(String userid) throws SQLException;
	// 동행찾기가져오기
	NoteDto viewNote(int noteNo) throws SQLException;
	void updateisRead(NoteDto noteDto) throws SQLException;
	int isReadCount(String userid) throws SQLException;
	
	int sendCount(int articleNo) throws SQLException;
	
}
