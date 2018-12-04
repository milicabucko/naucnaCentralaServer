package com.sep.naucnacentrala.dto;

import com.sep.naucnacentrala.model.IzdanjeMagazina;
import com.sep.naucnacentrala.model.Magazin;

public class IzdanjeMagazinaDTO {

    private Magazin magazin;

    private IzdanjeMagazina izdanje;

    private String mesec;

    private Boolean preuzmiIzdanje;

    private Boolean kupiIzdanje;

    public IzdanjeMagazinaDTO() {

    }

    public IzdanjeMagazinaDTO(Magazin magazin, IzdanjeMagazina izdanje) {
        this.magazin = magazin;
        this.izdanje = izdanje;
    }

    public Magazin getMagazin() {
        return magazin;
    }

    public void setMagazin(Magazin magazin) {
        this.magazin = magazin;
    }

    public IzdanjeMagazina getIzdanje() {
        return izdanje;
    }

    public void setIzdanje(IzdanjeMagazina izdanje) {
        this.izdanje = izdanje;
    }

    public String getMesec() {
        return mesec;
    }

    public void setMesec(String mesec) {
        this.mesec = mesec;
    }

    public Boolean getPreuzmiIzdanje() {
        return preuzmiIzdanje;
    }

    public void setPreuzmiIzdanje(Boolean preuzmiIzdanje) {
        this.preuzmiIzdanje = preuzmiIzdanje;
    }

    public Boolean getKupiIzdanje() {
        return kupiIzdanje;
    }

    public void setKupiIzdanje(Boolean kupiIzdanje) {
        this.kupiIzdanje = kupiIzdanje;
    }
}
