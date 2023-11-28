package br.ucs.poo.exec;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.util.Date;
import java.text.SimpleDateFormat;

import br.ucs.poo.error.FilmeNaoEncontradoException;
import br.ucs.poo.error.GeneroNaoEncontradaException;
import br.ucs.poo.data.DataManager;
import static java.lang.Integer.*;

import br.ucs.poo.error.AssentoNaoEncontradoException;
import br.ucs.poo.error.CarregarArquivoException;
import br.ucs.poo.error.DataErradaException;
import br.ucs.poo.error.FilmeNaoEncontradoException;
import br.ucs.poo.error.HorarioNaoEncontradaException;
import br.ucs.poo.error.PessoaNaoEncontradaException;
import br.ucs.poo.error.SalaNaoEncontradaException;
import br.ucs.poo.error.SalvarArquivoException;
import br.ucs.poo.infra.Assento;
import br.ucs.poo.infra.Ator;
import br.ucs.poo.infra.Filme;
import br.ucs.poo.infra.Cinema;
import br.ucs.poo.infra.Diretor;
import br.ucs.poo.infra.Genero;
import br.ucs.poo.infra.Horario;
import br.ucs.poo.infra.Ingresso;
import br.ucs.poo.infra.Pessoa;
import br.ucs.poo.infra.Sala;

public class Main {
	private static Scanner cmd;
	private Cinema cinema;
	
	public Main() {
		this.cinema = new Cinema();
		String caminhoDoArquivo = "src/br/ucs/poo/data/cinema.bin";
		File arquivo = new File(caminhoDoArquivo);
		if (arquivo.exists()) {
			try {
				cinema = DataManager.carregarDados(caminhoDoArquivo);
			} catch (CarregarArquivoException e) {
				System.out.println(e.getMessage());
			}
        } else {
        	this.cinema.setEndereco( "R. Francisco Getúlio Vargas, 1130 - Petrópolis");
			this.cinema.setNome("UCS");
			try {
				DataManager.salvarDados(cinema, caminhoDoArquivo);
			} catch (SalvarArquivoException e1) {
				e1.printStackTrace();
			}
        }
		
	}
																																																													
	public static void main(String[] args) {
		Main menu = new Main();
		menu.run();
	}
	
	public void run()
	{
		int opcao;
		cmd = new Scanner(System.in);
		
		while (true)
		{
			System.out.println("++++++++++++++++++++++Cinema " + this.cinema.getNome() + " ++++++++++++++++++++++");
			System.out.println("++++++++++++++++++++++" + this.cinema.getEndereco() + " ++++++++++++++++++++++");
			System.out.println("Escolha a opção:");
			System.out.println(" 1) Filmes");
			System.out.println(" 2) Gêneros");
			System.out.println(" 3) Atores");
			System.out.println(" 4) Diretores");
			System.out.println(" 5) Salas");
			System.out.println(" 6) Horarios");
			System.out.println(" 7) Compra de Ingresso");
			System.out.println(" 8) Pesquisa de Filme");
			System.out.println(" 9) Filmes em exibição");
			System.out.println(" 10) Sair");
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
			opcao = 0;
			try {
				opcao = cmd.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Digite uma opção válida.");
			}
			cmd.nextLine();
			switch (opcao) {
			case 1:
				crud("Filmes");
				break;
			case 2:
				crud("Gêneros");
				break;
			case 3:
				crud("Atores");
				break;
			case 4:
				crud("Diretores");
				break;
			case 5:
				crud("Salas");
				break;
			case 6:
				crud("Horarios");
				break;
			case 7:
				comprarIngresso();
				break;
			case 8:
				pesquisaFilme();
				break;
			case 9 :
				filmesExibicao();
				break;
			case 10:
				System.out.println("Deseja realmente sair? '1-Sim/2-Não'");
				opcao = cmd.nextInt();
				if (opcao == 1){
					saveCinema(cinema);
					System.out.println("Saindo...");
					cmd.close();
					System.exit(0);
				}
			}
		}
	}
	
	public void crud(String classe) {
		int opcaoCrud;
		while (true)
		{
			System.out.println("++++++++++++++++++++++Cinema " + this.cinema.getNome() + " ++++++++++++++++++++++");
			System.out.println(classe + ":");
			System.out.println(" 1) Add " + classe);
			System.out.println(" 2) Listar " + classe);
			System.out.println(" 3) Modificar " + classe);
			System.out.println(" 4) Excluir " + classe);
			System.out.println(" 5) Voltar");
			opcaoCrud = 0;
			try {
				opcaoCrud = cmd.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Digite uma opção válida.");
			}
			cmd.nextLine();
			if(classe.equals("Filmes")) {
				switch (opcaoCrud) {
				case 1:
					addFilme();
					break;
				case 2:
					listarFilmes();
					break;
				case 3:
					modificaFilme();
					break;
				case 4:
					excluiFilme();
					break;
				case 5:
					run();
					break;
					}
			}
			if(classe.equals("Gêneros")) {
				switch (opcaoCrud) {
				case 1:
					addGenero();
					break;
				case 2:
					System.out.println(listarGenero());
					break;
				case 3:
					modificaGenero();
					break;
				case 4:
					excluiGenero();
					break;
				case 5:
					run();
					break;
					}
			}
			if(classe.equals("Atores")) {
				switch (opcaoCrud) {
				case 1:
					addAtores();
					break;
				case 2:
					System.out.println(listarAtores());
					break;
				case 3:
					modificaAtores();
					break;
				case 4:
					excluiAtores();
					break;
				case 5:
					run();
					break;
					}
			}
			if(classe.equals("Diretores")) {
				switch (opcaoCrud) {
				case 1:
					addDiretores();
					break;
				case 2:
					System.out.println(listarDiretores());
					break;
				case 3:
					modificaDiretores();
					break;
				case 4:
					excluiDiretores();
					break;
				case 5:
					run();
					break;
					}
			}
			if(classe.equals("Salas")) {
				switch (opcaoCrud) {
				case 1:
					addSalas();
					break;
				case 2:
					System.out.println(listarSalas()); 
					break;
				case 3:
					modificaSalas();
					break;
				case 4:
					excluiSalas();
					break;
				case 5:
					run();
					break;
					}
			}
			if(classe.equals("Horarios")) {
				switch (opcaoCrud) {
				case 1:
					addHorarios();
					break;
				case 2:
					System.out.println(listarHorarios());
					break;
				case 3:
					modificaHorarios();
					break;
				case 4:
					excluiHorarios();
					break;
				case 5:
					run();
					break;
					}
			}
			
		}
	}

