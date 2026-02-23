package com.tejait.batch15.service;

import com.tejait.batch15.model.Payment;

public interface PaymentService {

	Payment savePayment(Payment payment);

	Payment getByIdpaymentId(Integer paymentId);

	Payment getRefundBypaymentId(Integer paymentId);

}
