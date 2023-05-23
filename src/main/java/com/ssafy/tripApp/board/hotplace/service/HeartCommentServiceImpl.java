package com.ssafy.tripApp.board.hotplace.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.tripApp.board.hotplace.dto.HeartCommentDto;
import com.ssafy.tripApp.board.hotplace.mapper.HeartCommentMapper;
import com.ssafy.tripApp.board.hotplace.mapper.HotplaceMapper;

@Service
public class HeartCommentServiceImpl implements HeartCommentService {
	@Autowired
	private HeartCommentMapper heartMapper;
	
	@Autowired
	private HotplaceMapper hotplaceMapper;

	public HeartCommentServiceImpl(HeartCommentMapper heartMapper, HotplaceMapper hotplaceMapper) {
		super();
		this.heartMapper = heartMapper;
		this.hotplaceMapper = hotplaceMapper;
	}

	@Override
	public int checkHeart(HeartCommentDto heartcommentDto) throws SQLException {
		return heartMapper.checkHeart(heartcommentDto);
	}

	@Override
	public void registHeart(HeartCommentDto heartcommentDto) throws SQLException {
		heartMapper.registHeart(heartcommentDto);
		hotplaceMapper.plusHeart();
	}

	@Override
	public void deleteHeart(HeartCommentDto heartcommentDto) throws SQLException {
		heartMapper.deleteHeart(heartcommentDto);
		hotplaceMapper.minusHeart();
	}

}
