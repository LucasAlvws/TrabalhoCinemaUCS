package br.ucs.poo.infra;

import java.util.List;
import java.util.Set;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

public class Filme implements Serializable{
	private String nome;
	private Date data_lancamento;
	private String descricao;
	private int duracao;
	private List<Ator> atores;
	private List<Diretor> diretores;
	private Genero genero;
	private List<Horario> horarios;
	
	public Filme() {
		this.atores =  new ArrayList<Ator>();
		this.diretores = new ArrayList<Diretor>();
		this.horarios = new ArrayList<Horario>();
	}
	
	public Filme(String nome, Date data, String desc, int duracao, List<Ator> atores, List<Diretor> diretores, List<Horario> horarios, Genero genero) {
		this();
		this.nome = nome;
		this.data_lancamento = data;
		this.descricao = desc;
		this.duracao = duracao;
		this.atores = atores;
		this.diretores = diretores;
		this.horarios = horarios;
		this.genero = genero;
	}
	
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getData_lancamento() {
		return data_lancamento;
	}
	public void setData_lancamento(Date data_lancamento) {
		this.data_lancamento = data_lancamento;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getDuracao() {
		return duracao;
	}
	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	
	  
}
