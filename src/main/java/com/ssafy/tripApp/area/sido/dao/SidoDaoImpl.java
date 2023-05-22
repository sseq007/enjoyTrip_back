package com.ssafy.tripApp.area.sido.dao;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.ssafy.tripApp.util.DBUtil;

@Repository
public class SidoDaoImpl {
	private DataSource dataSource;
	private DBUtil dbUtil;
}
