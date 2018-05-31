package com.poc.spring.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.poc.spring.Exception.AppException;
import com.poc.spring.model.Role;
import com.poc.spring.model.RoleName;
import com.poc.spring.model.User;
import com.poc.spring.payload.ApiResponse;
import com.poc.spring.payload.JwtAuthenticationResponse;
import com.poc.spring.payload.LoginRequest;
import com.poc.spring.payload.SignUpRequest;
import com.poc.spring.repository.RoleRepository;
import com.poc.spring.repository.UserRepository;
import com.poc.spring.security.JwtTokenProvider;

import javax.validation.Valid;
import java.net.URI;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;


/*
 * 
 *  Created by chirag   13/5/18  and updated redis property on 15/5
 */


@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	JwtTokenProvider tokenProvider;

	@Autowired
	private RedisTemplate<String, String> template;              //For saving value in redis 

	@Autowired
	private ObjectMapper objectMapper;                         // it map object into redis 

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) throws JsonProcessingException {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						loginRequest.getUid(),
						loginRequest.getPassword()
						)
				);

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = tokenProvider.generateToken(authentication);
		template.opsForValue().set(jwt, objectMapper.writeValueAsString(authentication));              //to save access token in redis
		return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
	}
	@GetMapping("/users")
	public List<User> getAllUsers() {


		return userRepository.findAll();
	}

	@SuppressWarnings("unchecked")
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
		if(userRepository.existsById(signUpRequest.getUid())) {
			return new ResponseEntity(new ApiResponse(false, "UUID is already taken!"),
					HttpStatus.BAD_REQUEST);
		}



		// Creating user's account
		User user = new User(signUpRequest.getUid(),signUpRequest.getPassword());

		user.setUid(UUID.randomUUID().toString());

		user.setPassword(passwordEncoder.encode(user.getPassword()));

		Role userRole = roleRepository.findByName(RoleName.ROLE_USER);
		/*.orElseThrow(() -> new AppException("User Role not set."));
		 */
		user.setRoles(Arrays.asList(roleRepository.findByName(RoleName.ROLE_USER)));
		System.out.println(user.getUid());
		User result = userRepository.save(user);

		URI location = ServletUriComponentsBuilder
				.fromCurrentContextPath().path("/users/{uid}")
				.buildAndExpand(result.getUid()).toUri();
System.out.println(location.toString());
		return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));
	}



}