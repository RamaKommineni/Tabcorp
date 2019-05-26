package com.tabcorp.application.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tabcorp.application.entity.Bet;
import com.tabcorp.application.model.AggregateResultsModel;
import com.tabcorp.application.model.BetModel;


@Service
public interface BetService {
	
	Bet convertToEntity(BetModel betModel);
	Long createBet(BetModel betModel);
	
	List<AggregateResultsModel> getTotalInvestmentPerBetType();
	List<AggregateResultsModel> getTotalInvestmentPerCustomerID();
	List<AggregateResultsModel> getTotalBetsSoldPerBetType();
	List<Bet> getTotalNumberOfBetsSoldPerHour(LocalDateTime fromDate, LocalDateTime toDate);
	//List<BetModel> addAllBets(List<BetModel> bets);
	 
	 
}
 