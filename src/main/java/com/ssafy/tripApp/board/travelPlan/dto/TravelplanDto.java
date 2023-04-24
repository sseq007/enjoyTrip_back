package com.ssafy.tripApp.board.travelPlan.dto;

import java.sql.Timestamp;

public class TravelplanDto {
	int articleNo;
	int contentId;
	String userId;
	String subject;
	double starCount;
	Timestamp startDate;
	Timestamp endDate;
	Timestamp registerTime;
		
	public TravelplanDto() {
		super();
	}

	public TravelplanDto(int articleNo, int contentId, String userId, String subject, double starCount,
			Timestamp startDate, Timestamp endDate, Timestamp registerTime) {
		super();
		this.articleNo = articleNo;
		this.contentId = contentId;
		this.userId = userId;
		this.subject = subject;
		this.starCount = starCount;
		this.startDate = startDate;
		this.endDate = endDate;
		this.registerTime = registerTime;
	}

	public int getArticleNo() {
		return articleNo;
	}

	public void setArticleNo(int articleNo) {
		this.articleNo = articleNo;
	}

	public int getContentId() {
		return contentId;
	}

	public void setContentId(int contentId) {
		this.contentId = contentId;
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

	public double getStarCount() {
		return starCount;
	}

	public void setStarCount(double starCount) {
		this.starCount = starCount;
	}

	public Timestamp getStartDate() {
		return startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public Timestamp getEndDate() {
		return endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public Timestamp getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Timestamp registerTime) {
		this.registerTime = registerTime;
	}

	@Override
	public String toString() {
		return "travelPlanDto [articleNo=" + articleNo + ", contentId=" + contentId + ", userId=" + userId
				+ ", subject=" + subject + ", starCount=" + starCount + ", startDate=" + startDate + ", endDate="
				+ endDate + ", registerTime=" + registerTime + "]";
	}
		
}
