package com.sep.naucnacentrala.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sep.naucnacentrala.model.Kupovina;
import com.sep.naucnacentrala.repository.KupovinaRepository;

@Service
@Transactional
public class KupovinaService {
	
	@Autowired
	private KupovinaRepository kupovinaRepository;
	
	public void saveKupovinu(Kupovina k){
		kupovinaRepository.save(k);
	}

}
