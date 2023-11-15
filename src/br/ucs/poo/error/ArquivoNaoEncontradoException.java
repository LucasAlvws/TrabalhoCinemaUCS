package br.ucs.poo.error;

public class ArquivoNaoEncontradoException extends Exception{
	private static final String MESSAGE = "Arquivo não encontrado.";
	public ArquivoNaoEncontradoException() {
		super(MESSAGE);
		// TODO Auto-generated constructor stub
	}

	public ArquivoNaoEncontradoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(MESSAGE + " " + message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public ArquivoNaoEncontradoException(String message, Throwable cause) {
		super(MESSAGE + " " + message, cause);
		// TODO Auto-generated constructor stub
	}

	public ArquivoNaoEncontradoException(String message) {
		super(MESSAGE + " " + message);
		// TODO Auto-generated constructor stub
	}

	public ArquivoNaoEncontradoException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}
