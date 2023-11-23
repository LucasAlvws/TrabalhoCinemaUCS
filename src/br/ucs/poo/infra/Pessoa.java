package br.ucs.poo.infra;

import java.io.Serializable;

public class Pessoa implements Serializable{
	private String nome;
	private String paisOrigem;
	private Pessoa conjuge;
	public String semNomeStr = "Nenhum";
	
	
	public String getNome() {
		if (nome == null)
		{
			return semNomeStr;
		}
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
		if (conjuge == null)
		{	
			Pessoa conj = new Pessoa();
			return conj;	
		}
		return conjuge;
	}
	public void setConjuge(Pessoa conjuge) {
		this.conjuge = conjuge;
	}
	
}
