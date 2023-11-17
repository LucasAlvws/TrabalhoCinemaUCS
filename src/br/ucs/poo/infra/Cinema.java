package br.ucs.poo.infra;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import br.ucs.poo.error.DataErradaException;
import br.ucs.poo.error.PessoaNaoEncontradaException;
import br.ucs.poo.error.SalaNaoEncontradaException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
		 retorno.append("-------------------\n");
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
	
	public boolean setSala(int num) {
		Sala sala = new Sala();
		
		boolean ex = false;
		for(Sala s : salas) {
			if(s.getNumero() == num) {
				ex = true;
			}
		}
		if(ex) {
			return false;
		}
		else {
			sala.setNumero(num);
			this.salas.add(sala);
			return true;
		}
	}
	
	public Sala getSala(int num) throws SalaNaoEncontradaException{
		for( Sala s : this.salas) {
			if(s.getNumero() == num) {
				return s;
			}
		}
		throw new SalaNaoEncontradaException();

	}
	
	public String listarSalas() {
		 StringBuilder retorno = new StringBuilder();
		 retorno.append("-------------------\n");
		 try {
			for (Sala s : salas) {
				retorno.append("-\n");
				retorno.append("Sala N°: " + s.getNumero() + "\n");
	        }
			retorno.append("-------------------\n");
			
		 }
		 catch (NullPointerException e) {
			retorno.append("Nenhum Gênero registrado.\n"); 
		}
		return retorno.toString();
	 }
	
	public void setPessoa(String nome, String pais, String tipo, Pessoa conjuge) {
		if(tipo=="ator") {
			Ator pessoa = new Ator();
			pessoa.setNome(nome);
			pessoa.setPaisOrigem(pais);
			pessoa.setConjuge(conjuge);
			this.atores.add(pessoa);
		}
		else {
			System.out.println("aaa");
			Diretor pessoa = new Diretor();
			pessoa.setNome(nome);
			pessoa.setPaisOrigem(pais);
			pessoa.setConjuge(conjuge);
			this.diretores.add(pessoa);
		}
		
	}
	
	public Pessoa getPessoa(String nome) throws PessoaNaoEncontradaException{
		List<Pessoa> lista = new ArrayList<Pessoa>();
		lista.addAll(this.atores);
		lista.addAll(this.diretores);
		for( Pessoa p : lista) {
			System.out.println(p.getNome() + "/" + nome);
			if(p.getNome().equalsIgnoreCase(nome)){
				return p;
			}
		}
		throw new PessoaNaoEncontradaException();

	}
	
	public String listarPessoa(String tipo) {
		 StringBuilder retorno = new StringBuilder();
		 List<Pessoa> lista = new ArrayList<Pessoa>();
		 if(tipo=="ator") {
			 lista.addAll(this.atores);
		 }
		 else {
			 lista.addAll(this.diretores);
		 }
		 retorno.append("-------------------\n");
		 try {
			for (Pessoa a : lista) {
				retorno.append("-\n");
				retorno.append("Nome: " + a.getNome() + " País: " + a.getPaisOrigem());
				try {
					retorno.append(" Conjuge: " + a.getConjuge().getNome());
				} catch (Exception e) {
					retorno.append(" Conjuge: Nenhum");
				}
				
				retorno.append("\n");
	        }
			retorno.append("-------------------\n");
			
		 }
		 catch (NullPointerException e) {
			retorno.append("Nenhuma Pessoa registrada.\n"); 
		}
		return retorno.toString();
	 }
	
	public String listarTodasPessoas() {
		 StringBuilder retorno = new StringBuilder();
		 List<Pessoa> lista = new ArrayList<Pessoa>();
		 lista.addAll(this.atores);
		 lista.addAll(this.diretores);
		 retorno.append("-------------------\n");
		 try {
			for (Pessoa a : lista) {
				retorno.append("-\n");
				retorno.append("Nome: " + a.getNome() + " País: " + a.getPaisOrigem());
				try {
					retorno.append(" Conjuge: " + a.getConjuge().getNome());
				} catch (Exception e) {
					retorno.append(" Conjuge: Nenhum");
				}
				
				retorno.append("\n");
	        }
			retorno.append("-------------------\n");
			
		 }
		 catch (NullPointerException e) {
			retorno.append("Nenhuma Pessoa registrada.\n"); 
		}
		return retorno.toString();
	 }
	
	public void setHorario(String dataString, Sala sala, String horario) throws DataErradaException {
		Horario hora = new Horario();		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
            hora.setData(sdf.parse(dataString));
        } catch (ParseException e) {
            throw new DataErradaException();
        }
		hora.setHorario(horario);
		hora.setSala(sala);
		this.horarios.add(hora);
	}
	
	public String listarHorarios() {
		 StringBuilder retorno = new StringBuilder();
		 SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		 String dataFormatada;
		 retorno.append("-------------------\n");
		 try {
			for (Horario h : this.horarios) {
				dataFormatada = formato.format(h.getData());
				retorno.append("-\n");
				retorno.append("Sala N°: " + h.getSala().getNumero() + " Data: " + dataFormatada + " Horário: " + h.getHorario() + "\n");
	        }
			retorno.append("-------------------\n");
			
		 }
		 catch (NullPointerException e) {
			retorno.append("Nenhum Gênero registrado.\n"); 
		}
		return retorno.toString();
	 }
	
}
