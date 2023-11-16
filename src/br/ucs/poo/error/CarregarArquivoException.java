package br.ucs.poo.error;

public class CarregarArquivoException extends Exception{
	private static final String MESSAGE = "Probelmas ao carregar os dados.";
	public CarregarArquivoException() {
		super(MESSAGE);
		// TODO Auto-generated constructor stub
	}

	public CarregarArquivoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(MESSAGE + " " + message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public CarregarArquivoException(String message, Throwable cause) {
		super(MESSAGE + " " + message, cause);
		// TODO Auto-generated constructor stub
	}

	public CarregarArquivoException(String message) {
		super(MESSAGE + " " + message);
		// TODO Auto-generated constructor stub
	}

	public CarregarArquivoException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}
