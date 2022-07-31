package br.com.alura.tdd.service;

import br.com.alura.tdd.model.Performance;
import br.com.alura.tdd.model.Worker;

import java.math.BigDecimal;

public class AdjustmentService {
	void concedeAdjustment(Worker worker, Performance performance) {
		BigDecimal wage = worker.getWage();
		worker.adjustWage(wage.multiply(performance.getModifier()));
	}
}
