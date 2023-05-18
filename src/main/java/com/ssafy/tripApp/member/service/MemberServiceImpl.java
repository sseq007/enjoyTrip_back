package com.ssafy.tripApp.member.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.tripApp.member.dto.MemberDto;
import com.ssafy.tripApp.member.mapper.MemberMapper;

import lombok.RequiredArgsConstructor;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberMapper memberMapper;
	
	public MemberServiceImpl(MemberMapper memberMapper) {
		super();
		this.memberMapper = memberMapper;
	}

	@Override
	@Transactional
	public void registerMember(MemberDto memberDto) throws SQLException {
		
		memberMapper.registerMember(memberDto);
		
	}

	@Override
	public MemberDto login(Map<String, String> map) throws SQLException {
		return memberMapper.login(map);
	}

	@Override
	public void updateMember(MemberDto memberDto) throws SQLException {
		memberMapper.updateMember(memberDto);
		
	}

	@Override
	public void deleteMember(String userId) throws SQLException {
		memberMapper.deleteMember(userId);
		
	}

	@Override
	public int idCheck(String userId) throws SQLException {
		return memberMapper.idCheck(userId);
	}

	@Override
	public List<MemberDto> listMember() throws SQLException {
		
		return memberMapper.listMember();
	}

	@Override
	public MemberDto viewMember(String userId) throws SQLException {
		return memberMapper.viewMember(userId);
	}

	@Override
	public void saveRefreshToken(String userId, String refreshToken) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", userId);
		map.put("token", refreshToken);
		memberMapper.saveRefreshToken(map);
	}

	@Override
	public Object getRefreshToken(String userId) throws Exception {
		return memberMapper.getRefreshToken(userId);
	}

	@Override
	public void deleteRefreshToken(String userId) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", userId);
		map.put("token", null);
		memberMapper.deleteRefreshToken(map);
		
	}

}
