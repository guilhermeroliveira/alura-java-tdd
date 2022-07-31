package br.com.alura.tdd.service;

import static org.hamcrest.MatcherAssert.assertThat;

import br.com.alura.tdd.model.Performance;
import br.com.alura.tdd.model.Worker;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class AdjustmentServiceTest {

	private static AdjustmentService service;
	private Worker worker;

	@BeforeAll
	public static void setUpAll(TestInfo info) {
		System.out.println();
		System.out.println("Starting " + info.getDisplayName() + " tests");
		service = new AdjustmentService();
	}

	@BeforeEach
	public void setUpEach() {
		this.worker = new Worker("Ana", LocalDate.now(), BigDecimal.valueOf(1000));
	}

	@AfterAll
	public static void afterAll(TestInfo info) {
		System.out.println("Ending " + info.getDisplayName() + " tests");
		System.out.println();
	}

	@AfterEach
	public void afterEach(TestInfo testInfo) {
		System.out.println(testInfo.getDisplayName());
	}

	@Test
	void adjust_should_be_of_three_percent_when_the_performance_left_to_be_desired() {
		service.concedeAdjustment(worker, Performance.TO_BE_DESIRED);

		assertThat(BigDecimal.valueOf(1030f), Matchers.comparesEqualTo(worker.getWage()));
	}

	@Test
	void adjust_should_be_of_three_percent_when_the_performance_is_regular() {
		service.concedeAdjustment(worker, Performance.REGULAR);

		assertThat(BigDecimal.valueOf(1150), Matchers.comparesEqualTo(worker.getWage()));
	}

	@Test
	void adjust_should_be_of_three_percent_when_the_performance_is_good() {
		service.concedeAdjustment(worker, Performance.GOOD);

		assertThat(BigDecimal.valueOf(1200f), Matchers.comparesEqualTo(worker.getWage()));
	}
}
