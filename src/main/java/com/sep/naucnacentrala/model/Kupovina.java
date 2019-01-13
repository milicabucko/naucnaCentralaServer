package com.sep.naucnacentrala.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Kupovina implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long korisnikId;

    private Long proizvodId;

    private String tipProizvoda;

    private Integer brojMeseci;

    public Kupovina() {}

    public Kupovina(Long korisnikId, Long proizvodId, String tipProizvoda) {
        this.korisnikId = korisnikId;
        this.proizvodId = proizvodId;
        this.tipProizvoda = tipProizvoda;
    }

    public Kupovina(Long korisnikId, Long proizvodId, String tipProizvoda, Integer brojMeseci) {
        this.korisnikId = korisnikId;
        this.proizvodId = proizvodId;
        this.tipProizvoda = tipProizvoda;
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

    public Long getProizvodId() {
        return proizvodId;
    }

    public void setProizvodId(Long proizvodId) {
        this.proizvodId = proizvodId;
    }

    public String getTipProizvoda() {
        return tipProizvoda;
    }

    public void setTipProizvoda(String tipProizvoda) {
        this.tipProizvoda = tipProizvoda;
    }

    public Integer getBrojMeseci() {
        return brojMeseci;
    }

    public void setBrojMeseci(Integer brojMeseci) {
        this.brojMeseci = brojMeseci;
    }
}
