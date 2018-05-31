package com.poc.spring.controller;

import java.sql.Time;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.poc.spring.Audit.UserDateAudit;
import com.poc.spring.model.User;
import com.poc.spring.payload.UserIdentityAvailability;
import com.poc.spring.payload.UserProfile;
import com.poc.spring.payload.UserSummary;
import com.poc.spring.repository.UserRepository;
import com.poc.spring.security.CurrentUser;
import com.poc.spring.security.UserPrincipal;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserRepository userRepository;


	@GetMapping("/users/me")
	@PreAuthorize("hasRole('USER')")
	public UserSummary getCurrentUser(@CurrentUser UserPrincipal currentUser) {
		UserSummary userSummary = new UserSummary(currentUser.getId(), currentUser.getUUID());
		return userSummary;
	}

	

}


