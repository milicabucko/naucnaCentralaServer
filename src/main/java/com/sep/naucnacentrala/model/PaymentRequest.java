package com.sep.naucnacentrala.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PaymentRequest implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private Long korisnikId;

	private Long proizvodId;

	private String tipProizvoda;

	private Integer brojMeseci;

	private String bitCoinOrderId;

	private Double cena;
	
	private Integer paymentId;
	
	public PaymentRequest() {
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

	public String getBitCoinOrderId() {
		return bitCoinOrderId;
	}

	public void setBitCoinOrderId(String bitCoinOrderId) {
		this.bitCoinOrderId = bitCoinOrderId;
	}

	public Double getCena() {
		return cena;
	}

	public void setCena(Double cena) {
		this.cena = cena;
	}

	public Integer getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

}
