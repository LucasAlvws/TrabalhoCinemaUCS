package br.ucs.poo.infra;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;
public class Cinema implements Serializable{
	private String nome;
	private String endereco;
	private List<Sala> salas;
	private Set<Filme> filmes;
	
	
	public Cinema(String nome, String endereco) {
		this.nome = nome;
		this.endereco = endereco;
	}

	public void setFilmes(String nome, Date data, String desc, int duracao, Set<Ator> atores, Set<Diretor> diretores, Set<Horario> horarios, Genero genero) {
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
	
	
}
