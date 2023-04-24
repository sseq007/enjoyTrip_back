package com.ssafy.tripApp.board.hotplace.dao;

import java.sql.SQLException;
import com.ssafy.tripApp.board.hotplace.dto.HotplaceReplyDto;

public interface HotplaceReplyDao {

	//답글 등록
	void writehotpleReply(HotplaceReplyDto hotplaceReply)throws SQLException;
	//답글 삭제
	void deletehotpleReply(HotplaceReplyDto hotplaceReply)throws SQLException;
}
