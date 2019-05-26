package com.tabcorp.application.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.ToString;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "email")})
public class User {
	
    public enum Role {USER, ADMIN, USER_MANAGER}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    @Email
    private String email;

    @JsonIgnore
   // @ToString.Exclude
    private String password;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Role role;

    private Double minBetsPerDay;
    
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
    
	public User(Long id, @NotEmpty @Email String email, String password, @NotNull Role role, Double minBetsPerDay) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.role = role;
		this.minBetsPerDay = minBetsPerDay;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}


	public Double getMinBetsPerDay() {
		return minBetsPerDay;
	}


	public void setMinBetsPerDay(Double minBetsPerDay) {
		this.minBetsPerDay = minBetsPerDay;
	}



	
    
    
}