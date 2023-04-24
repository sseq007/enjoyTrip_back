package com.ssafy.tripApp.board.travelPlan.dao;

import javax.sql.DataSource;
import org.springframework.stereotype.Repository;
import com.ssafy.tripApp.util.DBUtil;

@Repository
public class TravelplanDaoImpl {
	private DataSource dataSource;
	private DBUtil dbUtil;
}
