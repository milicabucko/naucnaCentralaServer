package com.sep.naucnacentrala.dto;

import com.sep.naucnacentrala.model.IzdanjeMagazina;
import com.sep.naucnacentrala.model.Magazin;

public class NaucniRadDTO {

    private Magazin magazin;

    private IzdanjeMagazina izdanjeMagazina;

    private String koautori;

    private String kljucniPojmovi;

    private String naucnaOblast;

    private Double cena;

    private String link;

    private Boolean preuzmiRad;

    private Boolean kupiRad;

    public NaucniRadDTO(Magazin magazin, IzdanjeMagazina izdanjeMagazina, String koautori, String kljucniPojmovi, String naucnaOblast, Double cena, String link) {
        this.magazin = magazin;
        this.izdanjeMagazina = izdanjeMagazina;
        this.koautori = koautori;
        this.kljucniPojmovi = kljucniPojmovi;
        this.naucnaOblast = naucnaOblast;
        this.cena = cena;
        this.link = link;
    }

    public Magazin getMagazin() {
        return magazin;
    }

    public void setMagazin(Magazin magazin) {
        this.magazin = magazin;
    }

    public IzdanjeMagazina getIzdanjeMagazina() {
        return izdanjeMagazina;
    }

    public void setIzdanjeMagazina(IzdanjeMagazina izdanjeMagazina) {
        this.izdanjeMagazina = izdanjeMagazina;
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

    public Boolean getPreuzmiRad() {
        return preuzmiRad;
    }

    public void setPreuzmiRad(Boolean preuzmiRad) {
        this.preuzmiRad = preuzmiRad;
    }

    public Boolean getKupiRad() {
        return kupiRad;
    }

    public void setKupiRad(Boolean kupiRad) {
        this.kupiRad = kupiRad;
    }
}
