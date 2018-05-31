package com.poc.spring.payload;



public class UserSummary {
	private Long id;
	private String uid;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}


	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public UserSummary() {
		// TODO Auto-generated constructor stub
	}
	public UserSummary(Long id, String uid) {
		super();
		this.id = id;
		this.uid = uid;
	}   



}