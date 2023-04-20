package com.ssafy.travel.dao.hotplace;

import java.sql.SQLException;

import com.ssafy.travel.domain.hotplace.hotplaceReplyDTO;

public interface hotplaceReply {

	//답글 등록
	void writehotpleReply(hotplaceReplyDTO hotplaceReply)throws SQLException;
	//답글 삭제
	void deletehotpleReply(hotplaceReplyDTO hotplaceReply)throws SQLException;
}
