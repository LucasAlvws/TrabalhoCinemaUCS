package br.ucs.poo.error;

public class SalaNaoEncontradaException extends Exception{
	private static final String MESSAGE = "Sala não encontrada, verifique o numero dela e tente novamente.";
	public SalaNaoEncontradaException() {
		super(MESSAGE);
		// TODO Auto-generated constructor stub
	}

	public SalaNaoEncontradaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(MESSAGE + " " + message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public SalaNaoEncontradaException(String message, Throwable cause) {
		super(MESSAGE + " " + message, cause);
		// TODO Auto-generated constructor stub
	}

	public SalaNaoEncontradaException(String message) {
		super(MESSAGE + " " + message);
		// TODO Auto-generated constructor stub
	}

	public SalaNaoEncontradaException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}
