package com.ssafy.tripApp.member.dao;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.ssafy.tripApp.util.DBUtil;

@Repository
public class MemberDaoImpl {
	private DataSource dataSource;
	private DBUtil dbUtil;

}
