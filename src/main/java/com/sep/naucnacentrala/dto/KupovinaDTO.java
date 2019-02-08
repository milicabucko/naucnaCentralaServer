package com.sep.naucnacentrala.dto;

public class KupovinaDTO {
	
	private Long korisnikId;
	
	private Long proizvodId;
	
	private Long tenantID;
	
	private Double cena;
	
	private String tipProizvoda;
	
	

	public KupovinaDTO() {
		super();
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

	public Long getTenantID() {
		return tenantID;
	}

	public void setTenantID(Long tenantID) {
		this.tenantID = tenantID;
	}

	public Double getCena() {
		return cena;
	}

	public void setCena(Double cena) {
		this.cena = cena;
	}

	public String getTipProizvoda() {
		return tipProizvoda;
	}

	public void setTipProizvoda(String tipProizvoda) {
		this.tipProizvoda = tipProizvoda;
	}	

}
