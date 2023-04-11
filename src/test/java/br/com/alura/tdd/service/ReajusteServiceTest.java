package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.DesempenhoeEnum;
import br.com.alura.tdd.modelo.Funcionario;

class ReajusteServiceTest {

	private ReajusteService service;
	private Funcionario funcionario;
	
	@BeforeEach
	public void inicializar() {
		this.service = new ReajusteService();
	}

	/**
	 * Cenário de teste através do TDD - Test-Driven Development
	 * Reajuste baseado no desempenho anual
	 * "A desejar" - 3%
	 * "Bom" - 15%
	 * "Ótimo" - 20%
	 */
	@Test
	void testCalcularReajuste_cenarioADesejar() {
		funcionario = new Funcionario("Teste", LocalDate.now(), new BigDecimal("1000"));
		
		service.calcularReajuste(funcionario, DesempenhoeEnum.A_DESEJAR);
		
		assertEquals(new BigDecimal("1030").setScale(2, RoundingMode.HALF_UP), funcionario.getSalario());
	}
	
	@Test
	void testCalcularReajuste_cenarioBom() {
		Funcionario funcionario = new Funcionario("Teste", LocalDate.now(), new BigDecimal("1000"));
		
		service.calcularReajuste(funcionario, DesempenhoeEnum.BOM);
		
		assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
	}
	
	@Test
	void testCalcularReajuste_cenarioOtimo() {
		Funcionario funcionario = new Funcionario("Teste", LocalDate.now(), new BigDecimal("1000"));
		
		service.calcularReajuste(funcionario, DesempenhoeEnum.OTIMO);
		
		assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
	}

}
