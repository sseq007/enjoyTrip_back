package com.ssafy.tripApp.board.hotplace.dao;

import java.sql.SQLException;
import java.util.List;
import com.ssafy.tripApp.board.hotplace.dto.HotplaceDto;



public interface HotplaceDao {
	//핫플 등록
	void registHotplace(HotplaceDto hotplaceDto)throws SQLException;
	//핫플 수정
	void modifyHotplace(HotplaceDto hotplaceDto)throws SQLException;
	//핫플 삭제
	void deleteHotplace(int articleNo)throws SQLException;
	//핫플 목록
	List<HotplaceDto> listhotplace() throws SQLException;
	//핫플 목록 가져오기
	HotplaceDto getHotplace(int articleNo) throws SQLException;
	//지역 정보 가져오기
	public List<HotplaceDto> areaList(String area) throws Exception;
}
