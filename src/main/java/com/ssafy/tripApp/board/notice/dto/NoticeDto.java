package com.ssafy.tripApp.board.notice.dto;

public class NoticeDto {

	private int articleNo;
	private String userId;
	private String subject;
	private String contnet;
	private String register_time;
	
	
	public NoticeDto() {
		super();
	}
	public NoticeDto(int articleNo, String userId, String subject, String contnet, String register_time) {
		super();
		this.articleNo = articleNo;
		this.userId = userId;
		this.subject = subject;
		this.contnet = contnet;
		this.register_time = register_time;
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
	public String getContnet() {
		return contnet;
	}
	public void setContnet(String contnet) {
		this.contnet = contnet;
	}
	public String getRegister_time() {
		return register_time;
	}
	public void setRegister_time(String register_time) {
		this.register_time = register_time;
	}
	@Override
	public String toString() {
		return "notice [articleNo=" + articleNo + ", userId=" + userId + ", subject=" + subject + ", contnet=" + contnet
				+ ", register_time=" + register_time + "]";
	}
	
	
	
}
