package com.ssafy.tripApp.board.trippartner.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.tripApp.board.Sharetravel.dto.ShareTravelDto;
import com.ssafy.tripApp.board.trippartner.dto.TripPartnerDto;

public interface TripPartnerService {

		// 동행찾기쓰기
		void writePartner(TripPartnerDto trippartnerDto) throws SQLException;
		// 동행찾기수정
		void updatePartner(TripPartnerDto trippartnerDto) throws SQLException;
		// 동행찾기삭제
		void deletePartner(int aticleNo) throws SQLException;
		// 조회수업데이트
		void updateHit(int articleNo) throws SQLException;
		// 동행찾기리스트
		List<TripPartnerDto> listPartner(Map<String, String> param) throws SQLException;
		// 동행찾기가져오기
		TripPartnerDto viewPartner(int articleNo) throws SQLException;
}
