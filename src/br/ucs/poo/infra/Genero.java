package br.ucs.poo.infra;

import java.io.Serializable;

public class Genero implements Serializable{
	private String nome;
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
	
}
