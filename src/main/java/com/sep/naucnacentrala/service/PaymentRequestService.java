package com.sep.naucnacentrala.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sep.naucnacentrala.model.PaymentRequest;
import com.sep.naucnacentrala.repository.PaymentRequestRepository;

@Service
@Transactional
public class PaymentRequestService {
	
	@Autowired
	private PaymentRequestRepository repostiory;
	
	public void savePaymentRequest(PaymentRequest paymentRequest) {
		repostiory.save(paymentRequest);
	}
	
	public PaymentRequest getByPaymentId(Integer paymentId) {
		return repostiory.findByPaymentId(paymentId);
	}

}
