package com.ssafy.tripApp.area.sido.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.tripApp.area.sido.dto.SidoDto;

public interface SidoService {
	List<SidoDto> sidoList() throws SQLException;
}
