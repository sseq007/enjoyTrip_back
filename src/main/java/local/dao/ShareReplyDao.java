package com.ssafy.board.dao;

import java.util.List;

import com.ssafy.board.dto.ShareReplyDto;

public interface ShareReplyDao {
	public void writeReply(ShareReplyDto shareReplyDto) throws Exception;
	public List<ShareReplyDto> list() throws Exception;
	public void updateReply(ShareReplyDto shareReplyDto) throws Exception;
	public void deleteReply(ShareReplyDto shareReplyDto) throws Exception;
}
