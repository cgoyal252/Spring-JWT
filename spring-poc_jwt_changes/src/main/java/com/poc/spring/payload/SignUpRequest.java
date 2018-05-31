package com.poc.spring.payload;

import java.util.UUID;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class SignUpRequest {

    private String uid;
    @NotBlank
    @Size(min = 3, max = 20)
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
