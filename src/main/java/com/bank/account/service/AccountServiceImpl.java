package com.bank.account.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.account.entity.Account;
import com.bank.account.model.ResponseMsg;
import com.bank.account.repository.AccountRepo;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	AccountRepo accountRepo;
	
	public ResponseMsg getAccountsListByUserId(String userId) {
		
		List<Account> accountsList = accountRepo.findByAccountUserIdLoginName(userId);
		
		return new ResponseMsg(1, "SUCCESS", accountsList, "","","");
	}
}
