package com.ssafy.tripApp.board.hotplace.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.tripApp.board.hotplace.dto.HotplaceReplyDto;

@Mapper
public interface HotplaceReplyMapper {
	public List<HotplaceReplyDto> listReply(int articleNo) throws SQLException;
	public void updateReply(HotplaceReplyDto hotplaceReplyDto) throws SQLException;
	//답글 등록
	void writeReply(HotplaceReplyDto hotplaceReply) throws SQLException;
	//답글 삭제
	void deleteReply(HotplaceReplyDto hotplaceReply) throws SQLException;
	int getMax(int articleNo, int replyNo) throws SQLException;
}
