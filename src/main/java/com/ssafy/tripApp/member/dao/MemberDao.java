package com.ssafy.tripApp.member.dao;

import java.util.List;

import com.ssafy.tripApp.member.dto.MemberDto;

public interface MemberDao {
	MemberDto login(String id, String pw) throws Exception;
	void memberInsert(MemberDto m) throws Exception;
	void memberDelete(String id) throws Exception;
	void memberUpdate(MemberDto m) throws Exception;
	void idCheck(String id) throws Exception;
	List<MemberDto> memberList() throws Exception;
	MemberDto memberSearch(String id) throws Exception;
}
