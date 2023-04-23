package member.dto;

import java.sql.Timestamp;

public class MemberDto {
	private String userName;
	private String userId;
	private String userPw;
	private String emailId;
	private String emailDomain;
	private String joinDate;

	@Override
	public String toString() {
		return "MemberDto [userName=" + userName + ", userId=" + userId + ", userPw=" + userPw + ", emailId=" + emailId
				+ ", emailDomain=" + emailDomain + ", joinDate=" + joinDate + "]";
	}

	public MemberDto(String userName, String userId, String userPw, String emailId, String emailDomain,
			String joinDate) {
		super();
		this.userName = userName;
		this.userId = userId;
		this.userPw = userPw;
		this.emailId = emailId;
		this.emailDomain = emailDomain;
		this.joinDate = joinDate;
	}

	public String getJoinDate() {
		return joinDate;
	}

	public void getJoinDate(String string) {
		this.joinDate = string;
	}

	public MemberDto() {
		super();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getEmailDomain() {
		return emailDomain;
	}

	public void setEmailDomain(String emailDomain) {
		this.emailDomain = emailDomain;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
		
	}

}
