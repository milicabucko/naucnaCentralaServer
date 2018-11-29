package com.sep.naucnacentrala.repository;

import com.sep.naucnacentrala.model.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {

    Korisnik findByEmail(String email);
}
