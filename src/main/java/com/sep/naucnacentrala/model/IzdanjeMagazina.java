package com.sep.naucnacentrala.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class IzdanjeMagazina implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long magazinId;

    private String mesec;

    private String besplatan;

    private Double cena;

    IzdanjeMagazina() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMagazinId() {
        return magazinId;
    }

    public void setMagazinId(Long magazinId) {
        this.magazinId = magazinId;
    }

    public String getMesec() {
        return mesec;
    }

    public void setMesec(String mesec) {
        this.mesec = mesec;
    }

    public String getBesplatan() {
        return besplatan;
    }

    public void setBesplatan(String besplatan) {
        this.besplatan = besplatan;
    }

    public Double getCena() {
        return cena;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }
}
