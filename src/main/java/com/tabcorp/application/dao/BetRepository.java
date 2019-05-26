package com.tabcorp.application.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tabcorp.application.entity.Bet;
import com.tabcorp.application.model.AggregateResultsModel;

@Repository
public interface BetRepository extends JpaRepository<Bet, Float> {
	
	@Query(value = "SELECT new com.tabcorp.application.model.AggregateResultsModel(SUM(investment) as totalInvestment, betType ) FROM Bet Group by betType")
	List<AggregateResultsModel> getTotalInvestmentPerBetType();

	@Query(value = "SELECT new com.tabcorp.application.model.AggregateResultsModel(SUM(investment) as totalInvestment, customerID ) FROM Bet Group by customerID")
	List<AggregateResultsModel> getTotalInvestmentPerCustomerID();

	@Query(value = "SELECT new com.tabcorp.application.model.AggregateResultsModel(Count(*) as betCount, betType ) FROM Bet Group by betType")
	List<AggregateResultsModel> getTotalBetsSoldPerBetType();

	
	@Query(value = "SELECT b FROM Bet b where b.dateTime >= :fromDate AND b.dateTime < :toDate")
	List<Bet> getTotalNumberOfBetsSoldPerHour(LocalDateTime fromDate, LocalDateTime toDate);

}
