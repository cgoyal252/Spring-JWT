package com.poc.spring.payload;

import java.time.Instant;
import java.util.UUID;

public class UserProfile {
    private Long id;
  private String uid;
    private Instant joinedAt;
    private Long pollCount;


   

    public UserProfile(Long id, String uid, Instant joinedAt, Long pollCount) {
		this.id = id;
		this.uid = uid;
		this.joinedAt = joinedAt;
		this.pollCount = pollCount;
		
	}

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

	public Instant getJoinedAt() {
        return joinedAt;
    }

    public void setJoinedAt(Instant joinedAt) {
        this.joinedAt = joinedAt;
    }

    public Long getPollCount() {
        return pollCount;
    }

    public void setPollCount(Long pollCount) {
        this.pollCount = pollCount;
    }

 
}