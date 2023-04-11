package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;

class BonusServiceTest {
	
	@Test
	void testCalcularBonus_retornoDeveriaSerException() {
		BonusService service = new BonusService();
		var exception = assertThrows(IllegalArgumentException.class, 
				() -> service.calcularBonus(new Funcionario("Teste", LocalDate.now(), new BigDecimal("25000"))));
		assertTrue(exception.getMessage().contains("Funcionario nao elegivel ao bonus."));
		
		// Atraves de try catch
		try {
			service.calcularBonus(new Funcionario("Teste", LocalDate.now(), new BigDecimal("25000")));
			fail("Incorreto: Nao lancou exception.");
		} catch (Exception e) {
		}
	}
	
	@Test
	void testCalcularBonus_retornoDeveriaSerDezPorCentoDoSalario() {
		BonusService service = new BonusService();
		var bonus = service.calcularBonus(new Funcionario("Teste", LocalDate.now(), new BigDecimal("2500")));
		assertEquals(new BigDecimal("250").setScale(2, RoundingMode.HALF_UP), bonus);
	}
	
	@Test
	void testCalcularBonus_retornoDeveriaSerDezPorCentoDoSalarioExato() {
		BonusService service = new BonusService();
		var bonus = service.calcularBonus(new Funcionario("Teste", LocalDate.now(), new BigDecimal("10000")));
		assertEquals(new BigDecimal("1000").setScale(2, RoundingMode.HALF_UP), bonus);
	}

}
