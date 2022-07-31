package br.com.alura.tdd.service;

import br.com.alura.tdd.model.Worker;

import java.math.BigDecimal;

public class BonusService {

	public BigDecimal calculateBonus(Worker worker) {
		BigDecimal value = worker.getWage().multiply(new BigDecimal("0.1"));
		if (value.compareTo(new BigDecimal("1000")) > 0)
			throw new IllegalArgumentException("Worker with wage bigger than R$10000 can not have a bonus");

		return value;
	}

}
