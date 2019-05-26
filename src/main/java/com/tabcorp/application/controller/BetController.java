package com.tabcorp.application.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tabcorp.application.entity.Bet;
import com.tabcorp.application.model.AggregateResultsModel;
import com.tabcorp.application.model.BetModel;
import com.tabcorp.application.model.ResponseMsg;
import com.tabcorp.application.service.BetService;

@RestController
@RequestMapping(value = "/api/bet")
public class BetController {

	private Logger logger = Logger.getLogger(this.getClass().getName());
	
	@Autowired
	BetService betService;
	
	@PostMapping(value = "/create")
	public ResponseEntity<ResponseMsg> createBet(@Valid @RequestBody BetModel bet) {
		logger.info("Creating bets for"+ bet.toString());
		
		ResponseMsg responseMsg = null;
		
		try {
			betService.createBet(bet);
			responseMsg = new ResponseMsg(1, "success", "Created Bet successfully", null);
		}catch(Exception e) {
			 responseMsg = new ResponseMsg(-1, "error", e.getMessage(), null);
		}
		
		return new ResponseEntity<ResponseMsg>(responseMsg, HttpStatus.OK);
	}

	
	@GetMapping(value = "/getInvestmentPerBetType")
	public ResponseEntity<List<AggregateResultsModel>> getInvestmentByBetType() {
		logger.info("Getting Investment per bet type ");
		return new ResponseEntity<List<AggregateResultsModel>>(betService.getTotalInvestmentPerBetType(), HttpStatus.OK);

	}

	@GetMapping(value = "/getInvestmentPerCustomerID")
	public ResponseEntity<List<AggregateResultsModel>> getInvestmentByCustomerId() {
		logger.log(Level.INFO, "Getting Investment per customerId ");
		return new ResponseEntity<List<AggregateResultsModel>>(betService.getTotalInvestmentPerCustomerID(),
				HttpStatus.OK);

	}

	@GetMapping(value = "/getTotalBetsSoldPerBetType")
	public ResponseEntity<List<AggregateResultsModel>> getTotalBetsSoldPerBetType() {
		logger.log(Level.INFO, "Getting total bets sold per bet type ");
		return new ResponseEntity<List<AggregateResultsModel>>(betService.getTotalBetsSoldPerBetType(), HttpStatus.OK);

	}

	@GetMapping(value = "/getTotalNumberOfBetsSoldPerHour")
	public ResponseEntity<Map<String, Integer>> getTotalNumberOfBetsSoldPerHour(
			@RequestParam(value = "fromDate", required = true) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fromDate,
			@RequestParam(value = "toDate", required = true) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate toDate) {
		logger.log(Level.INFO, "Getting total number of bets sold per hour");
		List<Bet> betList = betService.getTotalNumberOfBetsSoldPerHour(fromDate.atStartOfDay(),
				toDate.atStartOfDay());
		Map<String, Integer> hourToBetsSoldMap = new HashMap<>();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH");
		for (Bet bet : betList) {
			String dateHour = formatter.format(bet.getDateTime());
			if (hourToBetsSoldMap.get(dateHour) != null) {
				hourToBetsSoldMap.put(dateHour, hourToBetsSoldMap.get(dateHour) + 1);
			} else {
				hourToBetsSoldMap.put(dateHour, new Integer(1));
			}

		}  
		return new ResponseEntity<Map<String, Integer>>(hourToBetsSoldMap, HttpStatus.OK);

	}

	
}