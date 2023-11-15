package br.ucs.poo.infra;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
public class Cinema implements Serializable{
	private String nome;
	private String endereco;
	private List<Sala> salas;
	private List<Filme> filmes;
	private List<Genero> generos;
	private List<Ator> atores;
	private List<Diretor> diretores;
	private List<Horario> horarios;
	
	
	public Cinema() {
		this.salas = new ArrayList<Sala>();
		this.filmes = new ArrayList<Filme>();
		this.generos = new ArrayList<Genero>();
		this.atores = new ArrayList<Ator>();
		this.diretores = new ArrayList<Diretor>();
		this.horarios = new ArrayList<Horario>();
		
	}
	
	public Cinema(String nome, String endereco) {
		this.nome = nome;
		this.endereco = endereco;
	}

	public void setFilmes(String nome, Date data, String desc, int duracao, List<Ator> atores, List<Diretor> diretores, List<Horario> horarios, Genero genero) {
		Filme filme = new Filme(nome, data, desc, duracao,atores, diretores, horarios, genero);
		this.filmes.add(filme);
	}
	 public String listarFilmes() {
		 StringBuilder retorno = new StringBuilder();
		 try {
			for (Filme filme : this.filmes) {
				retorno.append("-\n");
				retorno.append("Nome: " + filme.getNome() + " Descrição: " + filme.getDescricao() + " Data: " + filme.getData_lancamento().toString() + " Gênero: " + filme.getGenero().getNome() + "\n");
	        }
			retorno.append("-------------------\n");
			
		 }
		 catch (NullPointerException e) {
			retorno.append("Nenhum filme registrado.\n"); 
		}
		return retorno.toString();
	 }
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public void setGeneros(String nome) {
		Genero gen = new Genero();
		gen.setNome(nome);
		this.generos.add(gen);
	}
	
	public String listarGeneros() {
		 StringBuilder retorno = new StringBuilder();
		 try {
			for (Genero gen : this.generos) {
				retorno.append("-\n");
				retorno.append("Nome: " + gen.getNome() + "\n");
	        }
			retorno.append("-------------------\n");
			
		 }
		 catch (NullPointerException e) {
			retorno.append("Nenhum Gênero registrado.\n"); 
		}
		return retorno.toString();
	 }
	
}
