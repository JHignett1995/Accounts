package com.qa.business;

import javax.inject.Inject;

import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.AccountRepository;
import com.qa.util.JSONUtil;

public class AccountServiceImpl implements AccountService {

	@Inject
	private AccountRepository repo;
	private JSONUtil util;

	public String createAccount(String account) {
		Account aAccount = util.getObjectForJSON(account, Account.class);
		String temp = Integer.toString((aAccount.getAccountNumber()));
		if(temp.contains("9")) {
			return "{\"message\": \"That account number is blocked!\"}";
		}
		
		return repo.createAccount(account);
	}

	
	public String getAllAccounts() {
		return repo.getAllAccounts();
	}

	
	public String getAnAccount(Long id) {
		return repo.getAAccount(id);
	}

	
	public String updateAccount(String account, Long id) {
		return repo.updateAccount(id, account);
	}

	
	public String deleteAccount(Long id) {
		return repo.deleteAccount(id);
	}

}
