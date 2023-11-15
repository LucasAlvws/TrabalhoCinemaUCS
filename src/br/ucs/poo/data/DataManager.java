package br.ucs.poo.data;
import java.io.*;

import br.ucs.poo.error.ArquivoNaoEncontradoException;
import br.ucs.poo.infra.Cinema;
public class DataManager {
	
	
	public static Cinema carregarDados(String path) throws ArquivoNaoEncontradoException {
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
			throw new ArquivoNaoEncontradoException();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return cine;
	}
	
	public static boolean salvarDados(Cinema cinema, String path) {
		try {
			FileOutputStream fo = new FileOutputStream(path);
			ObjectOutputStream ou = new ObjectOutputStream(fo);
			ou.writeObject(cinema);
			ou.close();
			fo.close();
			
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
}
