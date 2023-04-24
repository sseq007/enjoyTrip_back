package com.ssafy.tripApp.board.travelPlan.dao;

import java.util.List;
import com.ssafy.tripApp.board.travelPlan.dto.TravelplanDto;


public interface TravelplanDao {
	public void writePlan(TravelplanDto travelPlanDto) throws Exception;
	public List<TravelplanDto> list() throws Exception;
	public TravelplanDto readPlan(int articleNo) throws Exception;
	public List<TravelplanDto> areaList(String area) throws Exception;
	public void update(TravelplanDto travelPlanDto) throws Exception;
	public void delete(TravelplanDto travelPlanDto) throws Exception;
}
