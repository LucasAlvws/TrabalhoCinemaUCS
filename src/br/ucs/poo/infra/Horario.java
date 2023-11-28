package br.ucs.poo.infra;
import static java.lang.Integer.parseInt;

import java.io.Serializable;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Horario implements Serializable{
	private Date data;
	private String horario;
	private Sala sala;
	private int codigo;
	
	public Horario() {
		
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int c) {
		this.codigo = c;
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

	public int getHora() {
		return parseInt(horario.substring(0, 2));
	}

	public int getMinutos() {
		return parseInt(horario.substring(3, 5));
	}

	public String listarDetalhes() {
		StringBuilder retorno = new StringBuilder();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		String dataFormatada;
		retorno.append("-------------------\n");
		dataFormatada = formato.format(data);
		retorno.append("-\n");
		retorno.append("Código: "+ getCodigo() +"Sala N°: " + getSala().getNumero() + " Data: " + dataFormatada + " Horário: " + getHorario() + "\n");

		retorno.append("-------------------\n");
		return retorno.toString();
	}
	
}
