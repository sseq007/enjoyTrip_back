package com.ssafy.board.dto;

import java.sql.Timestamp;

public class ShareTravelDto {
	int articleNo;
	String userId;
	String subject;
	String content;
	int hit;
	Timestamp registerTime;
		
	public ShareTravelDto() {
		super();
	}

	public ShareTravelDto(int articleNo, String userId, String subject, String content, int hit,
			Timestamp registerTime) {
		super();
		this.articleNo = articleNo;
		this.userId = userId;
		this.subject = subject;
		this.content = content;
		this.hit = hit;
		this.registerTime = registerTime;
	}
	
	public int getArticleNo() {
		return articleNo;
	}
	public void setArticleNo(int articleNo) {
		this.articleNo = articleNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public Timestamp getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(Timestamp registerTime) {
		this.registerTime = registerTime;
	}

	@Override
	public String toString() {
		return "shareTravelDto [articleNo=" + articleNo + ", userId=" + userId + ", subject=" + subject + ", content="
				+ content + ", hit=" + hit + ", registerTime=" + registerTime + "]";
	}
	
	
	
}
