package com.ssafy.tripApp.board.trippartner.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.tripApp.board.Sharetravel.dto.ShareTravelDto;
import com.ssafy.tripApp.board.Sharetravel.mapper.ShareTravelMapper;
import com.ssafy.tripApp.board.trippartner.dto.TripPartnerDto;
import com.ssafy.tripApp.board.trippartner.mapper.TripPartnerMapper;

@Service
public class TripPartnerServiceImpl implements TripPartnerService {

	@Autowired
	private TripPartnerMapper trippartnerMapper;
	
	@Override
	public void updateHit(int articleNo) throws SQLException {

		trippartnerMapper.updateHit(articleNo);
	}

	@Override
	public List<TripPartnerDto> listPartner(Map<String, String> param) throws SQLException {
		return trippartnerMapper.listPartner(param);
	}

	@Override
	public TripPartnerDto viewPartner(int articleNo) throws SQLException {
		return trippartnerMapper.viewPartner(articleNo);
	}

	@Override
	public void writePartner(TripPartnerDto trippartnerDto) throws SQLException {

		trippartnerMapper.writePartner(trippartnerDto);
	}

	@Override
	public void updatePartner(TripPartnerDto trippartnerDto) throws SQLException {
		// TODO Auto-generated method stub
		trippartnerMapper.updatePartner(trippartnerDto);
		
	}

	@Override
	public void deletePartner(int aticleNo) throws SQLException {

		trippartnerMapper.deletePartner(aticleNo);
	}

	

}
