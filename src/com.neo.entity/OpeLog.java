package com.neo.entity;

import java.sql.Date;


public class OpeLog {
	private String userName;
	private String logContent;
	private Date logDate;
	private String changeUser;
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getLogContent() {
		return logContent;
	}
	
	public void setLogContent(String logContent) {
		this.logContent = logContent;
	}
	
	public Date getLogDate() {
		return logDate;
	}
	public void setLogDate(Date logDate) {
		this.logDate = logDate;
	}

	public String getChangeUser() {
		return changeUser;
	}

	public void setChangeUser(String changeUser) {
		this.changeUser = changeUser;
	}
}
