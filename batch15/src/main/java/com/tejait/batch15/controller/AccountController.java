package com.tejait.batch15.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tejait.batch15.dto.AccountCustomerDto;
import com.tejait.batch15.dto.AccountResponseDto;
import com.tejait.batch15.model.Account;
import com.tejait.batch15.service.AccountService;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@RestController
@RequestMapping("/account")
public class AccountController {
	
	AccountService service;
	
	@PostMapping(value="saveAccount")
public ResponseEntity<Account> saveaccount(@RequestBody Account account){
	Account savedAccount=service.saveAccount(account);
	return new ResponseEntity<>(savedAccount,HttpStatus.CREATED);
	
}
	@RequestMapping(value="getByid/{id}")
	public ResponseEntity<Account> getbyIdAccountDtls(@PathVariable Long id){
		Account account=service.getByAccountId(id);
		return new ResponseEntity<>(account,HttpStatus.OK);
	}
	@RequestMapping(value="getByAccId/{id}")
	public ResponseEntity<AccountResponseDto> giveCustomerAccountInfo(@PathVariable Long id){
		AccountResponseDto dto=service.getByCustomerInfoByAccountId(id);
		return new ResponseEntity<>(dto,HttpStatus.OK);
	}
	@RequestMapping(value="getByCustomerId/{id}")
	public ResponseEntity<AccountCustomerDto> giveCustomerAccountInfo2(@PathVariable Long id){
		AccountCustomerDto dto1=service.getByCustomerAccInfoByAccountId(id);
		return new ResponseEntity<>(dto1,HttpStatus.OK);
	}
	
	
}
