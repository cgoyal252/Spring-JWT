package com.poc.spring.payload;

import java.util.UUID;

import javax.validation.constraints.NotBlank;

public class LoginRequest {
  
    private String uid;

    @NotBlank
    private String password;



	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}