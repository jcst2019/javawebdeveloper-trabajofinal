package com.mitocode.enums;

public enum Diagnostico {
	
	ALERGIA("Alergia"), ANEMIA("Anemia"), ANSIEDAD("Ansiedad"), BRONQUITIS("Bronquitis"), CONJUNTIVITIS("Conjuntivitis");

	private final String value;

	private Diagnostico(String value) {
		this.value = value;
	}

	public String getDisplayValue() {
		return value;
	}
}
