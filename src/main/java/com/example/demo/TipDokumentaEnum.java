package com.example.demo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public enum TipDokumentaEnum {
	DEBIT_NOTE_RELATED_TO_GOODS_OR_SERVICES(80, "Debit note related to goods or services", "", VrstaDokumentaEnum.INVOICE), 
	METERED_SERVICES_INVOICE (82, "Metered services invoice", "RaÄŤun za mjerene usluge", VrstaDokumentaEnum.INVOICE), 
	DEBIT_NOTE_RELATED_TO_FINANCIAL_ADJUSTMENTS (84, "Debit note related to financial adjustment", "TereÄ‡enje za financijske ispravke", VrstaDokumentaEnum.INVOICE),
	INVOICING_DATA_SHEET(130, "Invoicing data sheet", "", VrstaDokumentaEnum.INVOICE), 
	DIRECT_PAYMENT_VALUATION(202, "Direct payment valuation", "", VrstaDokumentaEnum.INVOICE), 
	PROVISIONAL_PAYMENT_VALUATION(203, "Provisional payment valuation", "", VrstaDokumentaEnum.INVOICE), 
	PAYMENT_VALUATION(204, "Payment valuation", "", VrstaDokumentaEnum.INVOICE), 
	INTERIM_APPLICATION_FOR_PAYMENT(211, "Interim application for payment","",  VrstaDokumentaEnum.INVOICE), 
	PRICE_VARIATION_INVOICE(295, "Price variation invoice", "", VrstaDokumentaEnum.INVOICE), 
	PROFORMA_INVOICE (325, "Proforma invoice", "PredraÄŤun", VrstaDokumentaEnum.INVOICE),
	PARTIAL_INVOICE (326, "Partial invoice", "Parcijalni raÄŤun", VrstaDokumentaEnum.INVOICE),
	COMMERCIAL_INVOICE (380, "Commercial invoice", "Komercijalni raÄŤun", VrstaDokumentaEnum.INVOICE), 
	DEBIT_NOTE (383, "Debit note", "TereÄ‡enje", VrstaDokumentaEnum.INVOICE),
	CORRECTED_INVOICE (384, "Corrected invoice", "Korektivni raÄŤun", VrstaDokumentaEnum.INVOICE),
	CONSOLIDATED_INVOICE(385, "Consolidated invoice", "", VrstaDokumentaEnum.INVOICE), 
	PREPAYMENT_INVOICE (386, "Prepayment invoice", "RaÄŤun za predujam", VrstaDokumentaEnum.INVOICE),
	HIRE_INVOICE(387, "Hire invoice", "", VrstaDokumentaEnum.INVOICE),
	TAX_INVOICE(388, "Tax invoice", "", VrstaDokumentaEnum.INVOICE), 
	SELF_BILLED_INVOICE (389, "Self-billed invoice", "SamoizdavajuÄ‡i raÄŤun", VrstaDokumentaEnum.INVOICE),
	DELCREDERE_INVOICE(390, "Delcredere invoice", "", VrstaDokumentaEnum.INVOICE), 
	FACTORED_INVOICE(393,"Factored invoice", "", VrstaDokumentaEnum.INVOICE),
	LEASE_INVOICE (394, "Lease invoice", "RaÄŤun za leasing", VrstaDokumentaEnum.INVOICE),
	CONSIGNMENT_INVOICE(395, "Consignment invoice", "", VrstaDokumentaEnum.INVOICE), 
	DEBIT_ADVICE(456,"Debit advice", "", VrstaDokumentaEnum.INVOICE),
	REVERSAL_OF_DEBIT(457, "Reversal of debit", "", VrstaDokumentaEnum.INVOICE), 
	SELF_BILLED_DEBIT_NOTE(527, "Self billed debit note", "", VrstaDokumentaEnum.INVOICE), 
	INSURERS_INVOICE(575, "Insurer's invoice", "", VrstaDokumentaEnum.INVOICE), 
	FORWARDERS_INVOICE(623, "Forwarder's invoice", "", VrstaDokumentaEnum.INVOICE), 
	PORT_CHARGES_DOCUMENTS(633, "Port charges documents", "", VrstaDokumentaEnum.INVOICE), 
	INVOICE_INFORMATION_FOR_ACCOUNTING_PURPOSES(751, "Invoice information for accounting purposes", "", VrstaDokumentaEnum.INVOICE), 
	FREIGHT_INVOICE(780, "Freight invoice", "", VrstaDokumentaEnum.INVOICE), 
	CUSTOMS_INVOICE(935, "Customs invoice", "", VrstaDokumentaEnum.INVOICE),
	
	CREDIT_NOTE_RELATED_TO_GOODS_OR_SERVICES(81, "Credit note related to goods or services", "", VrstaDokumentaEnum.CREDIT_NOTE), 
	CREDIT_NOTE_RELATED_TO_FINANCIAL_ADJUSTMENTS (83, "Credit note related to financial adjustments", "Odobrenje za financijske ispravke", VrstaDokumentaEnum.CREDIT_NOTE), 
	SELF_BILLED_CREDIT_NOTE(261, "Self billed credit note", "", VrstaDokumentaEnum.CREDIT_NOTE), 
	CONSOLIDATED_CREDIT_NOTE_GOODS_AND_SERVICES(262, "Consolidated credit note - goods and services", "", VrstaDokumentaEnum.CREDIT_NOTE), 
	CREDIT_NOTE_FOR_PRICE_VARIATION(296, "Credit note for price variation", "", VrstaDokumentaEnum.CREDIT_NOTE), 
	DELCREDERE_CREDIT_NOTE(308, "Delcredere credit note", "", VrstaDokumentaEnum.CREDIT_NOTE), 
	CREDIT_NOTE (381, "Credit note", "Odobrenje", VrstaDokumentaEnum.CREDIT_NOTE),
	FACTORED_CREDIT_NOTE(396, "Factored credit note", "", VrstaDokumentaEnum.CREDIT_NOTE), 
	OPTICAL_CHARACTER_READING_PAYMENT_CREDIT_NOTE(420, "Optical Character Reading (OCR) payment credit note", "", VrstaDokumentaEnum.CREDIT_NOTE), 
	REVERSAL_OF_CREDIT(458, "Reversal of credit", "", VrstaDokumentaEnum.CREDIT_NOTE), 
	FORWARDERS_CREDIT_NOTE(532, "Forwarder's credit note", "", VrstaDokumentaEnum.CREDIT_NOTE),
	REMINDER (999, "Reminder", "Opomena", VrstaDokumentaEnum.INVOICE); // Opomena

	//SVI(9999, "Koristi se kod prava i predstavlja sve dokumente osim posebno specificiranih", "", VrstaDokumentaEnum.INVOICE);

	private Integer iSifra;
	private String iNaziv;
	private String iHrvNaziv;
	private VrstaDokumentaEnum iVrstaDokumenta;

	private static final Map<Integer, TipDokumentaEnum> lookup = new HashMap<>();
	private static final Map<Integer, Integer> mapSinkroniStareSifre = new HashMap<>();

	static {
		for (TipDokumentaEnum tTipDokumenta : TipDokumentaEnum.values()) {
			lookup.put(tTipDokumenta.iSifra, tTipDokumenta);
			// mapiranje 'starih' sifri na nove
			mapSinkroniStareSifre.put(19, 380);
			mapSinkroniStareSifre.put(42, 381);
			mapSinkroniStareSifre.put(43, 999); // ? vidi FIXME za REMINDER...
		}
	}

	private TipDokumentaEnum(Integer pSifra, String pNaziv, String pHrvNaziv, VrstaDokumentaEnum pVrstaDokumenta) {
		iSifra = pSifra;
		iNaziv = pNaziv;
		iHrvNaziv = pHrvNaziv;
		iVrstaDokumenta = pVrstaDokumenta;
	}

	public Integer getSifra() {
		return iSifra;
	}

	public String getNaziv() {
		return iNaziv;
	}
	
	public String getHrvNaziv() {
		return iHrvNaziv;
	}

	public void setHrvNaziv(String pHrvNaziv) {
		iHrvNaziv = pHrvNaziv;
	}

	public VrstaDokumentaEnum getVrstaDokumenta() {
		return iVrstaDokumenta;
	}

	public static Set<Integer> getVrijednosti(final TipDokumentaEnum[] pTipDokumentaEnum) {
		final Set<Integer> tVrijednosti = new HashSet<>();
		for (TipDokumentaEnum tTipDokumentaEnum : pTipDokumentaEnum) {
			tVrijednosti.add(tTipDokumentaEnum.getSifra());
		}
		return tVrijednosti;
	}

	public static TipDokumentaEnum get(final int pSifra) {
		return lookup.get(pSifra);
	}

	public static TipDokumentaEnum getSinkroniSifra(final Integer pSifra) {
		if (mapSinkroniStareSifre.containsKey(pSifra))
			return lookup.get(mapSinkroniStareSifre.get(pSifra));
		else
			return lookup.get(pSifra);
	}

	public static Set<Integer> getVrijednostiByGrupa(VrstaDokumentaEnum pVrstaDokumenta) {
		final Set<Integer> tVrijednosti = new HashSet<>();
		for (TipDokumentaEnum tTipDokumentaEnum : TipDokumentaEnum.values()) {
			if (tTipDokumentaEnum.getVrstaDokumenta().equals(pVrstaDokumenta)) {
				tVrijednosti.add(tTipDokumentaEnum.getSifra());
			}
		}
		return tVrijednosti;
	}
}
