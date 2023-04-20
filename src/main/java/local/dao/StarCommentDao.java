package com.ssafy.board.dao;

import java.util.List;

import com.ssafy.board.dto.StarCommentDto;

public interface StarCommentDao {
	public void writeStar(StarCommentDto starCommentDto) throws Exception;
	public List<StarCommentDto> list() throws Exception;
	public StarCommentDto readStar(String userId, int articleNo) throws Exception;
	public void updateStar(StarCommentDto starCommentDto) throws Exception;
	public void deleteStar(StarCommentDto starCommentDto) throws Exception;
}
