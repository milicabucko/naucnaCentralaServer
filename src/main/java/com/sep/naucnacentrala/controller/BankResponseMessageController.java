package com.sep.naucnacentrala.controller;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sep.naucnacentrala.dto.PaymentUrlIdDTO;
import com.sep.naucnacentrala.dto.ResponseMessageDTO;
import com.sep.naucnacentrala.dto.ResponseMessageDTO.TransactionResult;
import com.sep.naucnacentrala.dto.UrlDTO;
import com.sep.naucnacentrala.dto.UrlDTO.Status;
import com.sep.naucnacentrala.model.Kupovina;
import com.sep.naucnacentrala.model.PaymentRequest;
import com.sep.naucnacentrala.service.KupovinaService;
import com.sep.naucnacentrala.service.PaymentRequestService;

@RestController
@RequestMapping("/api")
public class BankResponseMessageController {
	
private static final Logger logger = LoggerFactory.getLogger(BankResponseMessageController.class);
	
	@Autowired
	private PaymentRequestService paymentRequestService;
	
	@Autowired
	private KupovinaService kupovinaService;
	
	@CrossOrigin
	@RequestMapping(
			value = "/payment/executed",
			method = RequestMethod.POST
	)
	public ResponseEntity<UrlDTO> handlePayingByBank(@RequestBody ResponseMessageDTO responseMessageDTO, HttpServletResponse r) {
		
		
		logger.info("Entering final payment endpoint - Sience Centre final response");
		//transaction is successfully executed, therefore, we save the payment
		if(responseMessageDTO.getResult().equals(TransactionResult.SUCCESSFUL)){
			logger.info("Payment transaction successfully executed");
			PaymentRequest paymentRequest = paymentRequestService.getByPaymentId(responseMessageDTO.getPaymentId());
			Kupovina kupovina = new Kupovina();
			kupovina.setCena(paymentRequest.getCena());
			kupovina.setKorisnikId(paymentRequest.getKorisnikId());
			kupovina.setProizvodId(paymentRequest.getProizvodId());
			kupovina.setTipProizvoda(paymentRequest.getTipProizvoda());
			kupovinaService.saveKupovinu(kupovina);
			logger.info("Payment saved for user - {}", paymentRequest.getKorisnikId());
			UrlDTO dto = new UrlDTO();
			dto.setUrl("https://localhost:4200/bankSuccess");
			dto.setResult(responseMessageDTO.getResult());
			dto.setStatus(Status.SUCCESSFUL);
			return new ResponseEntity<>(dto, HttpStatus.OK);
			
		} else if (responseMessageDTO.getResult().equals(TransactionResult.ERROR)){
			UrlDTO dto = new UrlDTO();
			dto.setUrl("https://localhost:4200/bankError");
			dto.setResult(responseMessageDTO.getResult());
			dto.setStatus(Status.ERROR);
			return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
		} else {
			UrlDTO dto = new UrlDTO();
			dto.setUrl("https://localhost:4200/bankError");
			dto.setResult(responseMessageDTO.getResult());
			dto.setStatus(Status.FAILED);
			return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
		}
	}
}
