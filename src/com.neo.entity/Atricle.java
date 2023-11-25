package com.neo.entity;

import java.sql.Date;

public class Atricle {
	private String type;
	private String content;
	private String artTitle;
	private String userName;
	private int artId;
	private int typeId;
	private Date pubDate;
	private Date modiDate;
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getArtTitle() {
		return artTitle;
	}
	public void setArtTitle(String artTitle) {
		this.artTitle = artTitle;
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

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public Date getPubDate() {
		return pubDate;
	}

	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}

	public Date getModiDate() {
		return modiDate;
	}

	public void setModiDate(Date modiDate) {
		this.modiDate = modiDate;
	}
}
