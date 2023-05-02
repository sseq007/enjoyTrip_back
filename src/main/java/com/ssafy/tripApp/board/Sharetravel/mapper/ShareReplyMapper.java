package com.ssafy.tripApp.board.Sharetravel.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.tripApp.board.Sharetravel.dto.ShareReplyDto;

@Mapper
public interface ShareReplyMapper {

	//답글 쓰기
	void writeReply(ShareReplyDto shareReplyDto) throws Exception;
	//답글 삭제
	void deleteReply(int replyNo) throws Exception;
	//답글 가져오기
	List<ShareReplyDto> listReply(int articleNo) throws Exception;
}
