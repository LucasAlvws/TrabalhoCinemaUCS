package br.ucs.poo.data;
import java.io.*;

import br.ucs.poo.error.ArquivoNaoEncontradoException;
import br.ucs.poo.error.CarregarArquivoException;
import br.ucs.poo.error.SalvarArquivoException;
import br.ucs.poo.infra.Cinema;
public class DataManager {
	
	
	public static Cinema carregarDados(String path) throws CarregarArquivoException {
		Cinema cine = null;
		try {
			FileInputStream fi = new FileInputStream(path);
			ObjectInputStream oi = new ObjectInputStream(fi);
			Object o = oi.readObject();
			cine = (Cinema) o;
			oi.close();
			fi.close();
			
		} 
		catch (FileNotFoundException e) {
			throw new CarregarArquivoException();
		}
		catch (IOException e) {
			throw new CarregarArquivoException();
		}
		catch (ClassNotFoundException e) {
			throw new CarregarArquivoException();
		}
		return cine;
	}
	
	public static boolean salvarDados(Cinema cinema, String path) throws SalvarArquivoException{
		try {
			FileOutputStream fo = new FileOutputStream(path);
			ObjectOutputStream ou = new ObjectOutputStream(fo);
			ou.writeObject(cinema);
			ou.close();
			fo.close();
			
		} catch (IOException e) {
			throw new SalvarArquivoException();
			}
		return true;
	}
	
	
}
