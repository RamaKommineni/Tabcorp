package com.tabcorp.application.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class AggregateResultsModel {

	private BetType betType;
	private Double totalInvestment;
	private Long customerID;
	private Long betCount;

	public AggregateResultsModel() {

	}

	public AggregateResultsModel(Double totalInvestment, BetType betType) {
		this.betType = betType;
		this.totalInvestment = totalInvestment == null ? new Double(0.00) : totalInvestment;
	}

	public AggregateResultsModel(Double totalInvestment, Long customerID) {
		this.customerID = customerID;
		this.totalInvestment = totalInvestment == null ? new Double(0.00) : totalInvestment;
	}

	public AggregateResultsModel(Long betCount, BetType betType) {
		this.betCount = betCount == null ? new Long(0) : betCount;
		this.betType = betType; 
	}

	public Double getTotalInvestment() {
		return totalInvestment;
	}

	public void setTotalInvestment(Double totalInvestment) {
		this.totalInvestment = totalInvestment;
	}

	public BetType getBetType() {
		return betType;
	}

	public void setBetType(BetType betType) {
		this.betType = betType;
	}

	public Long getcustomerID() {
		return customerID;
	}

	public void setcustomerID(Long customerID) {
		this.customerID = customerID;
	}

	public Long getBetCount() {
		return betCount;
	}

	public void setBetCount(Long betCount) {
		this.betCount = betCount;
	}

}
