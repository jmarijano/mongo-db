package com.example.demo;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class PoslovniSubjekt {
	
	private Long idPs;
	private String nazivPs;
	private LocalDateTime datum;
	private List<OrganizacijskaJedinica> orgJedinice;
	public Long getIdPs() {
		return idPs;
	}
	public void setIdPs(Long idPs) {
		this.idPs = idPs;
	}
	public String getNazivPs() {
		return nazivPs;
	}
	public void setNazivPs(String nazivPs) {
		this.nazivPs = nazivPs;
	}
	public List<OrganizacijskaJedinica> getOrgJedinice() {
		return orgJedinice;
	}
	public void setOrgJedinice(List<OrganizacijskaJedinica> orgJedinice) {
		this.orgJedinice = orgJedinice;
	}
	public LocalDateTime getDatum() {
		return datum;
	}
	public void setDatum(LocalDateTime datum) {
		this.datum = datum;
	}

}
