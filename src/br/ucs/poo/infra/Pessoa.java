package br.ucs.poo.infra;

import java.io.Serializable;

public abstract class Pessoa implements Serializable{
	private String nome;
	private String paisOrigem;
	private Pessoa conjuge;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPaisOrigem() {
		return paisOrigem;
	}
	public void setPaisOrigem(String paisOrigem) {
		this.paisOrigem = paisOrigem;
	}
	public Pessoa getConjuge() {
		return conjuge;
	}
	public void setConjuge(Pessoa conjuge) {
		this.conjuge = conjuge;
	}
	
}
