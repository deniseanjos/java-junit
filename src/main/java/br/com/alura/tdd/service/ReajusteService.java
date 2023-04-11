package br.com.alura.tdd.service;

import java.math.BigDecimal;

import br.com.alura.tdd.modelo.DesempenhoeEnum;
import br.com.alura.tdd.modelo.Funcionario;

public class ReajusteService {
	
	public void calcularReajuste(Funcionario funcionario, DesempenhoeEnum desempenho) {
		var reajuste = new BigDecimal("0");
		if(desempenho.equals(DesempenhoeEnum.A_DESEJAR)) {
			reajuste = funcionario.getSalario().multiply(new BigDecimal("0.03"));
			funcionario.reajustarSalario(reajuste);
		} else if(desempenho.equals(DesempenhoeEnum.BOM)) {
			reajuste = funcionario.getSalario().multiply(new BigDecimal("0.15"));
			funcionario.reajustarSalario(reajuste);
		} else if (desempenho.equals(DesempenhoeEnum.OTIMO)) {
			reajuste = funcionario.getSalario().multiply(new BigDecimal("0.20"));
			funcionario.reajustarSalario(reajuste);
		}
	}

}
