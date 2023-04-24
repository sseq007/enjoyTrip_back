package com.ssafy.tripApp.board.hotplace.dto;

public class HotplaceReplyDto {

	private String replyNo;
	private String articleNo;
	private String userId;
	private String content;
	private String register_time;
	private int reply_depth;

	public HotplaceReplyDto() {
		super();
	}
	
	public HotplaceReplyDto(String replyNo, String articleNo, String userId, String content, String register_time,
			int reply_depth) {
		super();
		this.replyNo = replyNo;
		this.articleNo = articleNo;
		this.userId = userId;
		this.content = content;
		this.register_time = register_time;
		this.reply_depth = reply_depth;
	}

	public String getReplyNo() {
		return replyNo;
	}

	public void setReplyNo(String replyNo) {
		this.replyNo = replyNo;
	}

	public String getArticleNo() {
		return articleNo;
	}

	public void setArticleNo(String articleNo) {
		this.articleNo = articleNo;
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

	public String getRegister_time() {
		return register_time;
	}

	public void setRegister_time(String register_time) {
		this.register_time = register_time;
	}

	public int getReply_depth() {
		return reply_depth;
	}

	public void setReply_depth(int reply_depth) {
		this.reply_depth = reply_depth;
	}

	@Override
	public String toString() {
		return "hotplaceReply [replyNo=" + replyNo + ", articleNo=" + articleNo + ", userId=" + userId + ", content="
				+ content + ", register_time=" + register_time + ", reply_depth=" + reply_depth + "]";
	}
	
	
}
