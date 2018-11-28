package com.sep.naucnacentrala.repository;

import com.sep.naucnacentrala.model.IzdanjeMagazina;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IzdanjeMagazinaRepository extends JpaRepository<IzdanjeMagazina, Long> {

    List<IzdanjeMagazina> findByMagazinId(Long magazinId);

}
