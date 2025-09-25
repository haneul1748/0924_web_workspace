package com.kh.java.member.model.vo;

import java.sql.Date;
import java.util.Objects;

public class Member {
	
	// int vs long
	// long vs Long
	
	private Long userNO;
	private String userId;
	private String userPwd; 
	private String userName;
	private String eamil;
	private Date enrollDate;
	private Date modifyDate;
	private String status;
	
	
	public Member() {
		super();
	}
	public Member(Long userNO, String userId, String userPwd, String userName, String eamil, Date enrollDate,
			Date modifyDate, String status) {
		super();
		this.userNO = userNO;
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.eamil = eamil;
		this.enrollDate = enrollDate;
		this.modifyDate = modifyDate;
		this.status = status;
	}
	public Long getUserNO() {
		return userNO;
	}
	public void setUserNO(Long userNO) {
		this.userNO = userNO;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEamil() {
		return eamil;
	}
	public void setEamil(String eamil) {
		this.eamil = eamil;
	}
	public Date getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(eamil, enrollDate, modifyDate, status, userId, userNO, userName, userPwd);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		return Objects.equals(eamil, other.eamil) && Objects.equals(enrollDate, other.enrollDate)
				&& Objects.equals(modifyDate, other.modifyDate) && Objects.equals(status, other.status)
				&& Objects.equals(userId, other.userId) && Objects.equals(userNO, other.userNO)
				&& Objects.equals(userName, other.userName) && Objects.equals(userPwd, other.userPwd);
	}
	@Override
	public String toString() {
		return "Member [userNO=" + userNO + ", userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName
				+ ", eamil=" + eamil + ", enrollDate=" + enrollDate + ", modifyDate=" + modifyDate + ", status="
				+ status + "]";
	}
	
}
