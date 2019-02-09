package com.sep.naucnacentrala.service;

import com.sep.naucnacentrala.model.Korisnik;
import com.sep.naucnacentrala.repository.KorisnikRepository;

import static java.util.Objects.isNull;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class KorisnikService {

    @Autowired
    private KorisnikRepository korisnikRepository;

    public static Korisnik aktivanKorisnik;

    public Korisnik findByEmail(String email){
        Korisnik korisnik = korisnikRepository.findByEmail(email);
        return  korisnik;
    }

    public Korisnik findByEmailAndLozinka(String email, String lozinka){
        Korisnik korisnik = korisnikRepository.findByEmailAndLozinka(email, lozinka);
        return  korisnik;
    }

    public Korisnik save(Korisnik korisnik){
        korisnikRepository.save(korisnik);
        return korisnik;
    }
    
   
	public UserDetails loadUserByUsername(String username) {
		Korisnik user = korisnikRepository.findByEmail(username);
		if(isNull(user)) {
			return null;
		}
		Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
		grantedAuthorities.add(new SimpleGrantedAuthority(user.getUloga()));
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getLozinka(), grantedAuthorities);
	}
}
