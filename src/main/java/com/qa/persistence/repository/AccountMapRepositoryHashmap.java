package com.qa.persistence.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.qa.persistence.domain.Account;
//import com.qa.util.JACKSONUtil;
import com.qa.util.JSONUtil;

public class AccountMapRepositoryHashmap implements AccountRepository {

	JSONUtil util = new JSONUtil();
	//JACKSONUtil util = new JACKSONUtil();
	//ObjectMapper util = new ObjectMapper();
//	private long id=0;
//
//	public AccountMapRepository(long id) {
//		super();
//		this.id = id;
//	}

	Map<Long, Account> accountMap = new HashMap<Long, Account>();

	// You must provide concrete implementation for each of these methods
	// do not change the method signature

	public String getAllAccounts() {
		String str = "";
		for (Entry<Long, Account> entry : accountMap.entrySet()) {
			str += util.getJSONForObject(entry.getValue());
		}
		return str;
	}

	public String createAccount(String account) {
		//this.accountMap.put(util.getObjectForJSON(account, Account.class));
		return account;
	}


	public String deleteAccount(Long id) {
		this.accountMap.remove(id);
		return "Account has been removed.";
	}

	public String updateAccount(Long id, String account) {
		this.accountMap.replace(id, util.getObjectForJSON(account, Account.class));
		return "Account updated.";
	}
	
	public int getFirstNameCount(String firstName) {
		int count=0;
		System.out.println(this.accountMap.size());
		System.out.println("id" + accountMap.size());
		
		for(Long i=(long) 0; i<accountMap.size();i++) {
			System.out.println(accountMap.get(i).getFirstName());
			if (accountMap.get(i).getFirstName().equals(firstName)) {
				count++;
			}
		}
		return count;
	}

	public String getAAccount(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
