package com.ssafy.tripApp.board.Sharetravel.dto;

import java.sql.Timestamp;

public class ShareReplyDto {
	int articleNo;
	int replyDepth;
	String userId;
	String content;
	Timestamp registerTime;
	
	public ShareReplyDto() {
		super();
	}

	public ShareReplyDto(int articleNo, int replyDepth, String userId, String content, Timestamp registerTime) {
		super();
		this.articleNo = articleNo;
		this.replyDepth = replyDepth;
		this.userId = userId;
		this.content = content;
		this.registerTime = registerTime;
	}

	public int getArticleNo() {
		return articleNo;
	}

	public void setArticleNo(int articleNo) {
		this.articleNo = articleNo;
	}

	public int getReplyDepth() {
		return replyDepth;
	}

	public void setReplyDepth(int replyDepth) {
		this.replyDepth = replyDepth;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Timestamp registerTime) {
		this.registerTime = registerTime;
	}

	@Override
	public String toString() {
		return "shareReplyDto [articleNo=" + articleNo + ", replyDepth=" + replyDepth + ", userId=" + userId
				+ ", content=" + content + ", registerTime=" + registerTime + "]";
	}
		
}
