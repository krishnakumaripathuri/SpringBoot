package com.tejait.batch15.serviceimpl;

import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.tejait.batch15.model.Payment;
import com.tejait.batch15.repository.PaymentRepository;
import com.tejait.batch15.service.PaymentService;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@Service
public class PaymentServiceImpl implements PaymentService{
	PaymentRepository repository;

	private static final Logger logger=LogManager.getLogger(PaymentServiceImpl.class);
	
	@Override
	public Payment savePayment(Payment payment) {
		logger.debug("Enterd Into Payment Service");
		logger.info("Payment Data:{}", payment);
		
		// FAILURE SCENARIO
		if(payment.getAmount()<1) {
			logger.info("Transaction Amount:{}", payment.getAmount());
			payment.setTransactionId(UUID.randomUUID().toString());
			payment.setPaymentStatus("Failed");
			logger.warn("Payment Status:{} , Transaction id:{}" , payment.getPaymentStatus() , payment.getTransactionId());
			logger.error("Invalid Amount:{} ", payment.getAmount());
			throw new RuntimeException("Invalid Amount");
		}
		// FRAUD ALET
		if(payment.getAmount()>100000) {
			logger.warn("Fraud Alert :{} , Alert higher amount transaction:{} " , payment.getPayerName() , payment.getAmount());
			
		}
		
		try {
			payment.setTransactionId(UUID.randomUUID().toString());
			payment.setPaymentStatus("Successs");
		
		return repository.save(payment);
		}catch(Exception e){
			logger.error("Error while making payment");
	
			throw e;
		}
	}

	@Override
	public Payment getByIdpaymentId(Integer paymentId) {
	 return repository.findById(paymentId).orElseThrow(()->{
		 logger.error("Payment Not Found:{}", paymentId);
		 return new IllegalArgumentException("Payment Not Found ::"+paymentId);
		 });
		
	}

	@Override
	public Payment getRefundBypaymentId(Integer paymentId) {
		
		Payment payment=repository.findById(paymentId)
				.orElseThrow(()->{
					logger.error("Payment ID Not Found:{}", paymentId);
					logger.error("Payment Not Found");
		return new IllegalArgumentException("Payment Not Found");
				});
		if(!payment.getPaymentStatus().equalsIgnoreCase("success")) {
			logger.warn("payment status:{}", payment.getPaymentStatus());
			logger.error("payment Not Allowed For Re=Found:{}", paymentId);
			logger.error("payment not allowed for refound");
			throw  new IllegalArgumentException("payment not allowed for refound");
		}
		payment.setPaymentStatus("refund");
		payment.setTransactionId(UUID.randomUUID().toString());
		return repository.save(payment) ;
	}

}
