package com.ssafy.tripApp.board.Sharetravel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.tripApp.board.Sharetravel.dto.ShareReplyDto;
import com.ssafy.tripApp.board.Sharetravel.mapper.ShareReplyMapper;

import lombok.RequiredArgsConstructor;


@Service
public class ShareReplyServiceImpl implements ShareReplyService {

	@Autowired
	private ShareReplyMapper sharereplyMapper;
	
	@Override
	public void writeReply(ShareReplyDto shareReplyDto) throws Exception {
		
		sharereplyMapper.writeReply(shareReplyDto);
		
	}

	@Override
	public void deleteReply(int replyNo) throws Exception {
		sharereplyMapper.deleteReply(replyNo);
	}

	@Override
	public List<ShareReplyDto> listReply(int articleNo) throws Exception {
		
		return sharereplyMapper.listReply(articleNo);
	}

}
