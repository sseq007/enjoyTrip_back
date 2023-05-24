package com.ssafy.tripApp.board.travelPlan.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

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
	public List<LocalDto> localList(int articleNo) throws Exception;
	// 최신 글번호 가져오기
	int getarticleNo() throws SQLException;
	public void updateLocal(LocalDto localDto)  throws Exception;
	public void deleteLocal(LocalDto localDto) throws Exception;
	public void writeLocal(Map<String, Object> map) throws Exception;;
}
