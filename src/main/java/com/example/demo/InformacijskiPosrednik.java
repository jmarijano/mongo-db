package com.example.demo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class InformacijskiPosrednik {

	private Integer idSustava;
	private Integer idInfPosrednika;
	private String nazivInfPosrednika;
	private List<Dokument> poslaniDokumenti;
	private List<Dokument> primljeniDokumenti;

	public Integer getIdSustava() {
		return idSustava;
	}

	public void setIdSustava(Integer integer) {
		this.idSustava = integer;
	}

	public Integer getIdInfPosrednika() {
		return idInfPosrednika;
	}

	public void setIdInfPosrednika(Integer idInfPosrednika) {
		this.idInfPosrednika = idInfPosrednika;
	}

	public String getNazivInfPosrednika() {
		return nazivInfPosrednika;
	}

	public void setNazivInfPosrednika(String nazivInfPosrednika) {
		this.nazivInfPosrednika = nazivInfPosrednika;
	}

	public List<Dokument> getPoslaniDokumenti() {
		return poslaniDokumenti;
	}

	public void setPoslaniDokumenti(List<Dokument> poslaniDokumenti) {
		this.poslaniDokumenti = poslaniDokumenti;
	}

	public List<Dokument> getPrimljeniDokumenti() {
		return primljeniDokumenti;
	}

	public void setPrimljeniDokumenti(List<Dokument> primljeniDokumenti) {
		this.primljeniDokumenti = primljeniDokumenti;
	}


}
