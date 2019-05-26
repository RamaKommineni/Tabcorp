package com.tabcorp.tests;


import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.tabcorp.application.dao.BetRepository;
import com.tabcorp.application.entity.Bet;
import com.tabcorp.application.model.AggregateResultsModel;
import com.tabcorp.application.model.BetModel;
import com.tabcorp.application.model.BetType;
import com.tabcorp.application.service.BetServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class BetServiceMockTest {
	
	@Mock
	BetRepository betRepository;
	
	@InjectMocks
	BetServiceImpl betServiceImpl;
	
	@Test
	public void testCreateBet() {
		
		when(betRepository.save(any(Bet.class))).thenReturn(new Bet());
		BetModel betModel = new BetModel();
		betModel.setCustomerID(new Long(200));
		//betModel.setDateTime(new LocalDateTime(new Date(0), new Time(0)));
		betModel.setBetType(BetType.WIN);
		betModel.setPropNumber(new Long(325));
		betModel.setInvestment(new Float(255));
        assertEquals(betServiceImpl.createBet(betModel), null);
	}
	
	@Test
	public void testGetTotalInvestmentPerBetType() {
		
		List<AggregateResultsModel> list = new ArrayList<AggregateResultsModel>();
		AggregateResultsModel mockAggregateResultsModel = new AggregateResultsModel();
		mockAggregateResultsModel.setBetType(BetType.WIN);
		mockAggregateResultsModel.setBetCount(new Long(10));
		mockAggregateResultsModel.setcustomerID(new Long(3048));
		mockAggregateResultsModel.setTotalInvestment(new Double(3000));
		list.add(mockAggregateResultsModel);
		
		when(betRepository.getTotalInvestmentPerBetType()).thenReturn(list);
		
		assertThat(betServiceImpl.getTotalInvestmentPerBetType(), hasItems(mockAggregateResultsModel));

	}
	
	@Test
	public void getTotalInvestmentPerCustomerID() {
		
		List<AggregateResultsModel> list = new ArrayList<AggregateResultsModel>();
		AggregateResultsModel mockAggregateResultsModel = new AggregateResultsModel();
		mockAggregateResultsModel.setBetType(BetType.WIN);
		mockAggregateResultsModel.setBetCount(new Long(10));
		mockAggregateResultsModel.setcustomerID(new Long(3048));
		mockAggregateResultsModel.setTotalInvestment(new Double(3000));
		list.add(mockAggregateResultsModel);

		when(betRepository.getTotalInvestmentPerCustomerID()).thenReturn(list);
		
		assertThat(betServiceImpl.getTotalInvestmentPerCustomerID(), hasItems(mockAggregateResultsModel));
	}
	
	@Test
	public void getTotalBetsSoldPerBetType() {
		
		List<AggregateResultsModel> list = new ArrayList<AggregateResultsModel>();
		AggregateResultsModel mockAggregateResultsModel = new AggregateResultsModel();
		mockAggregateResultsModel.setBetType(BetType.WIN);
		mockAggregateResultsModel.setBetCount(new Long(10));
		mockAggregateResultsModel.setcustomerID(new Long(3048));
		mockAggregateResultsModel.setTotalInvestment(new Double(3000));
		list.add(mockAggregateResultsModel);

		when(betRepository.getTotalBetsSoldPerBetType()).thenReturn(list);
		
		assertThat(betServiceImpl.getTotalBetsSoldPerBetType(), hasItems(mockAggregateResultsModel));
	}
	
	@Test
	public void getTotalNumberOfBetsSoldPerHour() {
		
		List<Bet> list = new ArrayList<Bet>();
		Bet bet = new Bet();
		bet.setCustomerID(new Long(200));
		bet.setDateTime(LocalDateTime.of(2019, 05, 23, 11, 55));
		bet.setBetType(BetType.WIN);
		bet.setPropNumber(new Long(325));
		bet.setInvestment(new Float(255));
		
		list.add(bet);
		when(betRepository.getTotalNumberOfBetsSoldPerHour(LocalDateTime.of(2019, 05, 23, 11, 55), LocalDateTime.of(2019, 05, 23, 11, 55))).thenReturn(list);
		
		assertThat(betServiceImpl.getTotalNumberOfBetsSoldPerHour(LocalDateTime.of(2019, 05, 23, 11, 55), LocalDateTime.of(2019, 05, 23, 11, 55)), hasItems(bet));
	}
}