	public void typeError(String msg)
	{
		System.out.println("!!!!!!!!!");
		System.out.println(msg);
		System.out.println("!!!!!!!!!");
	}


	public void filmesExibicao() {

		Date data_um = getDateValidated("primeira data");

		Date data_dois = getDateValidated("segunda data");

		String hora_um = getHoraValidated("primeiro horário");

		String hora_dois = getHoraValidated("segundo horário");

		int minutos_um = (parseInt(hora_um.substring(0, 2)) * 60) + parseInt(hora_um.substring(3, 5));
		
		int minutos_dois = (parseInt(hora_dois.substring(0, 2)) * 60) + parseInt(hora_dois.substring(3, 5));
		
		List<Filme> filmes_exib = new ArrayList<Filme>();

		for (Filme f : this.cinema.getFilmes())
		{
			boolean exibido = false;
			for (Horario h : f.getHorarios())
			{	
				int h_min_geral = (h.getHora()* 60) + h.getMinutos();
				if ((h.getData().after(data_um) && h.getData().before(data_dois)) && (minutos_um < h_min_geral && h_min_geral < minutos_dois))
				{
					exibido = true;
				}
			}

			if (exibido == true)
			{
				filmes_exib.add(f);
			}
		}
		filmes_exib.sort(Comparator.comparing(Filme::getNIngressos).reversed());

		for (Filme f : filmes_exib)
		{
			System.out.println(f.listarDetalhes());
		}

	}

	public void altObj(String filme,String var,String tipo) throws GeneroNaoEncontradaException, PessoaNaoEncontradaException {
		try {
			if(this.cinema.MudarFilme(filme ,var, tipo)) {
				System.out.println(tipo + " modificado.");
			}
			else {
				System.out.println("Erro ao modificar o "+ tipo +".");
			}
		} catch (GeneroNaoEncontradaException e) {
			throw new GeneroNaoEncontradaException();
		}
		catch (PessoaNaoEncontradaException e) {
			throw new PessoaNaoEncontradaException();
		}
	}
	
	public void altObj(String filme,String var,String tipo, String addrem) throws GeneroNaoEncontradaException, PessoaNaoEncontradaException{
		try {
			if(this.cinema.MudarFilme(filme ,var, addrem)) {
				System.out.println(tipo + " modificado.");
			}
			else {
				System.out.println("Erro ao modificar o "+ tipo +".");
			}
		} catch (GeneroNaoEncontradaException e) {
			throw new GeneroNaoEncontradaException();
		}
		catch (PessoaNaoEncontradaException e) {
			throw new PessoaNaoEncontradaException();
		}
	}
	
	public boolean opcaoRepeat(String msg)
	{	
		boolean opcaoTrue = false;
		int opcao = 1;
		System.out.println(msg + " Você deseja continuar? 0-Não / 1-Sim");

		do {
			try {
				opcao = cmd.nextInt();
				cmd.nextLine();

				if (opcao != 1 && opcao != 0) { throw new Exception(""); }

				opcaoTrue = true;
			}
			catch (Exception e) {
				opcaoTrue = false;
			}
		} while (opcaoTrue == false);
		
		if (opcao == 1) return true;

		return false;
	}

	public boolean opcaoRepeatFullMsg(String msg)
	{	
		boolean opcaoTrue = false;
		int opcao = 1;
		System.out.println(msg + " 0-Não / 1-Sim");

		do {
			try {
				opcao = cmd.nextInt();
				cmd.nextLine();

				if (opcao != 1 && opcao != 0) { throw new Exception(""); }

				opcaoTrue = true;
			}
			catch (Exception e) {
				opcaoTrue = false;
			}
		} while (opcaoTrue == false);
		
		if (opcao == 1) return true;

		return false;
	}
	

	public void saveCinema(Cinema cinema)
	{	
		try {
			DataManager.salvarDados(cinema, "src/br/ucs/poo/data/cinema.bin");
		} catch (SalvarArquivoException e) {
			System.out.println(e.getMessage());
		}
	}


