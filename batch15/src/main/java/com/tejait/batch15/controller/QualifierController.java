package com.tejait.batch15.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tejait.batch15.service.CustomerService;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@RestController
@RequestMapping("qualifier")
public class QualifierController {

	
	@Qualifier("bussiness")
	CustomerService service;

	@GetMapping("test")
	public String getQualifierName() {
		return service.getCustomerType();
	}
}
