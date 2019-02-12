package com.qa.persistence.repository;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.persistence.domain.Account;
//import com.qa.util.JACKSONUtil;
import com.qa.util.JSONUtil;

public class AccountMapRepository implements AccountRepository {

	JSONUtil util = new JSONUtil();
	//JACKSONUtil util = new JACKSONUtil();
	//ObjectMapper util = new ObjectMapper();
	private static long id;

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
		this.accountMap.put(id++, util.getObjectForJSON(account, Account.class));
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

}
