package com.ssafy.tripApp.board.trippartner.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.tripApp.board.Sharetravel.dto.ShareTravelDto;
import com.ssafy.tripApp.board.trippartner.dto.KeywordOneDto;
import com.ssafy.tripApp.board.trippartner.dto.KeywordTwoDto;
import com.ssafy.tripApp.board.trippartner.dto.TripPartnerDto;
import com.ssafy.tripApp.board.trippartner.dto.UserDto;

public interface TripPartnerService {

		// 동행찾기쓰기
		void writePartner(TripPartnerDto trippartnerDto) throws SQLException;
		// 동행찾기수정
		void updatePartner(TripPartnerDto trippartnerDto) throws SQLException;
		void updateKeywordOne(List<KeywordOneDto> keywordoneDto) throws SQLException;
		void updateKeywordTwo(List<KeywordTwoDto> keywordtwoDto) throws SQLException;
		// 동행찾기삭제
		void deletePartner(int aticleNo) throws SQLException;
		// 조회수업데이트
		void updateHit(int articleNo) throws SQLException;
		// 동행찾기리스트
		List<TripPartnerDto> listPartner(Map<String, String> param) throws SQLException;
		// 동행찾기가져오기
		TripPartnerDto viewPartner(int articleNo) throws SQLException;
		void writeKeywordOne(List<KeywordOneDto> keywordoneDto) throws SQLException;
		void writeKeywordTwo(List<KeywordTwoDto> keywordtwoDto) throws SQLException;
		int getarticleNo() throws SQLException;
		
		List<TripPartnerDto> listKeywordOne(int articleNo) throws SQLException;
		List<TripPartnerDto> listKeywordTwo(int articleNo) throws SQLException;
		void updateisEndOn(TripPartnerDto trippartnerDto) throws SQLException;
		void updateisEndOff(TripPartnerDto trippartnerDto) throws SQLException;
//		모집순(모집중)
		List<TripPartnerDto> listPartnerOn(Map<String, String> param) throws SQLException;
//		모집순(모집종료)
		List<TripPartnerDto> listPartnerOff(Map<String, String> param) throws SQLException;
	//인기순
		List<TripPartnerDto> listPartnerHit(Map<String, String> param) throws SQLException;
		List<TripPartnerDto> listPartnerhitOff(Map<String, String> param) throws SQLException;
		
		List<TripPartnerDto> listPartnernewOn(Map<String, String> param) throws SQLException;
		UserDto viewUser(String userId) throws SQLException;
		List<TripPartnerDto> listPartnernewOff(Map<String, String> param) throws SQLException;
}
