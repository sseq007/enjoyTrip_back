package com.ssafy.tripApp.board.Sharetravel.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.tripApp.board.Sharetravel.dto.ShareTravelDto;
import com.ssafy.tripApp.board.notice.dto.NoticeDto;


@Mapper
public interface ShareTravelMapper {

		//여행공유쓰기
		void writeShare(ShareTravelDto sharetravelDto) throws SQLException;
		//여행공유수정
		void updateShare(ShareTravelDto sharetravelDto) throws SQLException;
		//여행공유삭제
		void deleteShare(int aticleNo) throws SQLException;
		//조회수업데이트
		void updateHit(int articleNo) throws SQLException;
		//여행공유리스트
		List<ShareTravelDto> listShare(Map<String, String> param) throws SQLException;
		//여행공유가져오기
		ShareTravelDto viewShare(int articleNo) throws SQLException;
}
