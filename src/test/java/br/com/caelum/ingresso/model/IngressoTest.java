package br.com.caelum.ingresso.model;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class IngressoTest {
	
	private Sessao sessaoNova;	
	private Filme filme;
	private Sala sala;

	@BeforeEach
	public void preparaCenario() {
		System.out.println("preparaCenario");
		LocalTime horario = LocalTime.of(10,00);
		this.filme = new Filme("Matrix", Duration.ofMinutes(120), "Ação", new BigDecimal("12"));
		this.sala = new Sala("Sala 01",new BigDecimal("20.5"));
		this.sessaoNova = new Sessao(horario, filme, sala);
	}

	@Test
	@DisplayName("Não deve conceder descontos para Ingressos Normais")
	public void testarSemDesconto() {
		System.out.println("testarSemDesconto");
		Ingresso ingresso = new Ingresso(this.sessaoNova, new SemDesconto());
		BigDecimal precoEsperado = new BigDecimal("32.50");
		Assertions.assertEquals(precoEsperado, ingresso.getPreco());		
	}
	
	@Test
	@DisplayName("Deve conceder desconto de 5 reais para ingressos de clientes de bancos")
	public void testarDesconto30PorCento() {
		Ingresso ingresso = new Ingresso(this.sessaoNova, new DescontoBanco());
		BigDecimal precoEsperado = new BigDecimal("27.50");
		Assertions.assertEquals(precoEsperado, ingresso.getPreco());		
	}
	
	@Test
	@DisplayName("Deve conceder desconto de de 50 por cento para estudante")
	public void testarDescontoEstudante() {
		Ingresso ingresso = new Ingresso(this.sessaoNova, new DescontoEstudante());
		BigDecimal precoEsperado = new BigDecimal("16.25");
		Assertions.assertEquals(precoEsperado, ingresso.getPreco());		
	}

}
