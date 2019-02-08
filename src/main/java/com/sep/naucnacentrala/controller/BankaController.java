package com.sep.naucnacentrala.controller;

import javax.servlet.http.HttpServletResponse;
import static com.sep.naucnacentrala.constants.Constants.CANCELED_PAYMENT_URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sep.naucnacentrala.dto.KupovinaDTO;
import com.sep.naucnacentrala.dto.MerchantDTO;
import com.sep.naucnacentrala.dto.PaymentUrlIdDTO;
import com.sep.naucnacentrala.model.PaymentRequest;
import com.sep.naucnacentrala.service.PaymentRequestService;



@RestController
@RequestMapping("/api")
public class BankaController {
	
	private static final Logger logger = LoggerFactory.getLogger(BankaController.class);
	
	@Autowired
	private PaymentRequestService service;
	
	@CrossOrigin
	@RequestMapping(
			value = "/bankPayment",
			method = RequestMethod.POST
	)
	public ResponseEntity<?> requestPaymentUrlAndId(@RequestBody KupovinaDTO kupovinaDTO, HttpServletResponse r) {
		
		logger.info("Entering bank payment");

        RestTemplate client = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        PaymentUrlIdDTO paymentUrlIdDTO = new PaymentUrlIdDTO();

        try {

        	logger.info("Forwarding paymentId and url request to Acquirer from NC");
             //step 2
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<KupovinaDTO> entity = new HttpEntity<>(kupovinaDTO, headers);
            paymentUrlIdDTO = client.postForObject("https://localhost:9000/api/urlandid", entity,
            		PaymentUrlIdDTO.class);
            
            savePaymentRequest(kupovinaDTO, paymentUrlIdDTO);
           

        } catch (Exception e) {
        	logger.info(e.getMessage());
        	logger.info("A mistake occured - {}.", e.getMessage());
        	paymentUrlIdDTO.setUrl(CANCELED_PAYMENT_URL);
            return new ResponseEntity<>(paymentUrlIdDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
		
		//after receiving valid url and id, redirect to acquirer web app fe to fill data
        r.setHeader("Location", paymentUrlIdDTO.getUrl()); //redirect user to url
        r.setStatus(302);
		return new ResponseEntity<>(paymentUrlIdDTO, HttpStatus.OK);
	}

	private void savePaymentRequest(KupovinaDTO kupovinaDTO, PaymentUrlIdDTO paymentUrlIdDTO) {
    	logger.info("Entering save payment request.");
    	PaymentRequest request = new PaymentRequest();
    	request.setCena(kupovinaDTO.getCena());
    	request.setKorisnikId(kupovinaDTO.getKorisnikId());
    	request.setProizvodId(kupovinaDTO.getProizvodId());
    	request.setTipProizvoda(kupovinaDTO.getTipProizvoda());
    	request.setPaymentId(paymentUrlIdDTO.getPaymentId());
    	service.savePaymentRequest(request);
    	logger.info("Payment request successfully saved.");
	}


}
