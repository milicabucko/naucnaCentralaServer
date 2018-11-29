package com.sep.naucnacentrala.service;

import com.sep.naucnacentrala.model.Korisnik;
import com.sep.naucnacentrala.repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KorisnikService {

    @Autowired
    private KorisnikRepository korisnikRepository;

    public static Korisnik aktivanKorisnik;

    public Korisnik findByEmail(String email){
        Korisnik korisnik = korisnikRepository.findByEmail(email);
        return  korisnik;
    }

    public Korisnik save(Korisnik korisnik){
        korisnikRepository.save(korisnik);
        return korisnik;
    }
}
