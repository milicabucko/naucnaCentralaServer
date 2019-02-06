package com.sep.naucnacentrala.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class NaucniRad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long magazinId;

    private Long izdanjeMagazinaId;

    private String koautori;

    private String kljucniPojmovi;

    private String naucnaOblast;

    private Boolean prihvacen;

    private Double cena;

    private String link;

    public NaucniRad() {}

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

    public Long getIzdanjeMagazinaId() {
        return izdanjeMagazinaId;
    }

    public void setIzdanjeMagazinaId(Long izdanjeMagazinaId) {
        this.izdanjeMagazinaId = izdanjeMagazinaId;
    }

    public String getKoautori() {
        return koautori;
    }

    public void setKoautori(String koautori) {
        this.koautori = koautori;
    }

    public String getKljucniPojmovi() {
        return kljucniPojmovi;
    }

    public void setKljucniPojmovi(String kljucniPojmovi) {
        this.kljucniPojmovi = kljucniPojmovi;
    }

    public String getNaucnaOblast() {
        return naucnaOblast;
    }

    public void setNaucnaOblast(String naucnaOblast) {
        this.naucnaOblast = naucnaOblast;
    }

    public Boolean getPrihvacen() {
        return prihvacen;
    }

    public void setPrihvacen(Boolean prihvacen) {
        this.prihvacen = prihvacen;
    }

    public Double getCena() {
        return cena;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
