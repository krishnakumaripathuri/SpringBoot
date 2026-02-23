package com.tejait.batch15.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tejait.batch15.model.Payment;
import com.tejait.batch15.service.PaymentService;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@RestController
@RequestMapping("payment")
public class PaymentController {
	PaymentService service;
	
	private static final Logger logger=LogManager.getLogger(PaymentController.class);
	
	@PostMapping("/makepayment")
	public ResponseEntity<Payment> makePayment(@RequestBody Payment payment){
		logger.debug("enter into payment controller");
		logger.info("payment data:{} ", payment);
		 Payment savedpayment=service.savePayment(payment);
		 logger.info("saved payment Data:{} ", savedpayment);
		return new ResponseEntity<>(savedpayment, HttpStatus.OK);
		
	}
	@GetMapping("bypaymentId/{paymentId}")
	public ResponseEntity<Payment> getByIdpaymentId(@PathVariable Integer paymentId){
		logger.debug("Entered into getpaymentByPaymentId");
		logger.info("paymentId:{}", paymentId);
		Payment payment=service.getByIdpaymentId(paymentId);
		logger.info("payment:{} ", payment);
		return new ResponseEntity<>(payment, HttpStatus.ACCEPTED);
	}
	@GetMapping("getRefundByPaymentId/{paymentId}")
	public ResponseEntity<Payment> getRefundBypaymentId(@PathVariable Integer paymentId){
		logger.debug("Entered into getRefundByPaymentId");
		logger.info("paymentId:{} ", paymentId);
		Payment payment=service.getRefundBypaymentId(paymentId);
		logger.info("payment:{}", payment);
		return new ResponseEntity<>(payment,HttpStatus.ACCEPTED);
	}

}
