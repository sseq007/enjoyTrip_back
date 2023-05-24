package com.ssafy.tripApp.member.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.tripApp.member.dto.MemberDto;

public interface MemberService {

	//회원가입
	void registerMember(MemberDto memberDto) throws SQLException;
	//로그인
	MemberDto login(Map<String, String> map) throws SQLException;
	//회원수정
	void updateMember(MemberDto memberDto) throws SQLException;
	//회원삭제
	void deleteMember(String userId) throws SQLException;
	//아이디체크
	int idCheck(String userId) throws SQLException;
	//회원리스트
	List<MemberDto> listMember() throws SQLException;
	//회원정보
	MemberDto viewMember(String userId) throws SQLException;
	void saveRefreshToken(String userId, String refreshToken) throws Exception;
	Object getRefreshToken(String userId) throws Exception;
	void deleteRefreshToken(String userId) throws Exception;
	int nicknameCheck(String userNickname) throws SQLException;
}
