package br.com.caelum.ingresso.model;

import java.time.LocalTime;

public class Sessao {
	
	
	private Long id;
	
	private LocalTime dataHora;
	private Filme filme;
	private Sala sala;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalTime getDataHora() {
		return dataHora;
	}
	public void setDataHora(LocalTime dataHora) {
		this.dataHora = dataHora;
	}
	public Filme getFilme() {
		return filme;
	}
	public void setFilme(Filme filme) {
		this.filme = filme;
	}
	public Sala getSala() {
		return sala;
	}
	public void setSala(Sala sala) {
		this.sala = sala;
	}
	
	
	

}
