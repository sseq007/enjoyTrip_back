package com.ssafy.tripApp.board.Sharetravel.dao;

import java.util.List;
import com.ssafy.tripApp.board.Sharetravel.dto.ShareReplyDto;


public interface ShareReplyDao {
	public void writeReply(ShareReplyDto shareReplyDto) throws Exception;
	public List<ShareReplyDto> list() throws Exception;
	public void updateReply(ShareReplyDto shareReplyDto) throws Exception;
	public void deleteReply(ShareReplyDto shareReplyDto) throws Exception;
}
