package com.example.demo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public enum InformacijskiPosredniciEnum {
 
	B2B				(1, "FINA B2B",1), 
	MOJ_ERACUN		(3, "Moj e-RaÄŤun",1), 
	MSTART			(4, "mStart",1), 
	ESLOG			(5, "eSLOG",1), 
	INFODOM			(6, "Infodom",1), 
	INGEMARK		(7, "Ingemark",1), 
	PEPPOL			(10, "PEPPOL AP",1), 
	AS2_KORISNIK	(11, "AS2 korisnik",1), 
	WS_KORISNIK		(20, "WS korisnik",1), 
	MOJ_ERACUN_B2G	(31, "Moj e-RaÄŤun B2G",2), 
	MSTART_B2G		(41, "mStart B2G",2), 
	ESLOG_B2G		(51, "eSLOG B2G",2), 
	INFODOM_B2G		(61, "Infodom B2G",2), 
	INGEMARK_B2G	(71, "Ingemark B2G",2),
	FINA_WS			(92, "FINA WS",2),
	B2G				(2, "FINA B2G",2); 

	private Integer iSifra;
	private String iOznaka;
	private Integer iSustav;

	private static final Map<Integer, InformacijskiPosredniciEnum> lookup = new HashMap<>();
	
	static {
		for (InformacijskiPosredniciEnum tInformacijskiPosredniciEnum : InformacijskiPosredniciEnum.values()) {			
			lookup.put(tInformacijskiPosredniciEnum.getSifra(), tInformacijskiPosredniciEnum);
		}
	}
	
	private InformacijskiPosredniciEnum(final Integer pSifra, final String pOznaka, Integer pSustav) {
		this.iSifra = pSifra;
		this.iOznaka = pOznaka;
		this.setiSustav(pSustav);
	}

	public Integer getSifra() {
		return iSifra;
	}

	public String getOznaka() {
		return iOznaka;
	}


	public static Set<Integer> getVrijednosti(final InformacijskiPosredniciEnum[] pTipPoslovnogSubjektaEnum) {
		final Set<Integer> tVrijednosti = new HashSet<>();
		for (InformacijskiPosredniciEnum tTipPoslovnogSubjektaEnum : pTipPoslovnogSubjektaEnum) {
			tVrijednosti.add(tTipPoslovnogSubjektaEnum.getSifra());
		}
		return tVrijednosti;
	}

	public static InformacijskiPosredniciEnum getBySifra(final Integer pSifra) {
		return lookup.get(pSifra);
	}

	public Integer getiSustav() {
		return iSustav;
	}

	public void setiSustav(Integer iSustav) {
		this.iSustav = iSustav;
	}
}