package com.qa.rest;

import javax.inject.Inject;
import javax.websocket.server.PathParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.qa.business.AccountService;

@Path("/account")
public class AccountEndpoint {

	@Inject 
	private AccountService service;
	
	@Path("/getAllAcounts")
	@GET
	@Produces({"application/json"})
	public String getAllAccounts() {
		return service.getAllAccounts();
	}
	
	@Path("/getAAccount/{id}")
	@GET
	@Produces({"application/json"})
	public String getAAccount(@PathParam("id")Long id) {
		return service.getAAccount(id);
	}
	
	@Path("/createAccount")
	@POST
	@Produces({"application/json"})
	public String addAccount(String account) {
		return service.createAccount(account);
	}
	
	@Path("/deleteAccount/{id}")
	@DELETE
	@Produces({"application/json"})
	public String deleteAccount(@PathParam("id") Long id) {
		return service.deleteAccount(id);
	}
	
	@Path("/updateAccount/{account}/{id}")
	@PUT
	@Produces({"application/json"})
	public String updateAccount(@PathParam("account" + "id")String account, Long id) {
		return service.updateAccount(account, id);
	}
}
