package br.ucs.poo.exec;

import java.util.Scanner;

import br.ucs.poo.data.DataManager;
import br.ucs.poo.infra.Cinema;

public class Main {
	private static Scanner cmd;
	private Cinema cinema;
	
	public Main() {
		this.cinema = new Cinema("UCS", "R. Francisco Getúlio Vargas, 1130 - Petrópolis");
		try {
			cinema = DataManager.carregarDados("src/br/ucs/poo/data/cinema.bin");
		} catch (Exception e) {
			DataManager.salvarDados(cinema, "src/br/ucs/poo/data/cinema.bin");
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
					addGenero();
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

	public void addGenero() {
		
	}
	public void listarGenero() {
		
	}
	public void modificaGenero() {
		
	}
	public void excluiGenero() {
		
	}
	
	public void addAtores() {
		
	}
	public void listarAtores() {
		
	}
	public void modificaAtores() {
		
	}
	public void excluiAtores() {
		
	}
	
	public void addDiretores() {
		
	}
	public void listarDiretores() {
		
	}
	public void modificaDiretores() {
		
	}
	public void excluiDiretores() {
		
	}
	
	public void addSalas() {
		
	}
	public void listarSalas() {
		
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
