package com.sep.naucnacentrala.repository;

import com.sep.naucnacentrala.model.NaucniRad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NaucniRadRepository extends JpaRepository<NaucniRad, Long> {

    List<NaucniRad> findByMagazinId(Long magazinId);
    List<NaucniRad> findByIzdanjeMagazinaId(Long izdanjeMagazinaId);

}
