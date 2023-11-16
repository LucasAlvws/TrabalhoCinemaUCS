package br.ucs.poo.infra;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Sala implements Serializable{
	private int numero;
	
	
	public Sala() {
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
}
