package br.ucs.poo.infra;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import br.ucs.poo.error.DataErradaException;
import br.ucs.poo.error.FilmeNaoEncontradoException;
import br.ucs.poo.error.HorarioNaoEncontradaException;
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
	public String erroNenhumaPessoa = "Nenhuma Pessoa registrada.\n";
	public String erroNenhumGenero = "Nenhum Gênero registrado.\n";
	public String erroNenhumHorario = "Nenhum Horário registrado.\n";
	public String erroNenhumaSala = "Nenhuma Sala registrada.\n";
	
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
		 SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		 try {
			for (Filme filme : this.filmes) {
				retorno.append("-\n");
				retorno.append("Nome: " + filme.getNome() + " Descrição: " + filme.getDescricao() + " Data: " + sdf.format(filme.getData_lancamento()) + " Gênero: " + filme.getGenero().getNome() +  " Duração: " + filme.getDuracao() + "\n");
			}
			retorno.append("-------------------\n");
			
		 }
		 catch (NullPointerException e) {
			retorno.append("Nenhum filme registrado.\n"); 
		}
		return retorno.toString();
	 }
	
	public boolean MudarHor(String op_filme,String tipo,Date data_h,int sala, String op_horario, String op) {
		Filme f = new Filme();
		try {
			f = getFilme(op_filme);
			if(normalizeString(op).equalsIgnoreCase("addhor")) { 
				System.out.println("aaas");
				Horario h;
				try {
					h = getHorario(data_h, sala, op_horario);
					f.addHorario(h);
				} catch (HorarioNaoEncontradaException e) {
					e.printStackTrace();
					return false;
				}
				}
			if(normalizeString(op).equalsIgnoreCase("remhor")) { 
				Horario h;
				try {
					h = getHorario(data_h, sala, op_horario);
					f.getHorarios().remove(h);
				} catch (HorarioNaoEncontradaException e) {
					e.printStackTrace();
					return false;
				}
				}
			
		} catch (FilmeNaoEncontradoException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean MudarFilme(String filme, String var, String op){
		Filme f = new Filme();
		try {
			f = getFilme(filme);
			if(normalizeString(op).equalsIgnoreCase("Nome")) { 
				f.setNome(var); }
			else {
				if(normalizeString(op).equalsIgnoreCase("Data")) { 
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			        try {
						f.setData_lancamento(sdf.parse(var));
					}  catch (ParseException e) {
						return false;
			        }
				}
				else {
					if(normalizeString(op).equalsIgnoreCase("Descrição")) { f.setDescricao(var); }
					else {
						if(normalizeString(op).equalsIgnoreCase("Duração")) { 
							int dur;
							dur = Integer.parseInt(var);
							f.setDuracao(dur); }
						else {
							if(normalizeString(op).equalsIgnoreCase("Gênero")) { 
								Genero ger;
								ger = getGenero(var);
								f.setGenero(ger);}
							else {
								if(normalizeString(op).equalsIgnoreCase("addator")) { 
									Ator a;
									a = getAtor(var);
									f.addAtor(a);
									}
								else {
									if(normalizeString(op).equalsIgnoreCase("remator")) { 
										Ator a;
										a = getAtor(var);
										f.getAtores().remove(a);}
									else {
										if(normalizeString(op).equalsIgnoreCase("adddir")) { 
											Diretor a;
											a = getDiretor(var);
											f.addDiretor(a);
											}
										else {
											if(normalizeString(op).equalsIgnoreCase("remadir")) { 
												Diretor a;
												a = getDiretor(var);
												f.getDiretores().remove(a);}
											else {
												return false;
											}
										}
									}
								}
							}
						}
					}
				}
			}
		} catch (FilmeNaoEncontradoException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	

	public List<Filme> searchFilmes(String qs) {
		List<Filme> filmes = new ArrayList<Filme>();

		for( Filme f : this.filmes) {
			if((normalizeString(f.getNome())).contains(normalizeString(qs))) {
				filmes.add(f);
			}
		}
		return filmes;
	}
	
	public Filme getFilme(String nome) throws FilmeNaoEncontradoException{
		for( Filme f : this.filmes) {
			if((normalizeString(f.getNome())).equals(normalizeString(nome))) {
				return f;
			}
		}
		throw new FilmeNaoEncontradoException();
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

	public String normalizeString(String string)
	{
		return string.toLowerCase().strip();
	}
	
	public String listarGeneros() {
		 StringBuilder retorno = new StringBuilder();
		 retorno.append("-------------------\n");
		 try {
			if (this.generos.size() == 0)
			{
				retorno.append(erroNenhumGenero);
			}
			for (Genero gen : this.generos) {
				retorno.append("-\n");
				retorno.append("Nome: " + gen.getNome() + "\n");
	        }
			retorno.append("-------------------\n");
			
		 }
		 catch (NullPointerException e) {
			retorno.append(erroNenhumGenero); 
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
			if (salas.size() == 0)
			{
				retorno.append(erroNenhumaSala);
			}
			for (Sala s : salas) {
				retorno.append("-\n");
				retorno.append("Sala N°: " + s.getNumero() + "\n");
	        }
			retorno.append("-------------------\n");
		 }
		 catch (NullPointerException e) {
			retorno.append(erroNenhumaSala); 
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
			Diretor pessoa = new Diretor();
			pessoa.setNome(nome);
			pessoa.setPaisOrigem(pais);
			pessoa.setConjuge(conjuge);
			this.diretores.add(pessoa);
		}
		
	}

	public Diretor getDiretor(String nome) {
		Diretor diretor = new Diretor();
		
		for (Diretor d : this.diretores) {
			if ((normalizeString(d.getNome())).equals(normalizeString(nome))) {
				return d;
			}
		}
		return diretor;
	}

	public Horario getHorario(Date data, int sala, String hora) throws HorarioNaoEncontradaException {
		Horario horario = new Horario();
		
		for (Horario d : this.horarios) {
			if (d.getData().equals(data) && d.getSala().getNumero() == sala && normalizeString(d.getHorario()).equals(normalizeString(hora)) ) {
				return d;
			}
		}
		throw new HorarioNaoEncontradaException();
	}

	public List<Ator> getAtores() {
		return this.atores;
	}

	public Ator getAtor(String nome) {
		Ator ator = new Ator();
		
		for (Ator a : this.atores) {
			if ((normalizeString(a.getNome())).equals(normalizeString(nome))) {
				return a;
			}
		}
		return ator;
	}

	public Genero getGenero(String nome) {
		Genero gen = new Genero();
		
		for (Genero g : this.generos) {
			if (normalizeString(g.getNome()).equals(normalizeString(nome))) {
				return g;
			}
		}
		return gen;
	}

	
	public Pessoa getPessoa(String nome) throws PessoaNaoEncontradaException{
		List<Pessoa> lista = new ArrayList<Pessoa>();
		lista.addAll(this.atores);
		lista.addAll(this.diretores);
		for( Pessoa p : lista) {
			System.out.println(p.getNome() + "/" + nome);
			if((normalizeString(p.getNome())).equals(normalizeString(nome))){
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
			if (lista.size() == 0)
			{
				retorno.append(erroNenhumaPessoa);
			}
			for (Pessoa a : lista) {
				retorno.append("-\n");
				retorno.append("Nome: " + a.getNome() + " País: " + a.getPaisOrigem());
				
				retorno.append("\n");
	        }
			retorno.append("-------------------\n");
			
		 }
		 catch (NullPointerException e) {
			retorno.append(erroNenhumaPessoa); 
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
			if (lista.size() == 0)
			{
				retorno.append(erroNenhumaPessoa);
			}
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
			retorno.append(erroNenhumaPessoa); 
		}
		return retorno.toString();
	 }
	
	public void setHorario(String dataString, Sala sala, String horario) throws DataErradaException{
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
			if (this.horarios.size() == 0)
			{
				retorno.append(erroNenhumHorario);
			}
			for (Horario h : this.horarios) {
				dataFormatada = formato.format(h.getData());
				retorno.append("-\n");
				retorno.append("Sala N°: " + h.getSala().getNumero() + " Data: " + dataFormatada + " Horário: " + h.getHorario() + "\n");
	        }
			retorno.append("-------------------\n");
			
		 }
		 catch (NullPointerException e) {
			retorno.append(erroNenhumHorario); 
		}
		return retorno.toString();
	 }
	
}
