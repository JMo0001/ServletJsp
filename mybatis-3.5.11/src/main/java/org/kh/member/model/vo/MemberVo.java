package org.kh.member.model.vo;

import java.sql.Date;

public class MemberVo {

	/*
	 * USER_NO NUMBER PRIMARY KEY,
	 * USER_ID VARCHAR2(20) NOT NULL,
	 * USER_PW VARCHAR2(20) NOT NULL,
	 * USER_NAME VARCHAR2(20) NOT NULL,
	 * USER_ADDR VARCHAR(50) NOT NULL,
	 * REG_DATE DATE DEFAULT SYSDATE
	 */
	
	private int userNo;
	private String nuserId;
	private String userPw;
	private String userName;
	private String userAddr;
	private Date regDate;
	
	@Override
	public String toString() {
		return "MemberVo [userNo=" + userNo + ", nuserId=" + nuserId + ", userPw=" + userPw + ", userName=" + userName
				+ ", userAddr=" + userAddr + ", regDate=" + regDate + "]";
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getNuserId() {
		return nuserId;
	}
	public void setNuserId(String nuserId) {
		this.nuserId = nuserId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserAddr() {
		return userAddr;
	}
	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	
	
}
