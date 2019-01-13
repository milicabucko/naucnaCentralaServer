package com.sep.naucnacentrala.dto;

import com.sep.naucnacentrala.model.CenovnikClanarine;
import com.sep.naucnacentrala.model.Magazin;

public class MagazinDTO {

    private Magazin magazin;

    private Boolean platiClanarinu;

    private Boolean postaviRad;

    private Boolean placenaClanarina;

    private CenovnikClanarine cenovnikClanarine;

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

    public void setPlacenaClanarina(Boolean placenaClanarina) {
        this.placenaClanarina = placenaClanarina;
    }

    public Boolean getPlacenaClanarina() {
        return placenaClanarina;
    }

    public CenovnikClanarine getCenovnikClanarine() {
        return cenovnikClanarine;
    }

    public void setCenovnikClanarine(CenovnikClanarine cenovnikClanarine) {
        this.cenovnikClanarine = cenovnikClanarine;
    }
}
