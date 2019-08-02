package com.bank.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.account.entity.AccountUser;

@Repository
public interface AccountUserRepo extends JpaRepository<AccountUser, String>{
	
	
}
