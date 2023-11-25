package com.neo.entity;

//import java.util.Date;
import java.sql.Date;

public class Comment {
	private int commentId;
	private String userName;
	private int artId;
	private String comContent;
	private Date comDate;
	private String available;
	private int parentCom;
	
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getArtId() {
		return artId;
	}
	public void setArtId(int artId) {
		this.artId = artId;
	}
	public String getComContent() {
		return comContent;
	}
	public void setComContent(String comContent) {
		this.comContent = comContent;
	}
	public Date getComDate() {
		return comDate;
	}
	public void setComDate(Date comDate) {
		this.comDate = comDate;
	}
	public String getAvailable() {
		return available;
	}
	public void setAvailable(String available) {
		this.available = available;
	}
	public int getParentCom() {
		return parentCom;
	}
	public void setParentCom(int parentCom) {
		this.parentCom = parentCom;
	}
	
	
	
}
