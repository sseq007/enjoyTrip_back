package com.ssafy.travel.domain.hotplace;

public class hotplaceDTO {

	private int articleNo;
	private String user_id;
	private String subject;
	private String content;
	private String imageUrl;
	private String hotple_name;
	private String register_time;
	private int heart_count;
	private int sido_code;
	
	public hotplaceDTO() {
		super();
	}
	public hotplaceDTO(int articleNo, String user_id, String subject, String content, String imageUrl, String hotple_name,
			String register_time, int heart_count, int sido_code) {
		super();
		this.articleNo = articleNo;
		this.user_id = user_id;
		this.subject = subject;
		this.content = content;
		this.imageUrl = imageUrl;
		this.hotple_name = hotple_name;
		this.register_time = register_time;
		this.heart_count = heart_count;
		this.sido_code = sido_code;
	}
	public int getArticleNo() {
		return articleNo;
	}
	public void setArticleNo(int articleNo) {
		this.articleNo = articleNo;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
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
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getHotple_name() {
		return hotple_name;
	}
	public void setHotple_name(String hotple_name) {
		this.hotple_name = hotple_name;
	}
	public String getRegister_time() {
		return register_time;
	}
	public void setRegister_time(String register_time) {
		this.register_time = register_time;
	}
	public int getHeart_count() {
		return heart_count;
	}
	public void setHeart_count(int heart_count) {
		this.heart_count = heart_count;
	}
	public int getSido_code() {
		return sido_code;
	}
	public void setSido_code(int sido_code) {
		this.sido_code = sido_code;
	}
	@Override
	public String toString() {
		return "hotplace [articleNo=" + articleNo + ", user_id=" + user_id + ", subject=" + subject + ", content="
				+ content + ", imageUrl=" + imageUrl + ", hotple_name=" + hotple_name + ", register_time="
				+ register_time + ", heart_count=" + heart_count + ", sido_code=" + sido_code + "]";
	}
	
	
}
