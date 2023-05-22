package com.ssafy.tripApp.area.sido.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.tripApp.area.sido.dto.SidoDto;

@Mapper
public interface SidoMapper {
	List<SidoDto> sidoList() throws SQLException;
}
