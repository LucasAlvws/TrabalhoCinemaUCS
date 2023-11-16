package br.ucs.poo.exec;

import java.util.Scanner;
import java.io.File;
import br.ucs.poo.data.DataManager;
import br.ucs.poo.error.CarregarArquivoException;
import br.ucs.poo.error.SalvarArquivoException;
import br.ucs.poo.infra.Cinema;

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
			opcao = cmd.nextInt();
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
			opcaoCrud = cmd.nextInt();
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
					addGenero(cmd);
					break;
				case 2:
					listarGenero();
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
					listarAtores();
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
					listarDiretores();
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
					addSalas(cmd);
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
					listarHorarios();
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
	
	public void addFilme() {
		
	}
	public void listarFilmes() {
		System.out.println(this.cinema.listarFilmes()); 
	}
	public void modificaFilme() {
		
	}
	public void excluiFilme() {
		
	}

	public void addGenero(Scanner cmd) {
		int opcao;
		String nome;
		do {
		System.out.println("Add Gêneros:");
		System.out.println("Digite o nome do gênero: ");
		nome = cmd.nextLine();
		this.cinema.setGeneros(nome);
		try {
			DataManager.salvarDados(cinema, "src/br/ucs/poo/data/cinema.bin");
		} catch (SalvarArquivoException e) {
			e.printStackTrace();
		}
		System.out.println("Gênero salvo. Você deseja adicionar outro? 0-Não / 1-Sim");
		opcao = cmd.nextInt();
		cmd.nextLine();
		} while(opcao != 0);
		
	}
	public void listarGenero() {
		System.out.println("Lista de Gêneros:");
		System.out.println(this.cinema.listarGeneros());
	}
	public void modificaGenero() {
		
	}
	public void excluiGenero() {
		
	}
	
	public void addAtores() {
		int opcao;
		String nome, pais;
		do {
		System.out.println("Add Atores:");
		System.out.println("Digite o nome do Ator: ");
		nome = cmd.nextLine();
		System.out.println("Digite o país de origem do Ator: ");
		pais = cmd.nextLine();
		this.cinema.setPessoa(nome, pais, "ator");
		try {
			DataManager.salvarDados(cinema, "src/br/ucs/poo/data/cinema.bin");
		} catch (SalvarArquivoException e) {
			e.printStackTrace();
		}
		System.out.println("Ator salvo. Você deseja adicionar outro? 0-Não / 1-Sim");
		opcao = cmd.nextInt();
		cmd.nextLine();
		} while(opcao != 0);
	}
	public void listarAtores() {
		System.out.println("Lista de Atores:");
		System.out.println(this.cinema.listarPessoa("ator"));
	}
	public void modificaAtores() {
		
	}
	public void excluiAtores() {
		
	}
	
	public void addDiretores() {
		int opcao;
		String nome, pais;
		do {
		System.out.println("Add Diretores:");
		System.out.println("Digite o nome do Diretor: ");
		nome = cmd.nextLine();
		System.out.println("Digite o país de origem do Diretor: ");
		pais = cmd.nextLine();
		this.cinema.setPessoa(nome, pais, "diretor");
		try {
			DataManager.salvarDados(cinema, "src/br/ucs/poo/data/cinema.bin");
		} catch (SalvarArquivoException e) {
			e.printStackTrace();
		}
		System.out.println("Diretor salvo. Você deseja adicionar outro? 0-Não / 1-Sim");
		opcao = cmd.nextInt();
		cmd.nextLine();
		} while(opcao != 0);
	}
	public void listarDiretores() {
		System.out.println("Lista de Diretores:");
		System.out.println(this.cinema.listarPessoa("diretor"));
	}
	public void modificaDiretores() {
		
	}
	public void excluiDiretores() {
		
	}
	
	public void addSalas(Scanner cmd) {
		int opcao, num;
		do {
		System.out.println("Add Salas:");
		System.out.println("Digite o número da sala: ");
		num = cmd.nextInt();
		if(this.cinema.setSala(num)) {
		try {
			DataManager.salvarDados(cinema, "src/br/ucs/poo/data/cinema.bin");
		} catch (SalvarArquivoException e) {
			e.printStackTrace();
		}
		System.out.println("Sala salva. Você deseja adicionar outro? 0-Não / 1-Sim");
		}
		else {
			System.out.println("Número de sala já existe. Você deseja adicionar outro? 0-Não / 1-Sim");
		}
		opcao = cmd.nextInt();
		cmd.nextLine();
		} while(opcao != 0);
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
		
	}
	public void listarHorarios() {
		
	}
	public void modificaHorarios() {
		
	}
	public void excluiHorarios() {
		
	}
	
	
}
