package com.ssafy.tripApp.board.travelPlan.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.tripApp.board.travelPlan.dto.LocalDto;
import com.ssafy.tripApp.board.travelPlan.dto.TravelplanDto;

@Mapper
public interface TravelPlanMapper {
	//플랜쓰기
	public void writePlan(TravelplanDto travelPlanDto) throws Exception;
	//플랜리스트
	public List<TravelplanDto> listPlan() throws Exception;
	//플랜수정
	public void updatePlan(TravelplanDto travelPlanDto) throws Exception;
	//플랜삭제
	public void deletePlan(int articleNo) throws Exception;
	//플랜가져오기
	public TravelplanDto viewPlan(int articleNo) throws Exception;
	public List<LocalDto> areaList(String word) throws Exception;
	public List<LocalDto> localList(int articleNo) throws Exception;
	
}
