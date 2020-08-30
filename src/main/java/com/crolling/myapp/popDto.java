package com.crolling.myapp;

public class popDto {

	private String sender;
	
	private String recevier;
	
	private String subject;
	
	private String sendDate;
	
	private float size;
	
	private String text;
	
	
	public popDto(String sender, String recevier,String subject, String sendDate, float size, String text) {
		
		this.sender = sender;
		this.recevier=recevier;
		this.subject = subject;
		this.sendDate = sendDate;
		this.size = size;
		this.text = text;
	}

	public String getRecevier() {
		return recevier;
	}

	public void setRecevier(String recevier) {
		this.recevier = recevier;
	}
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getSendDate() {
		return sendDate;
	}

	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}

	public float getSize() {
		return size;
	}

	public void setSize(float size) {
		this.size = size;
	}
	
}
