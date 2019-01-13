package com.sep.naucnacentrala.repository;

import com.sep.naucnacentrala.model.CenovnikClanarine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CenovnikClanarineRepository extends JpaRepository<CenovnikClanarine, Long> {

    CenovnikClanarine findByMagazinId(Long magazinId);

}
