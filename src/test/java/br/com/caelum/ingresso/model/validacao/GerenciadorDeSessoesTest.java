package br.com.caelum.ingresso.model.validacao;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.caelum.ingresso.model.Filme;
import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.Sessao;

public class GerenciadorDeSessoesTest {
	
	private GerenciadorDeSessoes gs;
	private Sessao sessaoNova;
	
	private Filme filme;
	private Sala sala;
	
	private Sessao sessaoDasDez;
	private Sessao sessaoDasTreze;
	private Sessao sessaoDasDezoito;
	
	@Before
	public void preparaCenario() {
		this.gs = new GerenciadorDeSessoes();
		LocalTime horario = LocalTime.of(10,00);
		this.filme = new Filme("Matrix", Duration.ofMinutes(120), "Ação");
		this.sala = new Sala("Sala 01");
		this.sessaoNova = new Sessao(horario, filme, sala);
		
		this.sessaoDasDez = new Sessao(LocalTime.parse("10:00:00"), filme, sala);
		this.sessaoDasTreze = new Sessao(LocalTime.parse("13:00:00"), filme, sala);
		this.sessaoDasDezoito = new Sessao(LocalTime.parse("18:00:00"), filme, sala);
	}
	
	@Test
	public void deveCaberSessaoSeListaEstiverVazia() {
		//Cria cenario
		List<Sessao> sessoes = Collections.emptyList();
		//Simulacao		
		boolean coube = this.gs.cabe(sessaoNova, sessoes);
		
		//Assercao
		Assert.assertTrue(coube);
	}
	
	@Test
	public void garanteQueNaoDevePermitirSessaoNoMesmoHorario() {
		List<Sessao> sessoes = Arrays.asList(sessaoDasDez);
		Assert.assertFalse(this.gs.cabe(sessaoDasDez, sessoes));
		
	}
	
	@Test
	public void garanteQueNaoDevePermitirSessoesTerminandoDentroDoHorarioDeUmaSessaoJaExistente() {
		List<Sessao> sessoes = Arrays.asList(sessaoDasDez);
		Sessao sessaoQueTerminaDentroDeUmaOutra = new Sessao(sessaoDasDez.getHorario().minusHours(1), filme, sala);
		Assert.assertFalse(this.gs.cabe(sessaoQueTerminaDentroDeUmaOutra, sessoes));
	}
	
	@Test
	public void garanteQueNaoDevePermitirSessoesIniciandoDentroDoHorarioDeUmaSessaoJaExistente() {
		List<Sessao> sessoes = Arrays.asList(sessaoDasDez);
		Sessao sessaoQueComecaDentroDeUmaOutra = new Sessao(sessaoDasDez.getHorario().plusHours(1), filme, sala);
		Assert.assertFalse(this.gs.cabe(sessaoQueComecaDentroDeUmaOutra, sessoes));
	}
	@Test
	public void garanteQueDevePermitirUmaInsercaoEntreDoisFilmes() {
		List<Sessao> sessoes = Arrays.asList(sessaoDasDez, sessaoDasDezoito);
		Assert.assertTrue(this.gs.cabe(sessaoDasTreze, sessoes));
	}

}
