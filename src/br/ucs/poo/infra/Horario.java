package br.ucs.poo.infra;
import java.io.Serializable;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Horario implements Serializable{
	private Date data;
	private String horario;
	private Sala sala;
	
	public Horario() {
		
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
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
	public String listarDetalhes() {
		StringBuilder retorno = new StringBuilder();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		String dataFormatada;
		retorno.append("-------------------\n");
		dataFormatada = formato.format(data);
		retorno.append("-\n");
		retorno.append("Sala N°: " + getSala().getNumero() + " Data: " + dataFormatada + " Horário: " + getHorario() + "\n");

		retorno.append("-------------------\n");
		return retorno.toString();
	}
	
}
