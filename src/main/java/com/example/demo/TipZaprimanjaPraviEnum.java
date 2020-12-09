package com.example.demo;

import java.util.HashMap;
import java.util.Map;

public enum TipZaprimanjaPraviEnum {

	GUI(1, "GUI", DataInterchangeMethodEnum.PKI), 
	DATOTEKA(2, "Datoteka", DataInterchangeMethodEnum.PKI),
	WS_EKSTERNI(3, "Eksterni web servis", DataInterchangeMethodEnum.NIJE_DEFINIRANO),
	WS_INTERNI(4, "Interni web servis", DataInterchangeMethodEnum.NE_DOHVACA_SE),
	WS_EDI(11, "EDI", DataInterchangeMethodEnum.EDI), 
	WS_PKI(12, "PKI", DataInterchangeMethodEnum.PKI),
	WS_OTHER(13, "OTHER", DataInterchangeMethodEnum.OTH), 
	WS_EDI_EN(21, "EDI Norma", DataInterchangeMethodEnum.EDI),
	WS_PKI_EN(22, "PKI Norma", DataInterchangeMethodEnum.PKI),
	WS_OTHER_EN(23, "OTHER Norma", DataInterchangeMethodEnum.OTH),
	WS_IP_EN(24, "IP Norma", DataInterchangeMethodEnum.PKI),
	WS_IP_EN_BEZ_POTPISA(25, "IP bez potpisa", DataInterchangeMethodEnum.OTH),
	ERACUN_REST_WS(31,"PKI Norma",DataInterchangeMethodEnum.PKI),
	WS_PREBACIVANJE(55,"Prebacivanje iz B2B u B2G",DataInterchangeMethodEnum.PKI),
	WS_PEPPOL(65, "PEPPOL", DataInterchangeMethodEnum.OTH);

	private Integer iSifra;
	private String iOpis;
	private DataInterchangeMethodEnum iDataInterChangeMethodEnum;

	private TipZaprimanjaPraviEnum(Integer pSifra, String pOpis, DataInterchangeMethodEnum dataInterChangeMethodEnum) {
		iSifra = pSifra;
		iOpis = pOpis;
		iDataInterChangeMethodEnum = dataInterChangeMethodEnum;
	}

	private static final Map<Integer, TipZaprimanjaPraviEnum> lookup = new HashMap<>();

	private static final Map<String, TipZaprimanjaPraviEnum> lookup2 = new HashMap<>();

	static {
		for (TipZaprimanjaPraviEnum pTipZaprimanja : TipZaprimanjaPraviEnum.values()) {
			lookup.put(pTipZaprimanja.getSifra(), pTipZaprimanja);
		}
	}

	static {
		for (TipZaprimanjaPraviEnum pTipZaprimanja : TipZaprimanjaPraviEnum.values()) {
			lookup2.put(pTipZaprimanja.getOpis(), pTipZaprimanja);
		}
	}

	public Integer getSifra() {
		return iSifra;
	}

	public String getOpis() {
		return iOpis;
	}

	public static TipZaprimanjaPraviEnum get(final int pSifra) {
		return lookup.get(pSifra);
	}

	public static TipZaprimanjaPraviEnum getByOpis(final String pOpis) {
		return lookup2.get(pOpis);
	}

	public DataInterchangeMethodEnum getiDataInterChangeMethodEnum() {
		return iDataInterChangeMethodEnum;
	}

}
