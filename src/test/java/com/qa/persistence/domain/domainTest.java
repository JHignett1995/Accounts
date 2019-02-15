package com.qa.persistence.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class domainTest {
		public Account me = new Account("jordan", "hignett",123);
		
		@Test
		public void getFirstNameTest() {
			assertEquals("jordan",me.getFirstName());
		}
		
		@Test
		public void setFirstNameTest() {
			me.setFirstName("jodan");
			assertEquals("jodan",me.getFirstName());
		}
		
		@Test
		public void getLastNameTest() {
			assertEquals("hignett",me.getLastName());
		}
		
		@Test
		public void setLastNameTest() {
			me.setLastName("hignet");
			assertEquals("hignet",me.getLastName());
		}
		
		@Test
		public void setAccountNumberTest() {
			me.setAccountNumber(321);
			assertEquals(321, me.getAccountNumber());
		}
	
}
