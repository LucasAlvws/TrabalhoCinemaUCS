package br.ucs.poo.infra;

import java.io.Serializable;

public class Assento implements Serializable{
	private String coordenada;
	private Sala sala;
	
	
	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public String getCoordenada() {
		return coordenada;
	}

	public void setCoordenada(String coordenada) {
		this.coordenada = coordenada;
	}
	
}
