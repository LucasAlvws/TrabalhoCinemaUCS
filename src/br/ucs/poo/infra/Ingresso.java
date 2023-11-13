package br.ucs.poo.infra;
import java.util.Date;
import java.util.List;

public class Ingresso {
	private String nomeComprador;
	private Date data;
	private String celular;
	private float preco;
	private boolean meiaEntrada;
	private List<Assento> assentos;
	private Horario horario;
	
	
	public Horario getHorario() {
		return horario;
	}
	public void setHorario(Horario horario) {
		this.horario = horario;
	}
	public List<Assento> getAssentos() {
		return assentos;
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
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public boolean isMeiaEntrada() {
		return meiaEntrada;
	}
	public void setMeiaEntrada(boolean meiaEntrada) {
		this.meiaEntrada = meiaEntrada;
	}
	
	
}
