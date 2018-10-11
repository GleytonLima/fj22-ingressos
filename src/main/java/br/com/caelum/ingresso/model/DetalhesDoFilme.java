package br.com.caelum.ingresso.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DetalhesDoFilme {

	@JsonProperty("Year")
	private String ano;
	
	@JsonProperty("Title")
	private String titulo;
	
	@JsonProperty("Plot")
	private String descricao;
	
	@JsonProperty("Poster")
	private String imagem;
	
	@JsonProperty("Director")
	private String diretores;
	
	@JsonProperty("Writer")	
	private String escritores;
	
	@JsonProperty("Actors")
	private String atores;
	
	@JsonProperty("Awards")
	private String avaliacao;

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagemURL) {
		this.imagem = imagemURL;
	}

	public String getDiretores() {
		return diretores;
	}

	public void setDiretores(String diretores) {
		this.diretores = diretores;
	}

	public String getEscritores() {
		return escritores;
	}

	public void setEscritores(String escritores) {
		this.escritores = escritores;
	}

	public String getAtores() {
		return atores;
	}

	public void setAtores(String atores) {
		this.atores = atores;
	}

	public String getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(String avaliacao) {
		this.avaliacao = avaliacao;
	}
	
}
