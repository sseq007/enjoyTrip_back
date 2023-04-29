package com.ssafy.tripApp.board.notice.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.tripApp.board.notice.dto.NoticeDto;
import com.ssafy.tripApp.board.notice.mapper.NoticeMapper;

import lombok.RequiredArgsConstructor;


@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeMapper noticeMapper;
	
	public NoticeServiceImpl(NoticeMapper noticeMapper) {
		super();
		this.noticeMapper = noticeMapper;
	}

	@Override
	public void writeNotice(NoticeDto noticeDto) throws SQLException {
		noticeMapper.writeNotice(noticeDto);
	}

	@Override
	public void updateNotice(NoticeDto noticeDto) throws SQLException {
		noticeMapper.updateNotice(noticeDto);
		
	}

	@Override
	public void deleteNotice(String aticleNo) throws SQLException {
		noticeMapper.deleteNotice(aticleNo);
		
	}

	@Override
	public void updateHit(int articleNo) throws SQLException {
		noticeMapper.updateHit(articleNo);
		
	}

	@Override
	public List<NoticeDto> listNotice(Map<String, Object> param) throws SQLException {
		return noticeMapper.listNotice(param);
	}

	@Override
	public NoticeDto viewNotice(int articleNo) throws SQLException {
		// TODO Auto-generated method stub
		return noticeMapper.viewNotice(articleNo);
	}

}
