package com.qa.persistence.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.business.AccountService;
import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class AccountsDBRepository {

	@InjectMocks
	private AccountDBRepository repo;

	@Mock
	private EntityManager manager;

	@Mock
	private Query query;

	private JSONUtil util;

	private static final String MOCK_DATA_ARRAY = "[{\"firstName\":\"jordan\",\"lastName\":\"hignett\",\"accountNumber\":123}]";

	private static final String MOCK_OBJECT = "{\"firstName\":\"jordan\",\"lastName\":\"hignett\",\"accountNumber\":123}";

	@Before
	public void setup() {
		repo.setManager(manager);
		util = new JSONUtil();
		repo.setUtil(util);
	}
	@Test
	public void createTest() {
		String reply = repo.createAccount(MOCK_OBJECT);
		assertEquals(reply, "{\"message\": \"Account added\"}");
	}
	@Test
	public void getAllTest() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Account> accounts = new ArrayList<Account>();
		accounts.add(new Account("jordan", "hignett", 123));
		Mockito.when(query.getResultList()).thenReturn(accounts);
		System.out.println(repo.getAllAccounts());
		assertEquals(MOCK_DATA_ARRAY, repo.getAllAccounts());
	}
	@Test
	public void getATest() {
		Mockito.when(manager.find(Account.class,1L)).thenReturn(util.getObjectForJSON(MOCK_OBJECT, Account.class));
		assertEquals(MOCK_OBJECT,repo.getAAccount(1L));
		
	}
	@Test
	public void updateTest() {
		assertEquals("{\"message\": \"Account sucessfully Updated\"}",repo.updateAccount(1L, MOCK_OBJECT));
	}
	@Test
	public void deleteTest() {

		String reply = repo.deleteAccount(1L);
		assertEquals(reply, "{\"message\": \"Account sucessfully deleted\"}");
	}
}
