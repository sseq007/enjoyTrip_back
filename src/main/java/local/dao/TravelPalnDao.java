package com.ssafy.board.dao;

import java.util.List;

import com.ssafy.board.dto.TravelPlanDto;

public interface TravelPalnDao {
	public void writePlan(TravelPlanDto travelPlanDto) throws Exception;
	public List<TravelPlanDto> list() throws Exception;
	public TravelPlanDto readPlan(int articleNo) throws Exception;
	public List<TravelPlanDto> areaList(String area) throws Exception;
	public void update(TravelPlanDto travelPlanDto) throws Exception;
	public void delete(TravelPlanDto travelPlanDto) throws Exception;
}
