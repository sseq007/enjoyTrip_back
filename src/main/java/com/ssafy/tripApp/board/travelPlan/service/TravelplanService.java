package com.ssafy.tripApp.board.travelPlan.service;

import java.util.List;

import com.ssafy.tripApp.board.travelPlan.dto.LocalDto;
import com.ssafy.tripApp.board.travelPlan.dto.TravelplanDto;

public interface TravelplanService {

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
		public void writeLocal(List<LocalDto> localDto)  throws Exception;
		public void updateLocal(List<LocalDto> localDto)  throws Exception;
}
