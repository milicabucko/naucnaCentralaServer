package com.sep.naucnacentrala.dto;

public class BitCoinDTO {
	
	private Long proizvodId;
	private String tipProizvoda;
    private Long korisnikId;
    private Double cena;
    private String transactionId;
    
	public String gettransactionId() {
		return transactionId;
	}
	public void settransactionId(String transactionId) {
		this.transactionId = transactionId;
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
	public Long getKorisnikId() {
		return korisnikId;
	}
	public void setKorisnikId(Long korisnikId) {
		this.korisnikId = korisnikId;
	}
	public Double getCena() {
		return cena;
	}
	public void setCena(Double cena) {
		this.cena = cena;
	}

}
