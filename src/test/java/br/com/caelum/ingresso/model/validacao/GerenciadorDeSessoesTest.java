package br.com.caelum.ingresso.model.validacao;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.caelum.ingresso.model.Filme;
import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.Sessao;

public class GerenciadorDeSessoesTest {
	
	private Sessao sessaoNova;
	
	@Before
	public void preparaCenario() {
		LocalTime horario = LocalTime.of(10,00);
		Filme filme = new Filme("Matrix", Duration.ofMinutes(120), "Ação");
		Sala sala = new Sala("Sala 01");
		sessaoNova = new Sessao(horario, filme, sala);
	}
	
	@Test
	public void deveCaberSessaoSeListaEstiverVazia() {
		//Cria cenario
		List<Sessao> sessoes = Collections.emptyList();
		//Simulacao
		GerenciadorDeSessoes gs = new GerenciadorDeSessoes();		
		
		boolean coube = gs.cabe(sessaoNova, sessoes);
		
		//Assercao
		Assert.assertTrue(coube);
	}

}
