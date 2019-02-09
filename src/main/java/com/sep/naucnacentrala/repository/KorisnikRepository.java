package com.sep.naucnacentrala.repository;

import com.sep.naucnacentrala.model.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {

    Korisnik findByEmail(String email);
    Korisnik findByEmailAndLozinka(String email, String lozinka);
}
