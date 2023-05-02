package com.ssafy.tripApp.board.hotplace.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.tripApp.board.hotplace.dto.HotplaceDto;
import com.ssafy.tripApp.board.hotplace.mapper.HotplaceMapper;

@Service
public class HotplaceServiceImpl implements HotplaceService{
	@Autowired
	private HotplaceMapper hotplaceMapper;

	public HotplaceServiceImpl(HotplaceMapper hotplaceMapper) {
		super();
		this.hotplaceMapper = hotplaceMapper;
	}

	@Override
	public List<HotplaceDto> listHotple() throws Exception {
		return hotplaceMapper.listHotple();
	}

	@Override
	public HotplaceDto viewHotple(int articleNo) throws Exception {
		return hotplaceMapper.viewHotple(articleNo);
	}

	@Override
	public void writeHotple(HotplaceDto hotplaceDto) throws Exception {

		hotplaceMapper.writeHotple(hotplaceDto);
	}

	@Override
	public void updateHotple(HotplaceDto hotplaceDto) throws Exception {
		hotplaceMapper.updateHotple(hotplaceDto);
	}

	@Override
	public void deleteHotple(HotplaceDto hotplaceDto) throws Exception {
		hotplaceMapper.deleteHotple(hotplaceDto);
	}
	
	
}
