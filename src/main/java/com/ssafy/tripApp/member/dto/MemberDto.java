package com.ssafy.tripApp.member.dto;

import java.sql.Timestamp;

import com.ssafy.tripApp.board.hotplace.dto.HotplaceReplyDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MemberDto {
	private String userName;
	private String userId;
	private String userPw;
	private String emailId;
	private String emailDomain;
	private String joinDate;
	private int admin;
	private String profileImage;
	private String profileUrl;
}
