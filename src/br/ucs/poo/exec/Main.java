package br.ucs.poo.exec;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.util.Date;
import java.text.SimpleDateFormat;

import br.ucs.poo.data.DataManager;
import static java.lang.Integer.*;
import br.ucs.poo.error.CarregarArquivoException;
import br.ucs.poo.error.DataErradaException;
import br.ucs.poo.error.PessoaNaoEncontradaException;
import br.ucs.poo.error.SalaNaoEncontradaException;
import br.ucs.poo.error.SalvarArquivoException;
import br.ucs.poo.infra.Ator;
import br.ucs.poo.infra.Cinema;
import br.ucs.poo.infra.Diretor;
import br.ucs.poo.infra.Genero;
import br.ucs.poo.infra.Horario;
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
				e.printStackTrace();
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
				crud(cmd, "Filmes");
				break;
			case 2:
				crud(cmd, "Gêneros");
				break;
			case 3:
				crud(cmd, "Atores");
				break;
			case 4:
				crud(cmd, "Diretores");
				break;
			case 5:
				crud(cmd, "Salas");
				break;
			case 6:
				crud(cmd, "Horarios");
				break;
				}
		}
	}
	
	public void crud(Scanner cmd, String classe) {
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
					listarSalas();
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


	public boolean opcaoRepeat(String msg)
	{	
		boolean opcaoTrue = false;
		int opcao = 1;
		System.out.println(msg + " Você deseja adicionar outro(a)? 0-Não / 1-Sim");

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
			e.printStackTrace();
		}
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
				typeError("Duração inválida!");
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
		String strAtores = listarAtores();
		if (strAtores.contains(this.cinema.erroNenhumaPessoa)) {
			System.out.println(strAtores);
		}
		else
		{
			atores_select = new ArrayList<Ator>();
			do {
				System.out.println("Adicionar Ator: ");
				System.out.println(strAtores);
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

		// GET GENERO ===================================================================
		Genero gen = null;
		String strGeneros = listarGenero();
		if (strGeneros.contains(this.cinema.erroNenhumGenero)) {
			System.out.println(strGeneros);
		}
		else
		{
			do {
				System.out.println("Adicionar gênero: ");
				System.out.println(strGeneros);
				System.out.println("Digite o nome do gênero: ");
				String genero = cmd.nextLine();
				gen = this.cinema.getGenero(genero);
		
				if (gen.getNome() != gen.semNomeStr)
				{			
					stopGenero = true;
				}
				else 
				{
					typeError("Não existe um gênero com esse nome, por favor escolha um nome válido.");
				}
			} while (stopGenero == false);
		}

		// GET DIRETORES ===================================================================

		List<Diretor> diretores_select = null;
		String strDiretores = listarDiretores();
		if (strDiretores.contains(this.cinema.erroNenhumaPessoa)) {
			System.out.println(strDiretores);
		}
		else
		{	
			diretores_select = new ArrayList<Diretor>();
			do {
				System.out.println("Adicionar Diretor: ");
				System.out.println(strDiretores);
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

		// GET HORÁRIOS ===================================================================
		List<Horario> horarios_select = null;
		String strHorarios = listarHorarios();
		if (strHorarios.contains(this.cinema.erroNenhumHorario)) {
			System.out.println(strHorarios);
		}
		else
		{
			horarios_select = new ArrayList<Horario>();
			do {
				System.out.println("Adicionar Horário: ");
				System.out.println(strHorarios);
				Date data = getDateValidated("horário");

				Horario horario = this.cinema.getHorario(data);
				if (horario.getData() != null)
				{
					horarios_select.add(horario);
					if (!opcaoRepeat("Horário adicionado.")) { stopHorario = true; }
				}
				else 
				{
					typeError("Não existe um horário com essa data, por favor escolha uma data válida.");
				}
			} while (stopHorario == false);
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
		
	}
	public void excluiFilme() {
		
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
		
		return this.cinema.listarGeneros();
	}
	public void modificaGenero() {
		
	}
	public void excluiGenero() {
		
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
					if(this.cinema.listarTodasPessoas().contains(this.cinema.erroNenhumaPessoa)) {
						System.out.println(this.cinema.listarTodasPessoas());
					}
					else {
						System.out.println(this.cinema.listarTodasPessoas());
						System.out.println("Digite o nome do conjuge: ");
						conjuge = cmd.nextLine();
						try {
							pconjuge = this.cinema.getPessoa(conjuge);
						} catch (PessoaNaoEncontradaException e) {
							e.printStackTrace();
						}
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
		String str = this.cinema.listarPessoa("ator");
		return str;
	}
	public void modificaAtores() {
		
	}
	public void excluiAtores() {
		
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
				System.out.println("Ator é casado? 0-Não / 1-Sim");
				opcaoConjuge = cmd.nextInt();
				cmd.nextLine();
				if(opcaoConjuge != 0) {
					System.out.println("Lista de Pessoas: ");
					if(this.cinema.listarTodasPessoas().contains(this.cinema.erroNenhumaPessoa)) {
						System.out.println(this.cinema.listarTodasPessoas());
					}
					else {
						System.out.println(this.cinema.listarTodasPessoas());
						System.out.println("Digite o nome do conjuge: ");
						conjuge = cmd.nextLine();
						try {
							pconjuge = this.cinema.getPessoa(conjuge);
						} catch (PessoaNaoEncontradaException e) {
							e.printStackTrace();
						}
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

		return this.cinema.listarPessoa("diretor");
	}
	public void modificaDiretores() {
		
	}
	public void excluiDiretores() {
		
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
	public void listarSalas() {
		System.out.println("Lista de Salas:");
		System.out.println(this.cinema.listarSalas());
	}
	public void modificaSalas() {
		
	}
	public void excluiSalas() {
		
	}
	
	public void addHorarios() {
		int num;
		boolean stopHorario = false;
		String hora, data;
		try {
			do {
				System.out.println("Add Horarios:");
				System.out.println("Lista de Salas:");
				System.out.println(this.cinema.listarSalas());
				System.out.println("Digite o número de uma das salas acima: ");
				num = cmd.nextInt();
				cmd.nextLine();
				System.out.println("Informe a data da sessão: ");
				data = cmd.nextLine();
				System.out.println("Informe o horário da sessão: ");
				hora = cmd.nextLine();
				Sala sala =  new Sala();
				try {
					sala = this.cinema.getSala(num);
				} catch (SalaNaoEncontradaException e) {
					e.printStackTrace();
				}
				try {
					this.cinema.setHorario(data, sala , hora);
				} catch (DataErradaException e) {
					e.printStackTrace();
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

		return this.cinema.listarHorarios();
	}
	public void modificaHorarios() {
		
	}
	public void excluiHorarios() {
		
	}
	
	
}
