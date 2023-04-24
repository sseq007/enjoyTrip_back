package com.ssafy.tripApp.board.hotplace.dto;

public class HeartCommentDto {

	private int articleNo;
	private String userId;
	private String check;
	
	public HeartCommentDto() {
		super();
	}
	public HeartCommentDto(int articleNo, String userId, String check) {
		super();
		this.articleNo = articleNo;
		this.userId = userId;
		this.check = check;
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
	public String getCheck() {
		return check;
	}
	public void setCheck(String check) {
		this.check = check;
	}
	@Override
	public String toString() {
		return "heartComment [articleNo=" + articleNo + ", userId=" + userId + ", check=" + check + "]";
	}
	
	
}
