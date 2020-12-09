package com.example.demo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class OrganizacijskaJedinica {

	private Long idOrgJedinice;
	private String nazivOrgJedinice;
	private Integer tipZaprimanja;
	private String tipZaprimanjaOpis;
	private InformacijskiPosrednik infPosrednikSlanje;
	private InformacijskiPosrednik infPosrednikZaprimanje;

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

	public Long getIdOrgJedinice() {
		return idOrgJedinice;
	}

	public void setIdOrgJedinice(Long idOrgJedinice) {
		this.idOrgJedinice = idOrgJedinice;
	}

	public String getNazivOrgJedinice() {
		return nazivOrgJedinice;
	}

	public void setNazivOrgJedinice(String nazivOrgJedinice) {
		this.nazivOrgJedinice = nazivOrgJedinice;
	}

	public InformacijskiPosrednik getInfPosrednikSlanje() {
		return infPosrednikSlanje;
	}

	public void setInfPosrednikSlanje(InformacijskiPosrednik infPosrednikSlanje) {
		this.infPosrednikSlanje = infPosrednikSlanje;
	}

	public InformacijskiPosrednik getInfPosrednikZaprimanje() {
		return infPosrednikZaprimanje;
	}

	public void setInfPosrednikZaprimanje(InformacijskiPosrednik infPosrednikZaprimanje) {
		this.infPosrednikZaprimanje = infPosrednikZaprimanje;
	}


}
