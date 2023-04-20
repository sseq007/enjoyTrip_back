package com.ssafy.travel.dao.notice;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.travel.domain.notice.noticeDTO;


public interface noticeDao {
	//글쓰기
	void writeNotice(noticeDTO noticeDto) throws SQLException;
	//글목록보기
	List<noticeDTO> listNotice() throws SQLException;
	//글가져오기
	noticeDTO getNotice(int articleNo) throws SQLException;
	//글수정하기
	void modifyNotice(noticeDTO noticeDto) throws SQLException;
	//글삭제하기
	void deleteNotice(int articleNO) throws SQLException;
	//중요공지(추가)
	
}
