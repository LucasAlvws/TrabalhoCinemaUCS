package br.ucs.poo.infra;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Ingresso implements Serializable{
	private String nomeComprador;
	private Date data;
	private String celular;
	private static final float preco = 20;
	private boolean meiaEntrada;
	private Assento assento;
	private Horario horario;
	
	
	public Horario getHorario() {
		return horario;
	}
	public void setHorario(Horario horario) {
		this.horario = horario;
	}
	public Assento getAssento() {
		return assento;
	}

	public void setAssento(Assento asss) {
		this.assento = asss;
	}
	/*public void setAssentos(List<Assento> assentos) {
		this.assentos = assentos;
	}*/
	public String getNomeComprador() {
		return nomeComprador;
	}
	public void setNomeComprador(String nomeComprador) {
		this.nomeComprador = nomeComprador;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}

	public float getPreco() {
		return preco;
	}

	public boolean isMeiaEntrada() {
		return meiaEntrada;
	}
	public void setMeiaEntrada(boolean meiaEntrada) {
		this.meiaEntrada = meiaEntrada;
	}
	
	
}
