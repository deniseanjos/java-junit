package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;

class BonusServiceTest {
	
	private BonusService service;
	
	@BeforeEach
	private void inicializar() {
		this.service = new BonusService();
	}

	@Test
	void testCalcularBonus_retornoDeveriaSerException() {
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
		var bonus = service.calcularBonus(new Funcionario("Teste", LocalDate.now(), new BigDecimal("2500")));
		assertEquals(new BigDecimal("250.00"), bonus);
	}
	
	@Test
	void testCalcularBonus_retornoDeveriaSerDezPorCentoDoSalarioExato() {
		var bonus = service.calcularBonus(new Funcionario("Teste", LocalDate.now(), new BigDecimal("10000")));
		assertEquals(new BigDecimal("1000.00"), bonus);
	}

}
