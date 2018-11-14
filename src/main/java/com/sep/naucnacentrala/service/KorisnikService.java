package com.sep.naucnacentrala.service;

import com.sep.naucnacentrala.repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KorisnikService {

    @Autowired
    private KorisnikRepository korisnikRepository;



}
