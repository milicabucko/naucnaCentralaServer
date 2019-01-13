package com.sep.naucnacentrala.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class CenovnikClanarine implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long magazinId;

    private Double cena;

    private Integer brojMeseci;

    CenovnikClanarine() {}

    public CenovnikClanarine(Long magazinId, Double cena, Integer brojMeseci) {
        this.magazinId = magazinId;
        this.cena = cena;
        this.brojMeseci = brojMeseci;
    }

    public Long getMagazinId() {
        return magazinId;
    }

    public void setMagazinId(Long magazinId) {
        this.magazinId = magazinId;
    }

    public Double getCena() {
        return cena;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }

    public Integer getBrojMeseci() {
        return brojMeseci;
    }

    public void setBrojMeseci(Integer brojMeseci) {
        this.brojMeseci = brojMeseci;
    }
}
