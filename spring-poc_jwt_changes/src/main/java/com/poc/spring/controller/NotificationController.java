package com.poc.spring.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poc.spring.model.Notification;
import com.poc.spring.model.User;
import com.poc.spring.payload.UserSummary;
import com.poc.spring.repository.NotificationRepository;
import com.poc.spring.repository.UserRepository;
import com.poc.spring.security.CurrentUser;
import com.poc.spring.security.UserPrincipal;
import com.poc.spring.service.UserServiceImpl;

@RestController
@RequestMapping("/api")
public class NotificationController {

	@Autowired
	private NotificationRepository notificationRepository;
	@Autowired
	UserServiceImpl userService;
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/users/notifications")
	public List<Notification> getAllNotificationsByPostId(@CurrentUser UserPrincipal currentUser) {
		return notificationRepository.findByUserId(currentUser.getId());
	}

  @PostMapping("/users/notifications")
    public Optional<Notification> createNotification(@CurrentUser UserPrincipal currentUser,
                                 @Valid @RequestBody Notification notification) {
        return userRepository.findById(currentUser.getId()).map(user -> {
            notification.setUser(user);
            return notificationRepository.save(notification);
        });
    }
	
	
	@GetMapping("/users")
	public UserSummary getCurrentUser(@CurrentUser UserPrincipal currentUser) {
		UserSummary userSummary = new UserSummary(currentUser.getId(), currentUser.getUUID());
		return userSummary;
	}

	@DeleteMapping("users/del/{id}")
	public ResponseEntity<Void> deleteNotification(@CurrentUser UserPrincipal currentUser,@PathVariable (value = "id") Long id) {
		
		
		if(userRepository.existsById(currentUser.getId()))   

		notificationRepository.deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
/*	@DeleteMapping("users/del/")
	public ResponseEntity<Void> deleteNotificationAll(@CurrentUser UserPrincipal currentUser) {
		
		
		if(userRepository.findById(currentUser.getId()))  

		notificationRepository.deleteAll();
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
*/
}