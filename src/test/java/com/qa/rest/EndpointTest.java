package com.qa.rest;

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

@RunWith(MockitoJUnitRunner.class)
public class EndpointTest {
	@InjectMocks
	private AccountEndpoint endpoint;

	@Mock
	private AccountService service;
	
	private static final String MOCK_VALUE2 = "test_value_2";

	private static final String MOCK_VALUE = "test_value";

	@Before
	public void setup() {
		endpoint.setService(service);
	}

	@Test
	public void getAllTest() {
		Mockito.when(service.getAllAccounts()).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE,endpoint.getAllAccounts());
	}
	
	@Test
	public void getATest() {
		Mockito.when(service.getAAccount(1L)).thenReturn(MOCK_VALUE2);
		assertEquals(MOCK_VALUE2, endpoint.getAAccount(1L));
	}
	
	@Test
	public void updateTest() {
		Mockito.when(service.updateAccount(MOCK_VALUE, 1l)).thenReturn(MOCK_VALUE2);
		assertEquals(MOCK_VALUE2, endpoint.updateAccount(MOCK_VALUE, 1L));
		Mockito.verify(service).updateAccount(MOCK_VALUE, 1L);
	}
	
	@Test
	public void deleteTest() {
		Mockito.when(service.deleteAccount(1L)).thenReturn(MOCK_VALUE2);
		assertEquals(MOCK_VALUE2, endpoint.deleteAccount(1L));
		Mockito.verify(service).deleteAccount(1L);
	}
	
	@Test
	public void createTest() {
		Mockito.when(service.createAccount(MOCK_VALUE)).thenReturn(MOCK_VALUE2);
		assertEquals(MOCK_VALUE2, endpoint.addAccount(MOCK_VALUE));
		Mockito.verify(service).createAccount(MOCK_VALUE);
	}
	
}
