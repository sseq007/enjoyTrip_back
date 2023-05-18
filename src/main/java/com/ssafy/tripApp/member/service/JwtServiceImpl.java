package com.ssafy.tripApp.member.service;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.ssafy.tripApp.member.exception.UnAuthorizedException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtServiceImpl implements JwtService {
	public static final Logger logger = LoggerFactory.getLogger(JwtServiceImpl.class);
	
	private static final String SALT = "ssafySecret";
	private static final int ACCESS_TOKEN_EXPIRE_MINUTES = 1;
	private static final int REFRESH_TOKEN_EXPIRE_MINUTES = 2;

	@Override
	public <T> String createAccessToken(String key, T data) {
		return create(key, data, "access-token", 1000 * 60 * ACCESS_TOKEN_EXPIRE_MINUTES);
	}

	@Override
	public <T> String createRefreshToken(String key, T data) {
		return create(key, data, "refresh-token", 1000 * 60* 60 * 24 * 7 * REFRESH_TOKEN_EXPIRE_MINUTES);
	}
	
	// TOKEN 발급
	/*
	 * key : Claim에 셋팅될 key 값
	 * data : Claim에 셋팅 될 data 값
	 * subject : payload에 sub의 value로 들어갈 subject값
	 * expire : 토큰 유효기간 설정을 위한 값
	 * jwt 토큰의 구성 : header+payload+signature
	 */ 

	@Override
	public <T> String create(String key, T data, String subject, long expire) {
		// Payload 설정: 생성일(IssuedAt), 유효기간(Expiration), 토큰 제목(Subject), 데이터(Claim) 등 정보 세팅
		Claims claims = Jwts.claims()
				// 토큰 제목 설정 ex) access-token, refresh-token
				.setSubject(subject)
				// 생성일 설정
				.setIssuedAt(new Date())
				// 만료일 설정(유효기간)
				.setExpiration(new Date(System.currentTimeMillis()+expire));
		
		// 저장할 data의 key, value
		claims.put(key, data);
		
		String jwt = Jwts.builder()
				// Header 설정: 토큰의 타입, 해시 알고리즘 정보 세팅
				.setHeaderParam("typ", "JWT")
				.setClaims(claims)
				// Signature 설정: secret key를 활용한 암호화
				.signWith(SignatureAlgorithm.HS256, this.generateKey())
				.compact();
		
		return jwt;
	}
	
	// Signature 설정에 들어갈 key 생성
	private byte[] generateKey() {
		byte[] key = null;
		try {
			// charset 설정 안 하면 사용자 플랫폼의 기본 인코딩 설정으로 인코딩됨
			key = SALT.getBytes("UTF-8");
		}catch(UnsupportedEncodingException e) {
			if(logger.isInfoEnabled()) {
				e.printStackTrace();
			}else {
				logger.error("Making JWT Key Error ::: {}", e.getMessage());
			}
		}
		
		return key;
	}

	@Override
	public Map<String, Object> get(String key) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
				.getRequest();
		String jwt = request.getHeader("access-token");
		Jws<Claims> claims = null;
		try {
			claims = Jwts.parser().setSigningKey(SALT.getBytes("UTF-8")).parseClaimsJws(jwt);
		}catch (Exception e) {
//			if(logger.isInfoEnabled()) {
//				e.printStackTrace();
//			}else {
				logger.error(e.getMessage());
//			}
			throw new UnAuthorizedException();
			
//			개발환경
//			Map<String, Object> testMap = new HashMap<>();
//			testMap.put("userid", userid);
//			return testMap;
		}
		Map<String, Object> value = claims.getBody();
		logger.info("value: {}", value);
		return value;
	}

	@Override
	public String getUserId() {
		return (String) this.get("user").get("userId");
	}

	@Override
	public boolean checkToken(String jwt) {
		try {
//			Json Web Signature? 서버에서 인증을 근거로 인증 정보를 서버의 private key로 서명한 것을 토큰화한 것
//			setSigningKey: JWS 서명 검증을 위한 secret key 세팅
//			setClaimsJws: 파싱하여 원본 jws 만들기
			Jws<Claims> claims = Jwts.parser().setSigningKey(this.generateKey()).parseClaimsJws(jwt);
//			Claims는 Map의 구현체 형태
			logger.debug("claims: {}", claims);
			return true;
		}catch(Exception e) {
//			if(logger.isInfoEnabled()) {
//				e.printStackTrace();
//			}else {
				logger.error(e.getMessage());
//			}
//			throw new UnAuthorizedException();
//			개발환경
			return false;
		}

	}

}
