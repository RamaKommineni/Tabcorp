package com.tabcorp.application.model;

import java.time.LocalDateTime;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

public class BetModel {
	
	@NotNull(message="Customer ID cannot be Null")
	private Long customerID;
	
	@FutureOrPresent(message="DateTime can only be in Present or Future")
	@NotNull(message="LocalDateTime cannot be Null")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	private LocalDateTime dateTime;
	
	@NotNull(message="BetType cannot be Null")
	private BetType betType;
	
	@NotNull(message="propNumber cannot be Null")
	private Long propNumber;
	 
	@NotNull(message="investment cannot be Null")
	@Max(value=20000,message="Investment cannot be exceed 20000")
	private Float investment;
	
	public BetModel(@NotNull(message = "Customer ID cannot be Null") Long customerID,
			@FutureOrPresent(message = "DateTime can only be in Present or Future") @NotNull(message = "LocalDateTime cannot be Null") LocalDateTime dateTime,
			@NotNull(message = "BetType cannot be Null") BetType betType,
			@NotNull(message = "propNumber cannot be Null") Long propNumber,
			@NotNull(message = "investment cannot be Null") Float investment) {
		super();
		this.customerID = customerID;
		this.dateTime = dateTime;
		this.betType = betType;
		this.propNumber = propNumber;
		this.investment = investment;
	}

	public BetModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getCustomerID() {
		return customerID;
	}

	public void setCustomerID(Long customerID) {
		this.customerID = customerID;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public BetType getBetType() {
		return betType;
	}

	public void setBetType(BetType betType) {
		this.betType = betType;
	}

	public Long getPropNumber() {
		return propNumber;
	}

	public void setPropNumber(Long propNumber) {
		this.propNumber = propNumber;
	}

	public Float getInvestment() {
		return investment;
	}

	public void setInvestment(Float investment) {
		this.investment = investment;
	}

	@Override
	public String toString() {
		return "BetModel [customerID=" + customerID + ", dateTime=" + dateTime + ", betType=" + betType
				+ ", propNumber=" + propNumber + ", investment=" + investment + "]";
	}

	

}
