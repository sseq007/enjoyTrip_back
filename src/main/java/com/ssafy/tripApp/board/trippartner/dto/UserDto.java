package com.ssafy.tripApp.board.trippartner.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

	@ApiModelProperty(value = "회원 아이디")
	private String userId;
	@ApiModelProperty(value = "회원 이름")
	private String userName;
	@ApiModelProperty(value = "회원 비밀번호")
	private String userPw;
	@ApiModelProperty(value = "회원 이메일 아이디")
	private String emailId;
	@ApiModelProperty(value = "회원 이메일 도메인")
	private String emailDomain;
	@ApiModelProperty(value = "회원 가입일")
	private String joinDate;
	@ApiModelProperty(value = "회원 등급")
	private int admin;
	@ApiModelProperty(value = "회원 프로필 이미지 이름")
	private String profileImage;
	@ApiModelProperty(value = "회원 프로필 이미지 주소")
	private String profileUrl;
	
	private String userNickname;
	private String birth;
	private String gender;
	private String reliability;
	private String age;
}
