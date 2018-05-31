package com.poc.spring.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Notification implements Serializable 

{
	
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @NotNull
	    @Lob
	    private String message;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "n_id", nullable = false)
	    @JsonIgnore
	    private User user;

public void setId(Long id) {
	this.id = id;
}

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}

public Long getId() {
	return id;
}


}
