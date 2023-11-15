package br.ucs.poo.infra;

import java.io.Serializable;

public class Genero implements Serializable{
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
