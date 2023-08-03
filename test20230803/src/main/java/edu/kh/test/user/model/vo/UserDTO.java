package edu.kh.test.user.model.vo;

public class UserDTO {


//			USER_NO NUMBER PRIMARY KEY,
//
//			USER_ID VARCHAR2(50) UNIQUE NOT NULL,
//
//			USER_NAME VARCHAR2(50) NOT NULL,
//
//			USER_AGE NUMBER NOT NULL
	
	private int userNo;
	private String userId;
	private String userName;
	private int UserAge;
	
	
	
	public UserDTO() {
		super();
	}


	public UserDTO(int userNo, String userId, String userName, int userAge) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userName = userName;
		UserAge = userAge;
	}


	@Override
	public String toString() {
		return "UserDTO [userNo=" + userNo + ", userId=" + userId + ", userName=" + userName + ", UserAge=" + UserAge
				+ "]";
	}


	public int getUserNo() {
		return userNo;
	}


	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public int getUserAge() {
		return UserAge;
	}


	public void setUserAge(int userAge) {
		UserAge = userAge;
	}
	
	
	
}
