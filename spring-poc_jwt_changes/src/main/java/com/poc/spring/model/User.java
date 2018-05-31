package com.poc.spring.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.poc.spring.Audit.UserDateAudit;

@Entity
@Table
public class User extends DateAudit implements Serializable 
{
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
 private Long id;
	


	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	    @Column(unique=true)
	    private String uid;
	
	 @ManyToMany(fetch = FetchType.LAZY)
	    @JoinTable(name = "user_roles",
	            joinColumns = @JoinColumn(name = "user_id"),
	            inverseJoinColumns = @JoinColumn(name = "role_id"))
	    private List<Role> roles = new ArrayList<>();


public User(String uid, String password) {
		super();
		this.uid = uid;
		this.password = password;
	}

public String getUid() {
	return uid;
}

public void setUid(String uid) {
	this.uid = uid;
}

public User() {
}

	


	public List<Role> getRoles() {
	return roles;
}

public void setRoles(List<Role> roles) {
	this.roles = roles;
}




	private String password;

	@JsonManagedReference
	@JsonIgnoreProperties
    @OneToMany(cascade = {CascadeType.ALL,CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE}, mappedBy = "user")
    @Column(nullable = false)
    private List<Notification> notification;

	

	  public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public List<Notification> getNotification() {
		return notification;
	}



	public void setNotification(List<Notification> notification) {
		this.notification = notification;
	}





	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}
	


}
