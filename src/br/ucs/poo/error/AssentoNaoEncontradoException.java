package br.ucs.poo.error;

public class AssentoNaoEncontradoException extends Exception{
	private static final String MESSAGE = "Assento(s) não encontrado.";
	public AssentoNaoEncontradoException() {
		super(MESSAGE);
		// TODO Auto-generated constructor stub
	}

	public AssentoNaoEncontradoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(MESSAGE + " " + message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public AssentoNaoEncontradoException(String message, Throwable cause) {
		super(MESSAGE + " " + message, cause);
		// TODO Auto-generated constructor stub
	}

	public AssentoNaoEncontradoException(String message) {
		super(MESSAGE + " " + message);
		// TODO Auto-generated constructor stub
	}

	public AssentoNaoEncontradoException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}
