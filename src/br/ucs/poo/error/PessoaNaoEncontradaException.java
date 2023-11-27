package br.ucs.poo.error;

public class PessoaNaoEncontradaException extends Exception{
	private static final String MESSAGE = "Pessoa(s) não encontrada.";
	public PessoaNaoEncontradaException() {
		super(MESSAGE);
		// TODO Auto-generated constructor stub
	}

	public PessoaNaoEncontradaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(MESSAGE + " " + message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public PessoaNaoEncontradaException(String message, Throwable cause) {
		super(MESSAGE + " " + message, cause);
		// TODO Auto-generated constructor stub
	}

	public PessoaNaoEncontradaException(String message) {
		super(MESSAGE + " " + message);
		// TODO Auto-generated constructor stub
	}

	public PessoaNaoEncontradaException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}
