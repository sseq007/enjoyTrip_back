package com.ssafy.tripApp.board.hotplace.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.tripApp.board.hotplace.dto.HotplaceReplyDto;
import com.ssafy.tripApp.board.hotplace.mapper.HotplaceMapper;
import com.ssafy.tripApp.board.hotplace.mapper.HotplaceReplyMapper;

@Service
public class HotplaceReplyServiceImpl implements HotplaceReplyService {
	@Autowired
	private HotplaceReplyMapper replyMapper;
	
	@Autowired
	private HotplaceMapper hotplaceMapper;
	
	@Override
	public List<HotplaceReplyDto> listReply(int articleNo) throws SQLException {
		return replyMapper.listReply(articleNo);
	}

	@Override
	public void updateReply(HotplaceReplyDto hotplaceReplyDto) throws SQLException {
		replyMapper.updateReply(hotplaceReplyDto);
		
	}

	@Override
	public void writeReply(HotplaceReplyDto hotplaceReplyDto) throws SQLException {
		replyMapper.writeReply(hotplaceReplyDto);
		hotplaceMapper.plusReply(hotplaceReplyDto.getArticleNo());
	}

	@Override
	public void deleteReply(HotplaceReplyDto hotplaceReplyDto) throws SQLException {
		replyMapper.deleteReply(hotplaceReplyDto);
		hotplaceMapper.minusReply(hotplaceReplyDto.getArticleNo());
	}

	@Override
	public int getMax(int articleNo, int replyNo) throws SQLException {
		return replyMapper.getMax(articleNo, replyNo);
	}

}
