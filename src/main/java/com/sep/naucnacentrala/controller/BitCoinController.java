package com.sep.naucnacentrala.controller;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sep.naucnacentrala.dto.BitCoinDTO;
import com.sep.naucnacentrala.model.Kupovina;
import com.sep.naucnacentrala.service.KupovinaService;

@RestController
@RequestMapping("/api")
public class BitCoinController {
	
	private static final Logger logger = LoggerFactory.getLogger(BitCoinController.class);
	
	@Autowired
	private KupovinaService kupovinaService;
	
	//dodavanje transakcije
		@CrossOrigin
		@RequestMapping(value = "/addBitCoin", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Kupovina> addBitCoinPayment(@RequestBody BitCoinDTO bitcoin) throws InvalidKeyException, InvalidAlgorithmParameterException, BadPaddingException, IllegalBlockSizeException, UnsupportedEncodingException, NoSuchPaddingException, NoSuchAlgorithmException {		
			
			Kupovina k = new Kupovina();
			k.setBitCoinOrderId(bitcoin.gettransactionId());
			k.setKorisnikId(bitcoin.getKorisnikId());
			k.setProizvodId(bitcoin.getProizvodId());
			k.setTipProizvoda(bitcoin.getTipProizvoda());
			k.setCena(bitcoin.getCena());
						
			if((k.getKorisnikId()!=null) && (k.getProizvodId()!=null) && !k.getTipProizvoda().isEmpty() && k.getCena()!=null) {
				kupovinaService.saveKupovinu(k);
				logger.info("\n\t\tBitcoin transakcija je uspešno kreirana.\n");
				return new ResponseEntity<Kupovina>(k, HttpStatus.OK);
			}
						
			logger.info("\n\t\tNeuspešan pokušaj kreiranja bitcoin transakcije.\n");
			return new ResponseEntity<Kupovina>(k, HttpStatus.BAD_REQUEST);
		}

}
