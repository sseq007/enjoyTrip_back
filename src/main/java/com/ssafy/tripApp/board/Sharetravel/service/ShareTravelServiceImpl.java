package com.ssafy.tripApp.board.Sharetravel.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.tripApp.board.Sharetravel.dto.ShareTravelDto;
import com.ssafy.tripApp.board.Sharetravel.mapper.ShareTravelMapper;

@Service
public class ShareTravelServiceImpl implements ShareTravelService {

	@Autowired
	private  ShareTravelMapper sharemapper;
	
	public ShareTravelServiceImpl(ShareTravelMapper sharemapper) {
		super();
		this.sharemapper = sharemapper;
	}

	@Override
	public void writeShare(ShareTravelDto sharetravelDto) throws SQLException {
	
		
		sharemapper.writeShare(sharetravelDto);
		
	}

	@Override
	public void updateShare(ShareTravelDto sharetravelDto) throws SQLException {
		sharemapper.updateShare(sharetravelDto);
	}

	@Override
	public void deleteShare(int aticleNo) throws SQLException {
		sharemapper.deleteShare(aticleNo);
		
	}

	@Override
	public void updateHit(int articleNo) throws SQLException {
		sharemapper.updateHit(articleNo);
		
	}

	@Override
	public List<ShareTravelDto> listShare(Map<String, String> param) throws SQLException {
		// TODO Auto-generated method stub
		return sharemapper.listShare(param);
	}

	@Override
	public ShareTravelDto viewShare(int articleNo) throws SQLException {
		// TODO Auto-generated method stub
		return sharemapper.viewShare(articleNo);
	}

}
