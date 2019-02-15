package com.qa.MapTests;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.AccountMapRepository;


public class AccountServiceTestHashMap {

	AccountMapRepository repo;

	@Before
	public void setup() {
		repo = new AccountMapRepository(0);
	}

	@Test
	public void updateTest() {
		repo.createAccount("{\"firstName\":\"Josh\",\"lastName\":\"Josh\",\"accountNumber\":1}");
		assertEquals("Account updated.",repo.updateAccount((long) 0, "{\"firstName\":\"Josh\",\"lastName\":\"Josh\",\"accountNumber\":2}"));
	}
	
	@Test
	public void getAllTest() {
		repo.createAccount("{\"firstName\":\"Josh\",\"lastName\":\"Josh\",\"accountNumber\":1}");
		assertEquals("{\"firstName\":\"Josh\",\"lastName\":\"Josh\",\"accountNumber\":1}",
				repo.getAllAccounts());
	}
	
	@Test
	public void getATest() {
		repo.createAccount("{\"firstName\":\"Josh\",\"lastName\":\"Josh\",\"accountNumber\":1}");

		assertEquals("{\"firstName\":\"Josh\",\"lastName\":\"Josh\",\"accountNumber\":1}",
				repo.getAAccount((long) 0));
	}
	
	@Test
	public void addAccountTest() {

		assertEquals("{ \"firstName\": \"Josh\",\"lastName\": \"Josh\",\"accountNumber\": 1}",
				repo.createAccount("{ \"firstName\": \"Josh\",\"lastName\": \"Josh\",\"accountNumber\": 1}"));
	}

	@Test
	public void add2AccountsTest() {

		assertNotEquals("Failed to add", repo.createAccount("{ \"lastName\": \"Josh\",\"accountNumber\": 1}"));
	}

	@Test
	public void removeAccountTest() {
		repo.createAccount("{ \"firstName\": \"Josh\",\"lastName\": \"Josh\",\"accountNumber\": 1}");
		assertEquals("Account has been removed.", repo.deleteAccount((long) 1));

	}

	@Test
	public void remove2AccountsTest() {
		repo.createAccount("{ \"firstName\": \"Josh\",\"lastName\": \"Josh\",\"accountNumber\": 1}");
		repo.createAccount("{ \"firstName\": \"Josh\",\"lastName\": \"Josh\",\"accountNumber\": 666}");
		assertEquals("Account has been removed.",repo.deleteAccount((long) 1));
		assertEquals("Account has been removed.",repo.deleteAccount((long) 2));
	}

	@Test
	public void remove2AccountTestAnd1ThatDoesntExist() {
		repo.createAccount("{ \"firstName\": \"Josh\",\"lastName\": \"Josh\",\"accountNumber\": 1}");
		repo.createAccount("{ \"firstName\": \"Josh\",\"lastName\": \"Josh\",\"accountNumber\": 666}");
		assertEquals("Account has been removed.",repo.deleteAccount((long) 1));
		assertEquals("Account has been removed.",repo.deleteAccount((long) 2));
		assertEquals("Account has been removed.",repo.deleteAccount((long) 9999));
	}

	@Test
	public void getCountForFirstNamesInAccountWhenZeroOccurances() {
		// For a later piece of functionality

		repo.createAccount("{ \"firstName\": \"Josh\",\"lastName\": \"Ingram\",\"accountNumber\": 3211}");
		repo.createAccount("{ \"firstName\": \"Josh\",\"lastName\": \"Hignett\",\"accountNumber\": 51611}");
		repo.createAccount("{ \"firstName\": \"Josh\",\"lastName\": \"Lang\",\"accountNumber\": 78941}");
		repo.createAccount("{ \"firstName\": \"Josh\",\"lastName\": \"Gomersall\",\"accountNumber\": 456541}");
		repo.createAccount("{ \"firstName\": \"Josh\",\"lastName\": \"Mittra\",\"accountNumber\": 484691}");
		repo.createAccount("{ \"firstName\": \"Jordan\",\"lastName\": \"Josh\",\"accountNumber\": 1654}");

		assertEquals(0, repo.getFirstNameCount("John"));
	}

	@Test
	public void getCountForFirstNamesInAccountWhenOne() {
		// For a later piece of functionality

		repo.createAccount("{ \"firstName\": \"Josh\",\"lastName\": \"Ingram\",\"accountNumber\": 3211}");
		repo.createAccount("{ \"firstName\": \"Josh\",\"lastName\": \"Hignett\",\"accountNumber\": 51611}");
		repo.createAccount("{ \"firstName\": \"Josh\",\"lastName\": \"Lang\",\"accountNumber\": 78941}");
		repo.createAccount("{ \"firstName\": \"Josh\",\"lastName\": \"Gomersall\",\"accountNumber\": 456541}");
		repo.createAccount("{ \"firstName\": \"Josh\",\"lastName\": \"Mittra\",\"accountNumber\": 484691}");
		repo.createAccount("{ \"firstName\": \"Jordan\",\"lastName\": \"Josh\",\"accountNumber\": 1654}");
		repo.createAccount("{ \"firstName\": \"John\",\"lastName\": \"Josh\",\"accountNumber\": 164254}");

		assertEquals(1, repo.getFirstNameCount("John"));
	}

	@Test
	public void getCountForFirstNamesInAccountWhenTwo() {

		repo.createAccount("{ \"firstName\": \"Jordan\",\"lastName\": \"Josh\",\"accountNumber\": 1654}");
		repo.createAccount("{ \"firstName\": \"John\",\"lastName\": \"Josh\",\"accountNumber\": 164254}");
		repo.createAccount("{ \"firstName\": \"John\",\"lastName\": \"Josh\",\"accountNumber\": 564}");
		assertEquals(2, repo.getFirstNameCount("John"));
	}

}
