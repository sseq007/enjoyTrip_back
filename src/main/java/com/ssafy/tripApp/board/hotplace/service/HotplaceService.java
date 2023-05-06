package com.ssafy.tripApp.board.hotplace.service;

import java.util.List;

import com.ssafy.tripApp.board.hotplace.dto.HotplaceDto;

public interface HotplaceService {
	// 핫플 게시글 리스트
	List<HotplaceDto> listHotple() throws Exception;
	// 핫플 게시글 하나 보기
	HotplaceDto viewHotple(int articleNo) throws Exception;
	void writeHotple(HotplaceDto hotplaceDto) throws Exception;
	void updateHotple(HotplaceDto hotplaceDto) throws Exception;
	void deleteHotple(int articleNo) throws Exception;
}
