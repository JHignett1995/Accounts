package com.qa.rest;

import static org.junit.Assert.*;

import org.junit.Test;

public class JAXActivatorTest {
	JAXActivator jaxA = new JAXActivator();

	@Test
	public void testExists() {
		assertTrue(jaxA.iExist());
	}
}
