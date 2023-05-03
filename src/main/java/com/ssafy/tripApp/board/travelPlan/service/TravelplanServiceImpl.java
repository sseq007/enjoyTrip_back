package com.ssafy.tripApp.board.travelPlan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.tripApp.board.travelPlan.dto.LocalDto;
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
		
		travelplanMapper.writePlan(travelPlanDto);
	}

	@Override
	public List<TravelplanDto> listPlan() throws Exception {
		// TODO Auto-generated method stub
		return travelplanMapper.listPlan();
	}

	@Override
	public void updatePlan(TravelplanDto travelPlanDto) throws Exception {
		// TODO Auto-generated method stub
		travelplanMapper.updatePlan(travelPlanDto);
	}

	@Override
	public void deletePlan(int articleNo) throws Exception {
		travelplanMapper.deletePlan(articleNo);
		
	}

	@Override
	public TravelplanDto viewPlan(int articleNo) throws Exception {
		return travelplanMapper.viewPlan(articleNo);
	}

	@Override
	public List<LocalDto> areaList(String word) throws Exception {
		// TODO Auto-generated method stub
		return travelplanMapper.areaList(word);
	}

}
