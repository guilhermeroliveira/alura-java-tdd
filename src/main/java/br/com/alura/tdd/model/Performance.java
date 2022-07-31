package br.com.alura.tdd.model;

import java.math.BigDecimal;

public enum Performance {
	TO_BE_DESIRED(BigDecimal.valueOf(.03)),
	REGULAR(BigDecimal.valueOf(.15)),
	GOOD(BigDecimal.valueOf(.2));

	private Performance(BigDecimal modifier) {
		this.modifier = modifier;
	}

	private BigDecimal modifier;

	public BigDecimal getModifier() {
		return modifier;
	}
}
