package com.sep.naucnacentrala.repository;

import com.sep.naucnacentrala.model.Kupovina;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KupovinaRepository extends JpaRepository<Kupovina, Long> {

    Kupovina findByKorisnikIdAndProizvodIdAndTipProizvoda(Long korisnikId, Long proizvodId, String tipProizvoda);

}
