package com.qa.business;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.AccountRepository;
import com.qa.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class ServiceTest {
	@InjectMocks
	private AccountServiceImpl service;

	@Mock
	private AccountRepository repo;
	
	@Mock
	private JSONUtil util;

	private static final String MOCK_VALUE2 = "test_value_2";

	private static final String MOCK_VALUE = "test_value";
	private static final String MOCK_OBJECT = "{\"firstName\":\"jordan\",\"lastName\":\"hignett\",\"accountNumber\":123}";
	private static final String MOCK_OBJECT2 = "{\"firstName\":\"jordan\",\"lastName\":\"hignett\",\"accountNumber\":9}";

	
	@Before
	public void setup() {
		service.setRepo(repo);
		util = new JSONUtil();
		service.setUtil(util);
	}
	
	@Test
	public void createTest() {
		Mockito.when(repo.createAccount(MOCK_OBJECT)).thenReturn(MOCK_OBJECT);
		assertEquals(MOCK_OBJECT, service.createAccount(MOCK_OBJECT));
		Mockito.verify(repo).createAccount(MOCK_OBJECT);
		
	}
	@Test
	public void createTest2() {
		assertEquals("{\"message\": \"That account number is blocked!\"}", service.createAccount(MOCK_OBJECT2));
	}
	
	@Test
	public void deleteTest() {
		Mockito.when(repo.deleteAccount(1L)).thenReturn(MOCK_VALUE2);
		assertEquals(MOCK_VALUE2, service.deleteAccount(1L));
		Mockito.verify(repo).deleteAccount(1L);
	}
	
	@Test
	public void updateTest() {
		Mockito.when(repo.updateAccount(1L, MOCK_VALUE)).thenReturn(MOCK_VALUE2);
		assertEquals(MOCK_VALUE2, service.updateAccount(MOCK_VALUE, 1L));
		Mockito.verify(repo).updateAccount(1L,MOCK_VALUE);
	}
	@Test
	public void getAllTest() {
		Mockito.when(repo.getAllAccounts()).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, service.getAllAccounts());
	}
	@Test
	public void getATest() {
		Mockito.when(repo.getAAccount(1L)).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, service.getAAccount(1L));
	}
	
}
