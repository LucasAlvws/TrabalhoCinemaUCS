package br.ucs.poo.infra;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.ucs.poo.error.PessoaNaoEncontradaException;
import br.ucs.poo.error.AssentoNaoEncontradoException;

public class Sala implements Serializable{
	private int numero;
	private static final int n_fileiras = 8;
	private static final int n_por_fileira = 20;
	private List<Assento> assentos;
	
	public Sala() {
	}

	public int getNumero() {
		return numero;
	}

	public List<Assento> getAssentos(){
		return assentos;
	}

	public Assento getAssento(int fileira, int numero) throws AssentoNaoEncontradoException{
		for( Assento a : this.assentos) {
			
			if (a.getFileira() == fileira && a.getNumero() == numero)
			{
				return a;
			}
		}
		throw new AssentoNaoEncontradoException();
	}

	public void setAssentos(List<Assento> assentos) {
		this.assentos = assentos;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getNumeroFileira() {
		return n_fileiras;
	}

	public int getNPorFileira() {
		return n_por_fileira;
	}
}
