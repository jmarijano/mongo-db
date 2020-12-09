package com.example.demo;

public enum DataInterchangeMethodEnum {

	PKI(1, "PKI"), EDI(2, "EDI"), OTH(3, "OTH"), NIJE_DEFINIRANO(4, "NIJE DEFINIRANO"), NE_DOHVACA_SE(5, "");

	private Integer iValue;
	private String iName;

	private DataInterchangeMethodEnum(Integer pValue, String pName) {
		iValue = pValue;
		iName = pName;
	}

	public Integer getValue() {
		return iValue;
	}

	public String getName() {
		return iName;
	}

}
