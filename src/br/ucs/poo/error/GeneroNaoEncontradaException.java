package br.ucs.poo.error;

public class GeneroNaoEncontradaException extends Exception{
	private static final String MESSAGE = "Gênero não encontrado, verifique as infos e tente novamente.";
	public GeneroNaoEncontradaException() {
		super(MESSAGE);
		// TODO Auto-generated constructor stub
	}

	public GeneroNaoEncontradaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(MESSAGE + " " + message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public GeneroNaoEncontradaException(String message, Throwable cause) {
		super(MESSAGE + " " + message, cause);
		// TODO Auto-generated constructor stub
	}

	public GeneroNaoEncontradaException(String message) {
		super(MESSAGE + " " + message);
		// TODO Auto-generated constructor stub
	}

	public GeneroNaoEncontradaException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}
