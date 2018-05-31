package com.poc.spring.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poc.spring.model.User;
import java.lang.Long;

@Repository
public interface UserRepository extends JpaRepository<User, Long>
{
 User findByUid(String uid); 
Optional<User> findById(Long id);
//boolean existsByUUID(UUID uid);

boolean existsById(String uid);
List<User> findByIdIn(List<Long> creatorIds);
		

}