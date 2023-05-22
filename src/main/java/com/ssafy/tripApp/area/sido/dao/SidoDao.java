package com.ssafy.tripApp.area.sido.dao;

import java.util.List;

import com.ssafy.tripApp.area.sido.dto.SidoDto;

public interface SidoDao {
	List<SidoDto> sidoList() throws Exception;
}
