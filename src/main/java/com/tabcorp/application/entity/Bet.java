package com.tabcorp.application.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import com.tabcorp.application.model.BetType;

@Entity
public class Bet {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Long customerID;	
	
	@NotNull
	@Max(value=20000, message="Investment should not exceed 20000")
	private Float investment;
	
	@NotNull
	private Long propNumber;
	
	@NotNull
	private BetType betType;
	
	@NotNull
	private LocalDateTime dateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCustomerID() {
		return customerID;
	}

	public void setCustomerID(Long customerID) {
		this.customerID = customerID;
	}

	public Float getInvestment() {
		return investment;
	}

	public void setInvestment(Float investment) {
		this.investment = investment;
	}

	public Long getPropNumber() {
		return propNumber;
	}

	public void setPropNumber(Long propNumber) {
		this.propNumber = propNumber;
	}

	public BetType getBetType() {
		return betType;
	}

	public void setBetType(BetType betType) {
		this.betType = betType;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	
}

