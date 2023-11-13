package br.ucs.poo.infra;
import java.util.Date;

public class Horario {
	private Date data;
	/*horario*/
	private Sala sala;
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Sala getSala() {
		return sala;
	}
	public void setSala(Sala sala) {
		this.sala = sala;
	}
	
}
