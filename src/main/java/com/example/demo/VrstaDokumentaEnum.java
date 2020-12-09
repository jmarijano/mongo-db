package com.example.demo;

import java.util.HashMap;
import java.util.Map;

public enum VrstaDokumentaEnum {
	INVOICE(1, "urn:oasis:names:specification:ubl:schema:xsd:Invoice-2", "Invoice",
			"urn:oasis:names:specification:ubl:schema:xsd:Invoice-2::Invoice"),
	CREDIT_NOTE(2, "urn:oasis:names:specification:ubl:schema:xsd:CreditNote-2", "CreditNote",
			"urn:oasis:names:specification:ubl:schema:xsd:CreditNote-2::CreditNote"),
	REMINDER(3, "urn:oasis:names:specification:ubl:schema:xsd:Reminder-2", "Reminder",
			"urn:oasis:names:specification:ubl:schema:xsd:Reminder-2::Reminder"),
	CII(4, "urn:un:unece:uncefact:data:standard:CrossIndustryInvoice:100", "CrossIndustryInvoice",
			"urn:un:unece:uncefact:data:standard:CrossIndustryInvoice:100::CrossIndustryInvoice");

	private Integer iSifra;
	private String iNamespace;
	private String iRootElementName;
	private String iVrijednost;

	private VrstaDokumentaEnum(Integer pSifra, String pNamespace, String pRootElementName, String pVrijednost) {
		iSifra = pSifra;
		iNamespace = pNamespace;
		iRootElementName = pRootElementName;
		iVrijednost = pVrijednost;
	}

	public Integer getSifra() {
		return iSifra;
	}

	public void setSifra(Integer pSifra) {
		iSifra = pSifra;
	}

	public String getRootElementName() {
		return iRootElementName;
	}

	public String getNamespace() {
		return iNamespace;
	}

	public void setNamespace(String pNamespace) {
		iNamespace = pNamespace;
	}

	public String getVrijednost() {
		return iVrijednost;
	}

	public void setVrijednost(String pVrijednost) {
		iVrijednost = pVrijednost;
	}

	public static VrstaDokumentaEnum get(String pRootElementName) {
		return lookup.get(pRootElementName);
	}

	public static VrstaDokumentaEnum get(Integer pSifra) {
		return lookup2.get(pSifra);
	}

	private static final Map<String, VrstaDokumentaEnum> lookup = new HashMap<>();
	private static final Map<Integer, VrstaDokumentaEnum> lookup2 = new HashMap<>();

	static {
		for (VrstaDokumentaEnum pVrstaDokumentaEnum : VrstaDokumentaEnum.values()) {
			lookup.put(pVrstaDokumentaEnum.getRootElementName(), pVrstaDokumentaEnum);
		}
	}

	static {
		for (VrstaDokumentaEnum pVrstaDokumentaEnum : VrstaDokumentaEnum.values()) {
			lookup2.put(pVrstaDokumentaEnum.iSifra, pVrstaDokumentaEnum);
		}
	}
}
