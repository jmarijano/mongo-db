package com.example.demo;

public enum TipZaprimanjaPretinac {

	WS(1, "Web servis"), WAPP(0, "Web aplikacija");

	private Integer iSifra;
	private String iOpis;

	TipZaprimanjaPretinac(int i, String string) {
		this.iSifra = i;
		this.iOpis = string;
	}

	public String getiOpis() {
		return iOpis;
	}

	public Integer getiSifra() {
		return iSifra;
	}

}
