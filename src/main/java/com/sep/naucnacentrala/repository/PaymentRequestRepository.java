package com.sep.naucnacentrala.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sep.naucnacentrala.model.PaymentRequest;

@Repository
public interface PaymentRequestRepository extends JpaRepository<PaymentRequest, Long> {

	PaymentRequest findByPaymentId(Integer paymentId);

}
