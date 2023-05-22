package com.ssafy.tripApp.area.sido.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.tripApp.area.sido.dto.SidoDto;
import com.ssafy.tripApp.area.sido.mapper.SidoMapper;

@Service
public class SidoServiceImpl implements SidoService {
	
	@Autowired
	private SidoMapper sidoMapper;
	
	public SidoServiceImpl(SidoMapper sidoMapper) {
		super();
		this.sidoMapper = sidoMapper;
	}
	
	@Override
	public List<SidoDto> sidoList() throws SQLException {
		// TODO Auto-generated method stub
		return sidoMapper.sidoList();
	}

}
