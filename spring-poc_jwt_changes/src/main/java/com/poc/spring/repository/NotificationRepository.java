package com.poc.spring.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poc.spring.model.Notification;
import com.poc.spring.model.User;

@Repository
public interface NotificationRepository extends JpaRepository<Notification,Long>
{ 
/*	 Page<Notification> findByUserId(Long uid, Pageable pageable);	
*/	

List<Notification> findByUserId(Long uid);



void deleteByUser(User user);
Notification findById(long id);
}