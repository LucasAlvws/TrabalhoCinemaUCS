package br.ucs.poo.error;

public class FilmeNaoEncontradoException extends Exception{
	private static final String MESSAGE = "Filme não encontrado, verifique o nome dele e tente novamente.";
	public FilmeNaoEncontradoException() {
		super(MESSAGE);
		// TODO Auto-generated constructor stub
	}

	public FilmeNaoEncontradoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(MESSAGE + " " + message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public FilmeNaoEncontradoException(String message, Throwable cause) {
		super(MESSAGE + " " + message, cause);
		// TODO Auto-generated constructor stub
	}

	public FilmeNaoEncontradoException(String message) {
		super(MESSAGE + " " + message);
		// TODO Auto-generated constructor stub
	}

	public FilmeNaoEncontradoException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}