	public void comprarIngresso()
	{	
		Ingresso ing = new Ingresso();
		Filme f = new Filme();
		System.out.println("Listagem de filmes: ");
		System.out.println(this.cinema.listarFilmes());

		System.out.println("Digite o nome do filme desejado: ");
		String qs = cmd.nextLine();

		try {
			f = this.cinema.getFilme(qs);
			f.listarDetalhes();
		}catch (FilmeNaoEncontradoException e)
		{
			System.out.println(e.getMessage());
			run();
		}
		
		try {
			System.out.println(f.listarHorarios());
		}catch (HorarioNaoEncontradaException e) {
			System.out.println(e.getMessage());
		}
		
		int codigo = getIntValidated("código do horário desejado");

		Horario hor_obj = new Horario();
		try {
			hor_obj = this.cinema.getHorario(codigo);
		}catch (HorarioNaoEncontradaException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("0 - Assento disponível");
		System.out.println("X - Assento ocupado");
		printaAssentosHorario(hor_obj);
		
		int n_fileira = getIntValidated("Nº da fileira do assento");
		
		int numero = getIntValidated("Nº do assento");
		
		Assento assento = new Assento();
		try {
			assento = hor_obj.getSala().getAssento(n_fileira, numero);
		}
		catch (AssentoNaoEncontradoException e)
		{
			e.printStackTrace();
		}
		if (AssentoLivre(assento, hor_obj) == false) {
			System.out.println("Assento está indisponível");
			run();
		}
		
		String cancelmsg = "Usuário desejou cancelar a compra";
		if (opcaoRepeat("O Ingresso custa R$" + ing.getPreco()) == false)
		{
			System.out.println(cancelmsg);
			run();
		}

		System.out.println("Digite o seu nome: ");
		String seu_nome = cmd.nextLine();

		System.out.println("Digite o seu celular: ");
		String seu_cell = cmd.nextLine();

		boolean meia = false;
		if (opcaoRepeatFullMsg("Você deseja meia entrada?"))
		{
			meia = true;
		}
		
		ing.setNomeComprador(seu_nome);
		ing.setData(hor_obj.getData());
		ing.setCelular(seu_cell);
		ing.setMeiaEntrada(meia);
		ing.setAssento(assento);
		ing.setHorario(hor_obj);
		
		f.setIngresso(ing);
		this.cinema.setIngresso(ing);

		saveCinema(cinema);

		if (opcaoRepeat("Ingresso Comprado.")) { comprarIngresso(); }
	}

	public boolean AssentoLivre(Assento assento, Horario horario) {
		for( Ingresso ing : this.cinema.getIngressos()) {
			if (ing.getHorario() == horario && ing.getAssento() == assento)
			{
				return false;
			}
		}
		return true;
	}


	public void printaAssentosHorario(Horario h)
	{
		Sala s = h.getSala();
		StringBuilder retorno = new StringBuilder();
		retorno.append("\nFileira");
		for (int i = 1; i <= s.getNumeroFileira(); i++) {
			retorno.append("\n");
			retorno.append(i);
			retorno.append(" - ");
			for (int ii = 1; ii <= s.getNPorFileira(); ii++) {
				Assento assento = new Assento();
				
				try {
					assento = s.getAssento(i, ii);
				}
				catch (AssentoNaoEncontradoException e)
				{
					e.printStackTrace();
				}
				boolean ing_livre = AssentoLivre(assento, h);
				
				
				if (ing_livre == true)
				{
					retorno.append("0  ");
				}
				else
				{
					retorno.append("X  ");
				}
			}	
		}

		
		retorno.append("\n\n    ");
		for (int j = 1; j <= s.getNPorFileira(); j++) {
			retorno.append(j);
			if (j < 10)
			{
				retorno.append("  ");
			}
			else
			{
				retorno.append(" ");
			}
		}
		retorno.append(" - Número");

		System.out.println(retorno.toString());
	}
	

	public void pesquisaFilme()
	{	
		List<Filme> filmes = new ArrayList<Filme>();

		
		
		System.out.println("Pesquise: ");
		String qs = cmd.nextLine();

		System.out.println("\nLista de filmes pesquisados por '" + qs  +"': ");
		filmes = this.cinema.searchFilmes(qs);
	
		if (filmes.size() == 0)
		{
			System.out.println("Não foram encontrados nenhum filme por '"+ qs + "'.");
			run();
		}
		
		for( Filme f : filmes) {
			System.out.println("- " + f.getNome());
		}

		System.out.println("\nDigite o nome do filme desejado: ");
		String nFilme = cmd.nextLine();
		try {
			Filme f = this.cinema.getFilme(nFilme);
			System.out.println(f.listarDetalhes());
		}catch (FilmeNaoEncontradoException e)
		{
			System.out.println(e.getMessage());
		}
	}


	public String getHoraValidated(String getMsg)
	{
		boolean horaTrue = false;
		String hora = "";
		do {
			try {
				System.out.println("Digite a "+ getMsg +" (hh:mm): ");
				hora = cmd.nextLine();

				if (!hora.matches("\\d\\d:\\d\\d")) {
					horaTrue = false;
					throw new Exception();
				}

				if (parseInt(hora.substring(0, 2)) > 23)
				{
					horaTrue = false;
					throw new Exception();
				}

				if (parseInt(hora.substring(3, 5)) > 59)
				{
					horaTrue = false;
					throw new Exception();
				}

				horaTrue = true;
				
			}
			catch (Exception e) {
				typeError("Hora em formato inválido!");
				horaTrue = false;
			}
		} while (horaTrue == false);

		return hora;
	}

	public Date getDateValidated(String getMsg)
	{	
		boolean dataTrue = false;
		String data_lanc;
		Date dataFim = new Date();

		do {
			try {
				System.out.println("Digite a "+ getMsg +" (dd/mm/yyyy): ");
				data_lanc = cmd.nextLine();
				
				SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
				dataFim = formato.parse(data_lanc); 
				dataTrue = true;
			}
			catch(Exception e) {
				typeError("Data em formato inválido!");
				dataTrue = false;
			}
		} while (dataTrue == false);

		return dataFim;
	}

	public int getIntValidated(String getMsg)
	{
		int durac = 0;

		boolean duracaoTrue = false;

		do {
			try {
				System.out.println("Digite o(a) "+ getMsg + ": ");
				durac = parseInt(cmd.nextLine());
				duracaoTrue = true;
			} catch (Exception e)
			{	
				typeError(getMsg + " inválida!");
				duracaoTrue = false;
			}
		} while (duracaoTrue == false);

		return durac;
	}
	
	public void addFilme() {
		boolean  stopAtor = false, stopDiretor = false, stopGenero = false, stopHorario = false;
		
		System.out.println("Add Filmes:");

		// GET NOME ===================================================================
		System.out.println("Digite o nome do filme: ");
		String nome = cmd.nextLine();

		// GET DATA LANÇAMENTO ===================================================================
		Date dataLancData = getDateValidated("data de lançamento");

		// GET DESCRIÇÃO ===================================================================
		System.out.println("Digite a descrição: ");
		String desc = cmd.nextLine();

		// GET DURAÇÃO ===================================================================
		int durac = getIntValidated("duração (em minutos)");


		// GET ATORES ===================================================================
		List<Ator> atores_select = null;
		System.out.println("Adicionar Ator: ");
		atores_select = new ArrayList<Ator>();
		try {
			do {
				System.out.println(this.cinema.listarPessoa("ator"));
				System.out.println("Digite o nome do Ator: ");
				String ator_str = cmd.nextLine();
				Ator ator = this.cinema.getAtor(ator_str);
				if (ator.getNome() != ator.semNomeStr)
				{
					atores_select.add(ator);
					if (!opcaoRepeat("Ator adicionado.")) { stopAtor = true; }
				}
				else 
				{
					typeError("Não existe um ator com esse nome, por favor escolha um nome válido.");
				}
			} while (stopAtor == false);
		}
		catch(PessoaNaoEncontradaException e) {
			System.out.println(e.getMessage());
		}

		// GET GENERO ===================================================================
		Genero gen = null;
		try {
			do {
				System.out.println("Adicionar gênero: ");
				System.out.println(this.cinema.listarGeneros());
				System.out.println("Digite o nome do gênero: ");
				String genero = cmd.nextLine();
				try {
				gen = this.cinema.getGenero(genero);
				stopGenero = true;
				} catch (GeneroNaoEncontradaException e) {
					System.out.println("Não existe um gênero com esse nome, por favor escolha um nome válido.");
				}
				
			}
			 while (stopGenero == false);
		} catch (GeneroNaoEncontradaException e) {
			System.out.println(e.getMessage());
		}
		
		

		// GET DIRETORES ===================================================================

		List<Diretor> diretores_select = null;
		diretores_select = new ArrayList<Diretor>();
		System.out.println("Adicionar Diretor: ");
		try {
			do {
				System.out.println(this.cinema.listarPessoa("diretor"));
				System.out.println("Digite o nome do Diretor: ");
				String ator_str = cmd.nextLine();
				Diretor diretor = this.cinema.getDiretor(ator_str);
				if (diretor.getNome() != diretor.semNomeStr)
				{
					diretores_select.add(diretor);
					if (!opcaoRepeat("Diretor adicionado.")) { stopDiretor = true; }
				}
				else 
				{
					typeError("Não existe um diretor com esse nome, por favor escolha um nome válido.");
				}
			} while (stopDiretor == false);
		}
		catch (PessoaNaoEncontradaException e) {
			System.out.println(e.getMessage());
		}

		// GET HORÁRIOS ===================================================================
		List<Horario> horarios_select = null;
		horarios_select = new ArrayList<Horario>();
		try {
			do {
				System.out.println("Adicionar Horário: ");
				System.out.println(this.cinema.listarHorarios());
				int codigo = getIntValidated("código do horário desejado");
				Horario horario;
				try {
					horario = this.cinema.getHorario(codigo);
					horarios_select.add(horario);
				} catch (HorarioNaoEncontradaException e) {
					System.out.println(e.getMessage());
				}
				if (!opcaoRepeat("Horário adicionado.")) { stopHorario = true; }
			} while (stopHorario == false);
		}
		catch(HorarioNaoEncontradaException e) {
			System.out.println("Nenhum horário registrado.");
		}


		this.cinema.setFilmes(nome, dataLancData, desc, durac, atores_select, diretores_select, horarios_select, gen);

		saveCinema(cinema);
			
		if (opcaoRepeat("Filme salvo.")) { addFilme(); }
	}
	public void listarFilmes() {
		System.out.println("Lista de Filmes:");
		System.out.println(this.cinema.listarFilmes()); 
	}
	public void modificaFilme() {
		boolean stopFilme = false, stopalt=false;
		String tipo;
		String op_filme;
		int op_mod;
		try {
			do {
				System.out.println(this.cinema.listarFilmes()); 
				System.out.println("Qual filme você deseja modificar? (Digite o nome dele)");
				op_filme = cmd.nextLine();
				do {
					System.out.println(this.cinema.getFilme(op_filme).listarDetalhes());
					System.out.println("O que você deseja modificar nele?");
					System.out.println("1-Nome\n2-Data\n3-Descrição\n4-Duração\n5-Atores\n6-Diretores\n7-Horários\n8-Gênero\n9-Cancelar");
					op_mod = cmd.nextInt();
					cmd.nextLine();
					switch (op_mod) {
					case 1:
						String nome;
						System.out.println("Informe o novo nome:");
						nome = cmd.nextLine();
						tipo = "Nome";
						altObj(op_filme, nome, tipo);
						op_filme = nome;
						break;
					case 2:
						String data;
						System.out.println("Informe a nova data:");
						data = cmd.nextLine();
						tipo = "Data";
						altObj(op_filme, data, tipo);
						break;
					case 3:
						String desc;
						System.out.println("Informe a nova descrição:");
						desc = cmd.nextLine();
						tipo = "Descrição";
						altObj(op_filme, desc, tipo);
						break;
					case 4:
						String duracao;
						System.out.println("Informe a nova duração:");
						duracao = cmd.nextLine();
						tipo = "Duração";
						altObj(op_filme, duracao, tipo);
						break;
					case 5:
						int op;
						String nome_ator;
						try {
						System.out.println(this.cinema.getFilme(op_filme).listarAtores());
						}
						catch (PessoaNaoEncontradaException e) {
							System.out.println(e.getMessage());
						}
						System.out.println("Você deseja adicionar ou remover atores? 1-Adicionar/2-Remover/Outro-Sair");
						op = cmd.nextInt();
						cmd.nextLine();
						if(op == 1) {
							try {
								System.out.println(this.cinema.listarPessoa("ator"));
								System.out.println("Digite o nome do ator que você quer adicionar");
								nome_ator = cmd.nextLine();
								tipo = "Ator";
								altObj(op_filme, nome_ator, tipo, "addator");
							} catch (PessoaNaoEncontradaException e) {
								System.out.println(e.getMessage());
							}
							break;
						}
						if(op == 2) {
							try {
							System.out.println(this.cinema.getFilme(op_filme).listarAtores());
							}
							catch (PessoaNaoEncontradaException e) {
								System.out.println(e.getMessage());
							}
							System.out.println("Digite o nome do ator que você quer remover");
							nome_ator = cmd.nextLine();
							tipo = "Ator";
							altObj(op_filme, nome_ator, tipo, "remator");
							break;
						}
						break;
					case 6:
						String nome_dir;
						try {
						System.out.println(this.cinema.getFilme(op_filme).listarDiretores());
						}
						catch (PessoaNaoEncontradaException e) {
							System.out.println(e.getMessage());
						}
						System.out.println("Você deseja adicionar ou remover diretores? 1-Adicionar/2-Remover/Outro-Sair");
						op = cmd.nextInt();
						cmd.nextLine();
						if(op == 1) {
							try {
								System.out.println(this.cinema.listarPessoa("diretor"));
								System.out.println("Digite o nome do diretor que você quer adicionar");
								nome_dir = cmd.nextLine();
								tipo = "Diretor";
								altObj(op_filme, nome_dir, tipo, "adddir");
							} catch (PessoaNaoEncontradaException e) {
								System.out.println(e.getMessage());
							}
							break;
						}
						if(op == 2) {
							try {
							System.out.println(this.cinema.getFilme(op_filme).listarDiretores());
							}
							catch (PessoaNaoEncontradaException e) {
								System.out.println(e.getMessage());
							}
							System.out.println("Digite o nome do diretor que você quer remover");
							nome_dir = cmd.nextLine();
							tipo = "Diretor";
							altObj(op_filme, nome_dir, tipo, "remadir");
							break;
						}
						break;
					case 7:
						try {
						System.out.println(this.cinema.getFilme(op_filme).listarHorarios());
						}catch (HorarioNaoEncontradaException e) {
							System.out.println(e.getMessage());
						}
						System.out.println("Você deseja adicionar ou remover horarios? 1-Adicionar/2-Remover/Outro-Sair");
						op = cmd.nextInt();
						cmd.nextLine();
						if(op == 1) {
							try {
								System.out.println(this.cinema.listarHorarios());
								int codigo = getIntValidated("código do horário desejado");
								tipo = "Horário";
								
								if(this.cinema.MudarHor(op_filme,tipo, codigo, "addhor")) {
									System.out.println(tipo + " modificado.");
								}
								else {
									System.out.println("Erro ao modificar o "+ tipo +".");
								}
							} catch (HorarioNaoEncontradaException e) {
								System.out.println(e.getMessage());
							}
							break;
						}
						if(op == 2) {
							try {
							System.out.println(this.cinema.getFilme(op_filme).listarHorarios());
							}catch (HorarioNaoEncontradaException e) {
								System.out.println(e.getMessage());
							}
							int codigo = getIntValidated("código do horário desejado");
							tipo = "Horário";
							
							if(this.cinema.MudarHor(op_filme,tipo, codigo, "remhor")) {
								System.out.println(tipo + " modificado.");
							}
							else {
								System.out.println("Erro ao modificar o "+ tipo +".");
							}
							break;
						}
						break;
					case 8:
						String genero;
						System.out.println(this.cinema.listarGeneros());
						System.out.println("Informe o nome do novo gênero:");
						genero =cmd.nextLine();
						tipo = "Gênero";
						altObj(op_filme, genero, tipo);
						break;
					case 9:
						break;
					}
					saveCinema(cinema);
					if (!opcaoRepeat("Filme " +op_filme+ " Modificado.")) { stopalt = true; }
				}while(stopalt == false); 
				
				if (!opcaoRepeat("Filme Modificado.")) { stopFilme = true; }

			} while (stopFilme == false);

		} 
		catch (InputMismatchException e) {
			System.out.println("Saindo sem salvar...");
			cmd.nextLine();
		}
		catch (FilmeNaoEncontradoException e) {
			System.out.println("Saindo sem salvar...");
			System.out.println(e.getMessage());
		}
		catch (GeneroNaoEncontradaException e) {
			System.out.println("Saindo sem salvar...");
			System.out.println(e.getMessage());
		}
		catch (PessoaNaoEncontradaException e) {
			System.out.println("Saindo sem salvar...");
			System.out.println(e.getMessage());
		}
		 
		
		
		
	}
	public void excluiFilme() {
		boolean stopFilme = false;
		String op_filme, opcao = "Filme excluído" ;
		int op_s;
		try {
			do {
				System.out.println("Qual filme você deseja excluir?");
				System.out.println(this.cinema.listarFilmes());
				System.out.println("Digite o nome do filme: ");
				op_filme = cmd.nextLine();
				System.out.println(this.cinema.getFilme(op_filme).listarDetalhes());
				System.out.println("Você tem certeza que quer excluir esse filme? 1-Sim/0-Não");
				op_s = cmd.nextInt();
				cmd.nextLine();
				if(op_s == 1 ) {
					this.cinema.deleteFilme(op_filme);
				}
				else {
					opcao = "Filme não excluído";
				}
				saveCinema(cinema);
				if (!opcaoRepeat(opcao)) { stopFilme = true; }
	
			} while (stopFilme == false);
		}
		catch(FilmeNaoEncontradoException e) {
			System.out.println("Saindo sem salvar...");
			System.out.println(e.getMessage());
		}
	}

	public void addGenero() {
		boolean stopGenero = false;
		String nome;

		try {
			do {
				System.out.println("Add Gêneros:");
				System.out.println("Digite o nome do gênero: ");
				nome = cmd.nextLine();
				this.cinema.setGeneros(nome);
				
				saveCinema(cinema);
				
				if (!opcaoRepeat("Gênero salvo.")) { stopGenero = true; }

			} while (stopGenero == false);

		} catch (InputMismatchException e) {
			System.out.println("Valor inválido, saindo sem salvar...");
			cmd.nextLine();
		}
		
	}
	public String listarGenero() {
		System.out.println("Lista de Gêneros:");
		
		try {
			return this.cinema.listarGeneros();
		} catch (GeneroNaoEncontradaException e) {
			return e.getMessage();
		}
	}
	public void modificaGenero() {
		boolean stopGenero=false;
		String nome, altNome;
		try {
			do {
				System.out.println("Qual gênero você deseja modificar?");
				System.out.println(this.cinema.listarGeneros());
				System.out.println("Digite o nome do gênero:");
				nome = cmd.nextLine();
				System.out.println("Digite o novo nome do gênero:");
				altNome = cmd.nextLine();
			
				this.cinema.altGenero(nome, altNome);
			
				saveCinema(cinema);
				if (!opcaoRepeat("Gênero modificado.")) { stopGenero = true; }

			} while (stopGenero == false);
		} catch (GeneroNaoEncontradaException e) {
			System.out.println(e.getMessage());
		}
	}
	public void excluiGenero() {
		boolean stopGenero=false;
		String nome, opcao = "Gênero modificado" ;
		int op_s;
		try {
			do {
				System.out.println("Qual gênero você deseja excluir?");
				System.out.println(this.cinema.listarGeneros());
				System.out.println("Digite o nome do gênero:");
				nome = cmd.nextLine();
				System.out.println("Você tem certeza que quer excluir esse gênero? 1-Sim/0-Não");
				op_s = cmd.nextInt();
				cmd.nextLine();
				if(op_s == 1 ) {
					this.cinema.deleteGenero(nome);
				}
				else {
					opcao = "Gênero não excluído";
				}
				saveCinema(cinema);
				if (!opcaoRepeat(opcao)) { stopGenero = true; }

			} while (stopGenero == false);
		} catch (GeneroNaoEncontradaException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void addAtores() {
		int opcaoConjuge;
		boolean stopAtor = false;
		String nome, pais, conjuge;
		Pessoa pconjuge = new Pessoa();
		try {
			do {
				conjuge = "";
				pconjuge = null;
				System.out.println("Add Atores:");
				System.out.println("Digite o nome do Ator: ");
				nome = cmd.nextLine();
				System.out.println("Digite o país de origem do Ator: ");
				pais = cmd.nextLine();
				System.out.println("Ator é casado? 0-Não / 1-Sim");
				opcaoConjuge = cmd.nextInt();
				cmd.nextLine();
				if(opcaoConjuge != 0) {
					System.out.println("Lista de Pessoas: ");
					try {
						System.out.println(this.cinema.listarTodasPessoas());
						System.out.println("Digite o nome do conjuge: ");
						conjuge = cmd.nextLine();
						pconjuge = this.cinema.getPessoa(conjuge);
					} catch (PessoaNaoEncontradaException e) {
						System.out.println(e.getMessage());
					}
				}
				this.cinema.setPessoa(nome, pais, "ator", pconjuge);
				saveCinema(cinema);

				if (!opcaoRepeat("Ator adicionado.")) { stopAtor = true; }
			} while(stopAtor == false);

		} catch (InputMismatchException e) {
			System.out.println("Valor inválido, saindo sem salvar...");
			cmd.nextLine();
		}
	}
	public String listarAtores() {
		System.out.println("Lista de Atores:");
		try {
			return this.cinema.listarPessoa("ator");
		} catch (PessoaNaoEncontradaException e) {
			return e.getMessage();
		}
	}
	public void modificaAtores() {
		boolean stopAtor=false, stopAlt = false;
		String nome, altNome, altPais, altConjuge;
		int op_alt;
		try {
			do {
				System.out.println("Qual ator você deseja modificar?");
				System.out.println(this.cinema.listarPessoa("ator"));
				System.out.println("Digite o nome do ator:");
				nome = cmd.nextLine();
				System.out.println(this.cinema.getAtor(nome).listarDetalhes());
				do {
					System.out.println("O que você deseja alterar?");
					System.out.println("1-Nome\n2-País\n3-Conjugê\n4-Sair");
					op_alt = cmd.nextInt();
					cmd.nextLine();
					switch (op_alt) {
					case 1:
						System.out.println("Digite o novo nome do ator:");
						altNome = cmd.nextLine();
						this.cinema.altPessoa("ator", nome, altNome, "nome");
						nome = altNome;
						break;
					case 2:
						System.out.println("Digite o novo país do ator:");
						altPais = cmd.nextLine();
						this.cinema.altPessoa("ator", nome, altPais, "pais");
						break;
					case 3:
						try {
							System.out.println(this.cinema.listarTodasPessoas());
							System.out.println("Digite o nome do novo conjugê do ator:");
							altConjuge = cmd.nextLine();
							this.cinema.altPessoa("ator", nome, altConjuge, "conjuge");
						}
						catch(PessoaNaoEncontradaException e) {
							System.out.println("Erro ao alterar conjugê.");
						}
						break;
					case 4:
						break;
					}
					
					if (!opcaoRepeat("Ator " + nome + " modificado.")) { stopAlt = true; }
				}while(stopAlt == false);
				saveCinema(cinema);
				if (!opcaoRepeat("Ator modificado.")) { stopAtor = true; }

			} while (stopAtor == false);
		} catch (PessoaNaoEncontradaException e) {
			System.out.println(e.getMessage());
		}
	}
	public void excluiAtores() {
		boolean stopPessoa=false;
		String nome, opcao = "Ator modificado" ;
		int op_s;
		try {
			do {
				System.out.println("Qual ator você deseja excluir?");
				System.out.println(this.cinema.listarPessoa("ator"));
				System.out.println("Digite o nome do ator:");
				nome = cmd.nextLine();
				System.out.println(this.cinema.getAtor(nome).listarDetalhes());
				System.out.println("Você tem certeza que quer excluir esse ator? 1-Sim/0-Não");
				op_s = cmd.nextInt();
				cmd.nextLine();
				if(op_s == 1 ) {
					this.cinema.deletePessoa("ator", nome);
				}
				else {
					opcao = "Ator não excluído";
				}
				saveCinema(cinema);
				if (!opcaoRepeat(opcao)) { stopPessoa = true; }

			} while (stopPessoa == false);
		} catch (PessoaNaoEncontradaException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void addDiretores() {
		int opcaoConjuge;
		boolean stopDiretor = false;
		String nome, pais, conjuge;
		Pessoa pconjuge = new Pessoa();
		try {
			do {
				conjuge = "";
				pconjuge = null;
				System.out.println("Add Diretores:");
				System.out.println("Digite o nome do Diretor: ");
				nome = cmd.nextLine();
				System.out.println("Digite o país de origem do Diretor: ");
				pais = cmd.nextLine();
				System.out.println("Diretor é casado? 0-Não / 1-Sim");
				opcaoConjuge = cmd.nextInt();
				cmd.nextLine();
				if(opcaoConjuge != 0) {
					System.out.println("Lista de Pessoas: ");
					try {
						System.out.println(this.cinema.listarTodasPessoas());
						System.out.println("Digite o nome do conjuge: ");
						conjuge = cmd.nextLine();
						pconjuge = this.cinema.getPessoa(conjuge);
					} catch (PessoaNaoEncontradaException e) {
						System.out.println(e.getMessage());
					}
				}
				this.cinema.setPessoa(nome, pais, "diretor", pconjuge);
				
				saveCinema(cinema);

				if (!opcaoRepeat("Diretor salvo.")) { stopDiretor = true; }
				
			} while(stopDiretor == false);
		} catch (InputMismatchException e) {
			System.out.println("Valor inválido, saindo sem salvar...");
			cmd.nextLine();
		}
	}
	public String listarDiretores() {
		System.out.println("Lista de Diretores:");
		try {
			return this.cinema.listarPessoa("diretor");
		} catch (PessoaNaoEncontradaException e) {
			return e.getMessage();
		}
	}
	public void modificaDiretores() {
		boolean stopDiretor=false, stopAlt = false;
		String nome, altNome, altPais, altConjuge;
		int op_alt;
		try {
			do {
				System.out.println("Qual diretor você deseja modificar?");
				System.out.println(this.cinema.listarPessoa("diretor"));
				System.out.println("Digite o nome do diretor:");
				nome = cmd.nextLine();
				System.out.println(this.cinema.getAtor(nome).listarDetalhes());
				do {
					System.out.println("O que você deseja alterar?");
					System.out.println("1-Nome\n2-País\n3-Conjugê\n4-Sair");
					op_alt = cmd.nextInt();
					cmd.nextLine();
					switch (op_alt) {
					case 1:
						System.out.println("Digite o novo nome do diretor:");
						altNome = cmd.nextLine();
						this.cinema.altPessoa("ator", nome, altNome, "nome");
						nome = altNome;
						break;
					case 2:
						System.out.println("Digite o novo país do diretor:");
						altPais = cmd.nextLine();
						this.cinema.altPessoa("ator", nome, altPais, "pais");
						break;
					case 3:
						try {
							System.out.println(this.cinema.listarTodasPessoas());
							System.out.println("Digite o nome do novo conjugê do diretor:");
							altConjuge = cmd.nextLine();
							this.cinema.altPessoa("ator", nome, altConjuge, "conjuge");
						}
						catch(PessoaNaoEncontradaException e) {
							System.out.println("Erro ao alterar conjugê.");
						}
						break;
					case 4:
						break;
					}
					
					if (!opcaoRepeat("Diretor " + nome + " modificado.")) { stopAlt = true; }
				}while(stopAlt == false);
				saveCinema(cinema);
				if (!opcaoRepeat("Diretor modificado.")) { stopDiretor = true; }

			} while (stopDiretor == false);
		} catch (PessoaNaoEncontradaException e) {
			System.out.println(e.getMessage());
		}
	}
	public void excluiDiretores() {
		boolean stopPessoa=false;
		String nome, opcao = "Diretor modificado" ;
		int op_s;
		try {
			do {
				System.out.println("Qual diretor você deseja excluir?");
				System.out.println(this.cinema.listarPessoa("diretor"));
				System.out.println("Digite o nome do diretor:");
				nome = cmd.nextLine();
				System.out.println(this.cinema.getDiretor(nome).listarDetalhes());
				System.out.println("Você tem certeza que quer excluir esse diretor? 1-Sim/0-Não");
				op_s = cmd.nextInt();
				cmd.nextLine();
				if(op_s == 1 ) {
					this.cinema.deletePessoa("diretor", nome);
				}
				else {
					opcao = "Diretor não excluído";
				}
				saveCinema(cinema);
				if (!opcaoRepeat(opcao)) { stopPessoa = true; }

			} while (stopPessoa == false);
		} catch (PessoaNaoEncontradaException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void addSalas() {
		int num;
		boolean stopSala = false;
		try {
			do {
				System.out.println("Add Salas:");
				System.out.println("Digite o número da sala: ");
				num = cmd.nextInt();
				if(this.cinema.setSala(num)) {
				
					saveCinema(cinema);

					if (!opcaoRepeat("Sala salva.")) { stopSala = true; }
				}
				else {
					if (!opcaoRepeat("Número de sala já existe.")) { stopSala = true; }
				}
			} while(stopSala == false);
			
		} catch (InputMismatchException e) {
			System.out.println("Valor inválido, saindo sem salvar...");
			cmd.nextLine();
		}
	}
	public String listarSalas() {
		System.out.println("Lista de Salas:");
		try {
			return this.cinema.listarSalas();
		} catch (SalaNaoEncontradaException e) {
			return e.getMessage();
		}
	}
	public void modificaSalas() {
		boolean stopSala=false;
		int sala, altNSala;
		try {
			do {
				System.out.println("Qual sala você deseja modificar?");
				System.out.println(this.cinema.listarSalas());
				System.out.println("Digite o numero da sala:");
				sala = cmd.nextInt();
				System.out.println("Digite o novo numero da sala:");
				altNSala = cmd.nextInt();
				this.cinema.altSala(sala, altNSala);
				saveCinema(cinema);
				if (!opcaoRepeat("Gênero modificado.")) { stopSala = true; }

			} while (stopSala == false);
		} catch (SalaNaoEncontradaException e) {
			System.out.println(e.getMessage());
		}
	}
	public void excluiSalas() {
		boolean stopSala=false;
		String opcao = "Sala excluída.";
		int op_s,sala;
		try {
			do {
				System.out.println("Qual sala você deseja excluir?");
				System.out.println(this.cinema.listarSalas());
				System.out.println("Digite o numero da sala:");
				sala = cmd.nextInt();
				System.out.println("Você tem certeza que quer excluir esse gênero? 1-Sim/0-Não");
				op_s = cmd.nextInt();
				cmd.nextLine();
				if(op_s == 1 ) {
					this.cinema.deleteSala(sala);
				}
				else {
					opcao = "Gênero não excluído";
				}
				saveCinema(cinema);
				if (!opcaoRepeat(opcao)) { stopSala = true; }

			} while (stopSala == false);
		} catch (SalaNaoEncontradaException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void addHorarios() {
		int num;
		boolean stopHorario = false;
		String hora;
		try {
			do {
				System.out.println("Add Horarios:");
				System.out.println("Lista de Salas:");
				try {
					System.out.println(this.cinema.listarSalas());
					System.out.println("Digite o número de uma das salas acima: ");
					num = cmd.nextInt();
					cmd.nextLine();
					Date data = getDateValidated("data da sessão");
					hora = getHoraValidated("horário da sessão");
					Sala sala =  new Sala();
					sala = this.cinema.getSala(num);
					this.cinema.setHorario(data, sala , hora);
				} catch (DataErradaException e) {
					System.out.println(e.getMessage());
				}
				catch (SalaNaoEncontradaException e) {
					System.out.println(e.getMessage());
				}
				
				saveCinema(cinema);

				if (!opcaoRepeat("Horário salvo.")) { stopHorario = true; }
			} while(stopHorario == false);
		} catch (InputMismatchException e) {
			System.out.println("Valor inválido, saindo sem salvar...");
			cmd.nextLine();
		}
	}
	public String listarHorarios() {
		System.out.println("Lista de Horários:");
		try {
			return this.cinema.listarHorarios();
		} catch (HorarioNaoEncontradaException e) {
			return e.getMessage();
		}
	}
	public void modificaHorarios() {
		boolean stopHor=false;
		int op_mod;
		try {
			do {
				System.out.println("Qual horário você deseja modificar?");
				System.out.println(this.cinema.listarHorarios());
				int codigo = getIntValidated("código do horário desejado");
				Horario hor_obj = this.cinema.getHorario(codigo);
				System.out.println(hor_obj.listarDetalhes());
				System.out.println("O que você deseja modificar: ");
				System.out.println("1-Data\n2-Sala\n3-Hora\n4-Cancelar");
				op_mod = cmd.nextInt();
				cmd.nextLine();
				switch (op_mod) {
				case 1:
					Date data_nova = getDateValidated("Nova data");
					hor_obj.setData(data_nova);
					break;
				case 2:
					System.out.println(this.cinema.listarSalas());
					System.out.println("Novo N° Sala: ");
					int sala_nova = cmd.nextInt();	
					cmd.nextLine();
					hor_obj.setSala(this.cinema.getSala(sala_nova));  
					break;
				case 3:
					String novo_op_horario = getHoraValidated("novo horário");
					hor_obj.setHorario(novo_op_horario);  
					break;
				case 4:
					break;
				}
				saveCinema(cinema);
				if (!opcaoRepeat("Horário modificado.")) { stopHor = true; }

			} while (stopHor == false);
		} 
		catch (HorarioNaoEncontradaException e) {
			System.out.println(e.getMessage());
		}
		catch (SalaNaoEncontradaException e) {
			System.out.println(e.getMessage());
		}
	}
	public void excluiHorarios() {
		boolean stopHor=false;
		String opcao = "Horário excluída.";
		int op_s;
		try {
			do {
				System.out.println("Qual horário você deseja excluir?");
				System.out.println(this.cinema.listarHorarios());
				int codigo = getIntValidated("código do horário desejado");
				Horario hor_obj = this.cinema.getHorario(codigo);
				System.out.println(hor_obj.listarDetalhes());
				System.out.println("Você tem certeza que quer excluir esse gênero? 1-Sim/0-Não");
				op_s = cmd.nextInt();
				cmd.nextLine();
				if(op_s == 1 ) {
					this.cinema.deleteHorario(hor_obj);
				}
				else {
					opcao = "Horário não excluído";
				}
				saveCinema(cinema);
				if (!opcaoRepeat(opcao)) { stopHor = true; }

			} while (stopHor == false);
		} catch (HorarioNaoEncontradaException e) {
			System.out.println(e.getMessage());
		}
	}
	
	 
}
