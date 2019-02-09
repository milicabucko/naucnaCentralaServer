package com.sep.naucnacentrala.repository;

import com.sep.naucnacentrala.model.Magazin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MagazinRepository extends JpaRepository<Magazin, Long> {



}
