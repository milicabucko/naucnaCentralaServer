package com.sep.naucnacentrala.dto;

import com.sep.naucnacentrala.model.Magazin;

public class MagazinDTO {

    private Magazin magazin;

    private Boolean platiClanarinu;

    private Boolean postaviRad;

    public MagazinDTO() {

    }

    public MagazinDTO(Magazin magazin) {
        this.magazin = magazin;
    }

    public Magazin getMagazin() {
        return magazin;
    }

    public void setMagazin(Magazin magazin) {
        this.magazin = magazin;
    }

    public Boolean getPlatiClanarinu() {
        return platiClanarinu;
    }

    public void setPlatiClanarinu(Boolean platiClanarinu) {
        this.platiClanarinu = platiClanarinu;
    }

    public Boolean getPostaviRad() {
        return postaviRad;
    }

    public void setPostaviRad(Boolean postaviRad) {
        this.postaviRad = postaviRad;
    }
}