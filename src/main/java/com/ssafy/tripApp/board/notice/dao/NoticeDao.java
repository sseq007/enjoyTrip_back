package com.ssafy.tripApp.board.notice.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.tripApp.board.notice.dto.NoticeDto;


public interface NoticeDao {
	//글쓰기
	void writeNotice(NoticeDto noticeDto) throws SQLException;
	//글목록보기
	List<NoticeDto> listNotice() throws SQLException;
	//글가져오기
	NoticeDto getNotice(int articleNo) throws SQLException;
	//글수정하기
	void modifyNotice(NoticeDto noticeDto) throws SQLException;
	//글삭제하기
	void deleteNotice(int articleNO) throws SQLException;
	//중요공지(추가)
	
}
