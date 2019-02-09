package com.sep.naucnacentrala.repository;

import com.sep.naucnacentrala.model.Clanarina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClanarinaRepository extends JpaRepository<Clanarina, Long> {

    Clanarina findByKorisnikIdAndMagazinIdAndDatumPocetkaLessThanEqualAndDatumZavrsetkaGreaterThanEqual(Long korisnikId, Long magazinId, String dasasnjiDatum, String danasnjiDatum);

}
