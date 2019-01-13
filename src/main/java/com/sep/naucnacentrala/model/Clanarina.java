package com.sep.naucnacentrala.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Clanarina implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long korisnikId;

    private Long magazinId;

    private Double cena;

    private String datumPocetka;

    private String datumZavrsetka;

    private Integer brojMeseci;

    Clanarina() {}

    public Clanarina(Long korisnikId, Long magazinId, Double cena, String datumPocetka, String datumZavrsetka, Integer brojMeseci) {
        this.korisnikId = korisnikId;
        this.magazinId = magazinId;
        this.cena = cena;
        this.datumPocetka = datumPocetka;
        this.datumZavrsetka = datumZavrsetka;
        this.brojMeseci = brojMeseci;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getKorisnikId() {
        return korisnikId;
    }

    public void setKorisnikId(Long korisnikId) {
        this.korisnikId = korisnikId;
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

    public String getDatumPocetka() {
        return datumPocetka;
    }

    public void setDatumPocetka(String datumPocetka) {
        this.datumPocetka = datumPocetka;
    }

    public String getDatumZavrsetka() {
        return datumZavrsetka;
    }

    public void setDatumZavrsetka(String datumZavrsetka) {
        this.datumZavrsetka = datumZavrsetka;
    }

    public Integer getBrojMeseci() {
        return brojMeseci;
    }

    public void setBrojMeseci(Integer brojMeseci) {
        this.brojMeseci = brojMeseci;
    }
}
