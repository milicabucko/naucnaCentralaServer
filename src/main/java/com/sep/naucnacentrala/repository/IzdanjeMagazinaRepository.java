package com.sep.naucnacentrala.repository;

import com.sep.naucnacentrala.model.IzdanjeMagazina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IzdanjeMagazinaRepository extends JpaRepository<IzdanjeMagazina, Long> {

    List<IzdanjeMagazina> findByMagazinId(Long magazinId);
    IzdanjeMagazina findByMagazinIdAndMesec(Long magazinId, String mesec);

}
