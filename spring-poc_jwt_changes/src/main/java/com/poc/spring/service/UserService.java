package com.poc.spring.service;



import java.util.List;
import java.util.UUID;

import com.poc.spring.model.User;



public interface UserService {
	
	User findById(long id);
	
	User findByUid(String uid);
	

	
}
