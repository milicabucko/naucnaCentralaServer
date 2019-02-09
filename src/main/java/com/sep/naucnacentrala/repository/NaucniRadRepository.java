package com.sep.naucnacentrala.repository;

import com.sep.naucnacentrala.model.NaucniRad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NaucniRadRepository extends JpaRepository<NaucniRad, Long> {

    List<NaucniRad> findByMagazinId(Long magazinId);
    List<NaucniRad> findByIzdanjeMagazinaId(Long izdanjeMagazinaId);

}
