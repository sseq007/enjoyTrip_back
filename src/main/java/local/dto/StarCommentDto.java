package com.ssafy.board.dto;

public class StarCommentDto {
	String userId;
	int articleNo;
	int count;	
	
	public StarCommentDto() {
	}

	public StarCommentDto(String userId, int articleNo, int count) {
		super();
		this.userId = userId;
		this.articleNo = articleNo;
		this.count = count;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getArticleNo() {
		return articleNo;
	}

	public void setArticleNo(int articleNo) {
		this.articleNo = articleNo;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "starCommentDto [userId=" + userId + ", articleNo=" + articleNo + ", count=" + count + "]";
	}
}
