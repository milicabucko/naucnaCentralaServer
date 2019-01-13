package com.sep.naucnacentrala.repository;

import com.sep.naucnacentrala.model.Clanarina;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClanarinaRepository extends JpaRepository<Clanarina, Long> {

    Clanarina findByKorisnikIdAndMagazinIdAndDatumPocetkaLessThanEqualAndDatumZavrsetkaGreaterThanEqual(Long korisnikId, Long magazinId, String dasasnjiDatum, String danasnjiDatum);

}
