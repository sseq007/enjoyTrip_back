package com.ssafy.tripApp.board.hotplace.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.tripApp.board.hotplace.dto.HotplaceDto;

@Mapper
public interface HotplaceMapper {
	// 핫플 게시글 리스트
	List<HotplaceDto> listHotple() throws Exception;
	// 핫플 게시글 하나 보기
	HotplaceDto viewHotple(int articleNo) throws Exception;
	void writeHotple(HotplaceDto hotplaceDto) throws Exception;
	void updateHotple(HotplaceDto hotplaceDto) throws Exception;
	void deleteHotple(int articleNo) throws Exception;
	void plusHeart() throws SQLException;
	void minusHeart() throws SQLException;
}
