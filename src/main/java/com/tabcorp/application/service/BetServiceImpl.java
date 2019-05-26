package com.tabcorp.application.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tabcorp.application.dao.BetRepository;
import com.tabcorp.application.entity.Bet;
import com.tabcorp.application.model.AggregateResultsModel;
import com.tabcorp.application.model.BetModel;

@Service
@Transactional
public class BetServiceImpl implements BetService{
	
	
	@Autowired
	BetRepository betRepository;
	
	 
	public Long createBet(BetModel betModel) {
		Bet bet = betRepository.save(this.convertToEntity(betModel));
		return bet.getId();
	}
	
	public Bet convertToEntity(BetModel betModel) {
		Bet bet= new Bet();
		bet.setBetType(betModel.getBetType());
		bet.setCustomerID(betModel.getCustomerID());
		bet.setDateTime(betModel.getDateTime());
		bet.setInvestment(betModel.getInvestment());
		bet.setPropNumber(betModel.getPropNumber());
		return bet;	
	}
	
	public List<AggregateResultsModel> getTotalInvestmentPerBetType() {
		return betRepository.getTotalInvestmentPerBetType();	 
	}

	public List<AggregateResultsModel> getTotalInvestmentPerCustomerID() {
		return betRepository.getTotalInvestmentPerCustomerID();
	}
	
	public List<AggregateResultsModel> getTotalBetsSoldPerBetType() {
		return betRepository.getTotalBetsSoldPerBetType();
	}

	public List<Bet> getTotalNumberOfBetsSoldPerHour(LocalDateTime fromDate, LocalDateTime toDate) {
		return betRepository.getTotalNumberOfBetsSoldPerHour(fromDate, toDate);
	}
	
}
