package br.com.alura.tdd.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Worker {

	private String name;
	private LocalDate admissionDate;
	private BigDecimal wage;

	public Worker(String name, LocalDate admissionDate, BigDecimal wage) {
		this.name = name;
		this.admissionDate = admissionDate;
		this.wage = wage;
	}

	public String getName() {
		return name;
	}

	public LocalDate getAdmissionDate() {
		return admissionDate;
	}

	public BigDecimal getWage() {
		return wage;
	}

	public void adjustWage(BigDecimal adjustment) {
		this.wage = this.wage.add(adjustment);
	}
}
