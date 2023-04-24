package com.ssafy.tripApp.board.hotplace.dao;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.ssafy.tripApp.util.DBUtil;

@Repository
public class HotplaceReplyDaoImpl {
	private DataSource dataSource;
	private DBUtil dbUtil;
}
