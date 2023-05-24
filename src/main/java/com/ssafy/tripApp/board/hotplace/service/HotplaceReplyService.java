package com.ssafy.tripApp.board.hotplace.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.tripApp.board.hotplace.dto.HotplaceReplyDto;

public interface HotplaceReplyService {
	public List<HotplaceReplyDto> listReply(int articleNo) throws SQLException;
	public void updateReply(HotplaceReplyDto hotplaceReplyDto) throws SQLException;
	//답글 등록
	void writeReply(HotplaceReplyDto hotplaceReply) throws SQLException;
	//답글 삭제
	void deleteReply(HotplaceReplyDto hotplaceReply) throws SQLException;
	int getMax(int articleNo, int replyNo) throws SQLException;
}
