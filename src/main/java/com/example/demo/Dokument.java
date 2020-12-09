package com.example.demo;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Dokument {

	private Long idDokumenta;
	private Integer tipZaprimanja;
	private String tipZaprimanjaOpis;
	private Integer tipDokumenta;
	private String tipDokumentaOpis;
	private double iznos;

	public Long getIdDokumenta() {
		return idDokumenta;
	}

	public void setIdDokumenta(Long idDokumenta) {
		this.idDokumenta = idDokumenta;
	}

	public double getIznos() {
		return iznos;
	}

	public void setIznos(double iznos) {
		this.iznos = iznos;
	}

	public Integer getTipZaprimanja() {
		return tipZaprimanja;
	}

	public void setTipZaprimanja(Integer tipZaprimanja) {
		this.tipZaprimanja = tipZaprimanja;
	}

	public String getTipZaprimanjaOpis() {
		return tipZaprimanjaOpis;
	}

	public void setTipZaprimanjaOpis(String tipZaprimanjaOpis) {
		this.tipZaprimanjaOpis = tipZaprimanjaOpis;
	}

	public Integer getTipDokumenta() {
		return tipDokumenta;
	}

	public void setTipDokumenta(Integer integer) {
		this.tipDokumenta = integer;
	}

	public String getTipDokumentaOpis() {
		return tipDokumentaOpis;
	}

	public void setTipDokumentaOpis(String tipDokumentaOpis) {
		this.tipDokumentaOpis = tipDokumentaOpis;
	}

}
