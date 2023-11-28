package br.ucs.poo.infra;

import java.util.List;
import java.util.Set;

import br.ucs.poo.error.HorarioNaoEncontradaException;
import br.ucs.poo.error.PessoaNaoEncontradaException;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.text.SimpleDateFormat;

public class Filme implements Serializable{
	private String nome;
	private Date data_lancamento;
	private String descricao;
	private int duracao;
	private List<Ator> atores;
	private List<Diretor> diretores;
	private List<Ingresso> ingressos;
	private Genero genero;
	private List<Horario> horarios;
	
	public Filme() {
		this.atores =  new ArrayList<Ator>();
		this.diretores = new ArrayList<Diretor>();
		this.horarios = new ArrayList<Horario>();
		this.ingressos = new ArrayList<Ingresso>();
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

	public void setIngresso(Ingresso i) {
		ingressos.add(i);
	}

	public int getNIngressos() {
		return ingressos.size();
	}
	
	public Genero getGenero() {
		if (genero == null)
		{	
			Genero genero = new Genero();
			return genero;	
		}
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

	public List<Ator> getAtores() {
		return atores;
	}
	

	public void addAtor(Ator a) {
		if( this.atores != null) {
			this.atores.add(a);
		}
		else {
			this.atores =  new ArrayList<Ator>();
			this.atores.add(a);
		}
		
	}
	
	public List<Diretor> getDiretores() {
		return diretores;
	}

	public void addDiretor(Diretor a) {
		if( this.diretores != null) {
			this.diretores.add(a);
		}
		else {
			this.diretores =  new ArrayList<Diretor>();
			this.diretores.add(a);
		}
		
	}
	
	public void addHorario(Horario h) {
		if( this.horarios != null) {
			this.horarios.add(h);
		}
		else {
			this.horarios =  new ArrayList<Horario>();
			this.horarios.add(h);
		}
		
	}
	
	public List<Horario> getHorarios() {
		return horarios;
	}
	
	public String listarHorarios() throws HorarioNaoEncontradaException {
		StringBuilder retorno = new StringBuilder();
		 SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		 String dataFormatada;
		 retorno.append("-------------------\n");
		 if(this.horarios.size() == 0) {
			 throw new HorarioNaoEncontradaException(); 
		 }
		 try {
			for (Horario h : this.horarios) {
				dataFormatada = formato.format(h.getData());
				retorno.append("-\n");
				retorno.append("Código: "+ h.getCodigo() +" Sala N°: " + h.getSala().getNumero() + " Data: " + dataFormatada + " Horário: " + h.getHorario() + "\n");
	        }
			retorno.append("-------------------\n");
			
		 }
		 catch (NullPointerException e) {
			throw new HorarioNaoEncontradaException(); 
		}
		return retorno.toString();
	}
	
	public String listarDiretores() throws PessoaNaoEncontradaException{
		StringBuilder retorno = new StringBuilder();
		retorno.append("-------------------\n");
		try {
			if (diretores.size() == 0)
			{
				throw new PessoaNaoEncontradaException();
			}
			for (Pessoa a : diretores) {
				retorno.append("-\n");
				retorno.append("Nome: " + a.getNome() + " País: " + a.getPaisOrigem());
				
				retorno.append("\n");
	        }
			retorno.append("-------------------\n");
			
		 }
		 catch (NullPointerException e) {
			 throw new PessoaNaoEncontradaException(); 
		}
		return retorno.toString();
	}
	
	public String listarAtores() throws PessoaNaoEncontradaException{
		StringBuilder retorno = new StringBuilder();
		retorno.append("-------------------\n");
		try {
			if (atores.size() == 0)
			{
				throw new PessoaNaoEncontradaException();
			}
			for (Pessoa a : atores) {
				retorno.append("-\n");
				retorno.append("Nome: " + a.getNome() + " País: " + a.getPaisOrigem());
				
				retorno.append("\n");
	        }
			retorno.append("-------------------\n");
			
		 }
		 catch (NullPointerException e) {
			 throw new PessoaNaoEncontradaException(); 
		}
		return retorno.toString();
	}
	  

	public String listarDetalhes() 
	{
		StringBuilder retorno = new StringBuilder();
		retorno.append("-------------------\n");
		retorno.append("\nDescrição do filme: \n");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		retorno.append("Nome: " + this.getNome()+ "\n");
		retorno.append("Data de lançamento: " + sdf.format(this.getData_lancamento())+ "\n");
		retorno.append("Descrição: " + this.getDescricao()+ "\n");
		retorno.append("Gênero: " + this.getGenero().getNome()+ "\n");
		retorno.append("Duração: " + this.getDuracao() + "\n");
		retorno.append("Nº de ingressos vendidos " + this.getNIngressos() + "\n");
		if(atores != null) {
		retorno.append("-------------------Atores\n");
		for (Pessoa a : atores) {
			retorno.append("-\n");
			retorno.append("Nome: " + a.getNome() + " País: " + a.getPaisOrigem() + " ");
			retorno.append("Conjugê: ");
			if(a.getConjuge() != null) {
				retorno.append(a.getConjuge().getNome());
			}
			else {
				retorno.append("Nenhum");
			}
			retorno.append("\n");
        }
		retorno.append("-------------------");
		}
		if(diretores != null) {
		retorno.append("-------------------Diretores\n");
		for (Pessoa a : diretores) {
			retorno.append("-\n");
			retorno.append("Nome: " + a.getNome() + " País: " + a.getPaisOrigem() + " ");
			retorno.append("Conjugê: ");
			if(a.getConjuge() != null) {
				retorno.append(a.getConjuge().getNome());
			}
			else {
				retorno.append("Nenhum");
			}
			retorno.append("\n");
        }
		retorno.append("-------------------\n");
		}
		return retorno.toString();
	}
}
