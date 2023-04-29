package com.ssafy.tripApp.board.travelPlan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.tripApp.board.travelPlan.dto.TravelplanDto;
import com.ssafy.tripApp.board.travelPlan.mapper.TravelPlanMapper;

import lombok.RequiredArgsConstructor;

@Service
public class TravelplanServiceImpl implements TravelplanService {

	@Autowired
	private TravelPlanMapper travelplanMapper;
	
	public TravelplanServiceImpl(TravelPlanMapper travelplanMapper) {
		super();
		this.travelplanMapper = travelplanMapper;
	}

	@Override
	public void writePlan(TravelplanDto travelPlanDto) throws Exception {
		
		
	}

	@Override
	public List<TravelplanDto> listPlan() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updatePlan(TravelplanDto travelPlanDto) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePlan(TravelplanDto travelPlanDto) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TravelplanDto viewPlan(int articleNo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TravelplanDto> areaList(String area) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
