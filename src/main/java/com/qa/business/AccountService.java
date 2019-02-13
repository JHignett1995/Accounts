package com.qa.business;

public interface AccountService {

	// C
	String createAccount(String account);

	// R
	String getAllAccounts();

	String getAnAccount(Long id);

	// U
	String updateAccount(String account, Long id);

	// D
	String deleteAccount(Long id);
}
