package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.DesempenhoeEnum;
import br.com.alura.tdd.modelo.Funcionario;

public class ReajusteService {
	
	public void calcularReajuste(Funcionario funcionario, DesempenhoeEnum desempenho) {
		var percentual = desempenho.percentualReajuste();
		var reajuste = funcionario.getSalario().multiply(percentual);
		funcionario.reajustarSalario(reajuste);
	}

}
