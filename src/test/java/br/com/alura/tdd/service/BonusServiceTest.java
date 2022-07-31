package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import br.com.alura.tdd.model.Worker;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class BonusServiceTest {

	private static BonusService service;

	@BeforeAll
	public static void setUpAll(TestInfo info) {
		System.out.println();
		System.out.println("Starting " + info.getDisplayName() + " tests");
		service = new BonusService();
	}

	@BeforeEach
	public void afterEach(TestInfo testInfo) {
		System.out.println(testInfo.getDisplayName());
	}

	@AfterAll
	public static void afterAll(TestInfo info) {
		System.out.println("Ending " + info.getDisplayName() + " tests");
		System.out.println();
	}

	@Test
	void should_throw_if_workers_wage_is_bigger_than_10000() {
		Worker worker = new Worker("Rodrigo", LocalDate.now(), BigDecimal.valueOf(10001));

		assertThrows(IllegalArgumentException.class,
				() -> service.calculateBonus(worker));
	}

	@Test
	void bonus_should_be_a_tenth_of_worker_wage() {
		BigDecimal bonus = service
				.calculateBonus(new Worker("Rodrigo", LocalDate.now(), BigDecimal.valueOf(250)));

		assertEquals(BigDecimal.valueOf(25f), bonus);
	}

	@Test
	void bonus_should_be_a_tenth_of_worker_wage_for_a_wage_of_10000() {
		BigDecimal bonus = service
				.calculateBonus(new Worker("Rodrigo", LocalDate.now(), BigDecimal.valueOf(10000)));

		assertEquals(BigDecimal.valueOf(1000f), bonus);
	}
}
