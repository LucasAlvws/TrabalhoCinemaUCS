package br.ucs.poo.infra;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import br.ucs.poo.error.DataErradaException;
import br.ucs.poo.error.FilmeNaoEncontradoException;
import br.ucs.poo.error.GeneroNaoEncontradaException;
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
	private List<Ingresso> ingressos;
	public String erroNenhumaSala = "Nenhuma Sala registrada.\n";
	
	public Cinema() {
		this.salas = new ArrayList<Sala>();
		this.filmes = new ArrayList<Filme>();
		this.generos = new ArrayList<Genero>();
		this.atores = new ArrayList<Ator>();
		this.diretores = new ArrayList<Diretor>();
		this.horarios = new ArrayList<Horario>();
		this.ingressos = new ArrayList<Ingresso>();
		
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
	
	public void deleteFilme(String f) throws FilmeNaoEncontradoException{
		try {
			Filme filme = new Filme();
			filme = getFilme(f);
			this.filmes.remove(filme);
		}catch (FilmeNaoEncontradoException e) {
			throw new FilmeNaoEncontradoException();
		}
	}
	
	public boolean MudarHor(String op_filme,String tipo,Date data_h,int sala, String op_horario, String op) {
		Filme f = new Filme();
		try {
			f = getFilme(op_filme);
			if(normalizeString(op).equalsIgnoreCase("addhor")) { 
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

	public boolean MudarFilme(String filme, String var, String op) throws GeneroNaoEncontradaException, PessoaNaoEncontradaException{
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
								try {
									ger = getGenero(var);
								} catch (GeneroNaoEncontradaException e) {
									throw new GeneroNaoEncontradaException();
								}
								f.setGenero(ger);}
							else {
								if(normalizeString(op).equalsIgnoreCase("addator")) { 
									Ator a;
									try {
										a = getAtor(var);
									} catch (PessoaNaoEncontradaException e) {
										throw new PessoaNaoEncontradaException();
									}
									f.addAtor(a);
									}
								else {
									if(normalizeString(op).equalsIgnoreCase("remator")) { 
										Ator a;
										try {
											a = getAtor(var);
										} catch (PessoaNaoEncontradaException e) {
											throw new PessoaNaoEncontradaException();
										}
										f.getAtores().remove(a);}
									else {
										if(normalizeString(op).equalsIgnoreCase("adddir")) { 
											Diretor a;
											try {
												a = getDiretor(var);
											} catch (PessoaNaoEncontradaException e) {
												throw new PessoaNaoEncontradaException();
											}
											f.addDiretor(a);
											}
										else {
											if(normalizeString(op).equalsIgnoreCase("remadir")) { 
												Diretor a;
												try {
													a = getDiretor(var);
												} catch (PessoaNaoEncontradaException e) {
													throw new PessoaNaoEncontradaException();
												}
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
	
	public String listarGeneros() throws GeneroNaoEncontradaException{
		 StringBuilder retorno = new StringBuilder();
		 retorno.append("-------------------\n");
		 try {
			if (this.generos.size() == 0)
			{
				throw new GeneroNaoEncontradaException();
			}
			for (Genero gen : this.generos) {
				retorno.append("-\n");
				retorno.append("Nome: " + gen.getNome() + "\n");
	        }
			retorno.append("-------------------\n");
			
		 }
		 catch (NullPointerException e) {
			 throw new GeneroNaoEncontradaException();
		}
		return retorno.toString();
	 }
	
	public void altGenero(String nome, String altNome) throws GeneroNaoEncontradaException{
		Genero g = new Genero();
		g = getGenero(nome);
		g.setNome(altNome);
	}
	
	public void deleteGenero(String nome) throws GeneroNaoEncontradaException {
		try {
			Genero g = new Genero();
			g = getGenero(nome);
			this.generos.remove(g);
		}catch (GeneroNaoEncontradaException e) {
			throw new GeneroNaoEncontradaException();
		}
	}
	
	public void altSala(int sala, int altNSala) throws SalaNaoEncontradaException{
		Sala s = new Sala();
		try {
			s = getSala(sala);
			s.setNumero(altNSala);
		} catch (SalaNaoEncontradaException e) {
			throw new SalaNaoEncontradaException();
		}
	}
	public void deleteSala(int sala) throws SalaNaoEncontradaException {
		try {
			Sala s = new Sala();
			s = getSala(sala);
			this.salas.remove(s);
		}catch (SalaNaoEncontradaException e) {
			throw new SalaNaoEncontradaException();
		}
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

			List<Assento> asss = new ArrayList<Assento>();

			for (int i = 1; i <= sala.getNumeroFileira(); i++) {
				for (int ii = 1; ii <= sala.getNPorFileira(); ii++) {
					Assento new_asseto = new Assento();
					new_asseto.setFileira(i);
					new_asseto.setNumero(ii);
					new_asseto.setSala(sala);

					asss.add(new_asseto);
				}	
			}
			sala.setAssentos(asss);
			
			
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
	
	public String listarSalas() throws SalaNaoEncontradaException{
		 StringBuilder retorno = new StringBuilder();
		 retorno.append("-------------------\n");
		 try {
			if (salas.size() == 0)
			{
				throw new SalaNaoEncontradaException();
			}
			for (Sala s : salas) {
				retorno.append("-\n");
				retorno.append("Sala N°: " + s.getNumero() + "\n");
	        }
			retorno.append("-------------------\n");
		 }
		 catch (NullPointerException e) {
			 throw new SalaNaoEncontradaException();
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

	public Diretor getDiretor(String nome) throws PessoaNaoEncontradaException {
		
		for (Diretor d : this.diretores) {
			if ((normalizeString(d.getNome())).equals(normalizeString(nome))) {
				return d;
			}
		}
		throw new PessoaNaoEncontradaException();
	}

	public Horario getHorario(Date data, int sala, String hora) throws HorarioNaoEncontradaException {
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

	public Ator getAtor(String nome) throws PessoaNaoEncontradaException{
		
		for (Ator a : this.atores) {
			if ((normalizeString(a.getNome())).equals(normalizeString(nome))) {
				return a;
			}
		}
		throw new PessoaNaoEncontradaException();
	}

	public Genero getGenero(String nome) throws GeneroNaoEncontradaException {
		
		for (Genero g : this.generos) {
			if (normalizeString(g.getNome()).equals(normalizeString(nome))) {
				return g;
			}
		}
		throw new GeneroNaoEncontradaException();
	}

	
	public Pessoa getPessoa(String nome) throws PessoaNaoEncontradaException{
		List<Pessoa> lista = new ArrayList<Pessoa>();
		lista.addAll(this.atores);
		lista.addAll(this.diretores);
		for( Pessoa p : lista) {
			if((normalizeString(p.getNome())).equals(normalizeString(nome))){
				return p;
			}
		}
		throw new PessoaNaoEncontradaException();

	}
	public void deletePessoa(String tipo,String nome) throws PessoaNaoEncontradaException {
		try {
		Pessoa p;
		if(tipo == "ator") {
			p = new Ator();
			p = getPessoa(nome);
			this.atores.remove(p);
		}
		else {
			p = new Diretor();
			p = getPessoa(nome);
			this.diretores.remove(p);
		}	
		}catch (PessoaNaoEncontradaException e) {
			throw new PessoaNaoEncontradaException();
		}
	}
	
	public void altPessoa(String tipo, String nome, String var, String alt) throws PessoaNaoEncontradaException {
		Pessoa p;
		if(tipo == "ator") {
			p = new Ator();
		}
		else {
			p = new Diretor();
		}
		
		try {
			p = getPessoa(nome);
			if(normalizeString(alt).equals("nome")) {
				p.setNome(var);
			}
			else {
				if(normalizeString(alt).equals("pais")) {
					p.setPaisOrigem(var);
				}
				else {
					if(normalizeString(alt).equals("conjuge")) {
						p.setConjuge(getPessoa(var));
					}
					else {
						throw new PessoaNaoEncontradaException();
					}
				}
			}
			
		} catch (PessoaNaoEncontradaException e) {
			throw new PessoaNaoEncontradaException();
		}
	}
	
	public String listarPessoa(String tipo)throws PessoaNaoEncontradaException {
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
				throw new PessoaNaoEncontradaException();
			}
			for (Pessoa a : lista) {
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
		 catch (NullPointerException e) {
			 throw new PessoaNaoEncontradaException(); 
		}
		return retorno.toString();
	 }
	
	public String listarTodasPessoas() throws PessoaNaoEncontradaException{
		 StringBuilder retorno = new StringBuilder();
		 List<Pessoa> lista = new ArrayList<Pessoa>();
		 lista.addAll(this.atores);
		 lista.addAll(this.diretores);
		 retorno.append("-------------------\n");
		 try {
			if (lista.size() == 0)
			{
				throw new PessoaNaoEncontradaException();
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
			 throw new PessoaNaoEncontradaException();
		}
		return retorno.toString();
	 }
	
	public void setHorario(Date data, Sala sala, String horario) throws DataErradaException{
		Horario hora = new Horario();		
		hora.setData(data);
		hora.setHorario(horario);
		hora.setSala(sala);
		this.horarios.add(hora);
	}

	public void setIngresso(Ingresso i) {
		this.ingressos.add(i);
	}

	public List<Ingresso> getIngressos() {
		return this.ingressos;
	}
	
	public String listarHorarios() throws HorarioNaoEncontradaException {
		 StringBuilder retorno = new StringBuilder();
		 SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		 String dataFormatada;
		 retorno.append("-------------------\n");
		 try {
			if (this.horarios.size() == 0)
			{
				throw new HorarioNaoEncontradaException();
			}
			for (Horario h : this.horarios) {
				dataFormatada = formato.format(h.getData());
				retorno.append("-\n");
				retorno.append("Sala N°: " + h.getSala().getNumero() + " Data: " + dataFormatada + " Horário: " + h.getHorario() + "\n");
	        }
			retorno.append("-------------------\n");
			
		 }
		 catch (NullPointerException e) {
			 throw new HorarioNaoEncontradaException(); 
		}
		return retorno.toString();
	 }
	
	public void altHorario(Date data, int sala, String horario ,Date var) throws HorarioNaoEncontradaException{
		Horario h = new Horario();
		try {
			h = getHorario(data, sala, horario);
			h.setData(var);
		} catch (HorarioNaoEncontradaException e) {
			throw new HorarioNaoEncontradaException();
		}
	}
	public void altHorario(Date data, int sala, String horario ,Sala var)throws HorarioNaoEncontradaException {
		Horario h = new Horario();
		try {
			h = getHorario(data, sala, horario);
			h.setSala(var);
		} catch (HorarioNaoEncontradaException e) {
			throw new HorarioNaoEncontradaException();
		}
	}
	public void altHorario(Date data, int sala, String horario ,String var)throws HorarioNaoEncontradaException {
		Horario h = new Horario();
		try {
			h = getHorario(data, sala, horario);
			h.setHorario(var);
		} catch (HorarioNaoEncontradaException e) {
			throw new HorarioNaoEncontradaException();
		}
	}
	
	
	public void deleteHorario(Date data, int sala, String horario) throws HorarioNaoEncontradaException {
		try {
			Horario h = new Horario();
			h = getHorario(data, sala, horario);
			this.horarios.remove(h);
		}catch (HorarioNaoEncontradaException e) {
			throw new HorarioNaoEncontradaException();
		}
	}
}
