package br.ucs.poo.error;

public class HorarioNaoEncontradaException extends Exception{
	private static final String MESSAGE = "Horário não encontrado, verifique as infos e tente novamente.";
	public HorarioNaoEncontradaException() {
		super(MESSAGE);
		// TODO Auto-generated constructor stub
	}

	public HorarioNaoEncontradaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(MESSAGE + " " + message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public HorarioNaoEncontradaException(String message, Throwable cause) {
		super(MESSAGE + " " + message, cause);
		// TODO Auto-generated constructor stub
	}

	public HorarioNaoEncontradaException(String message) {
		super(MESSAGE + " " + message);
		// TODO Auto-generated constructor stub
	}

	public HorarioNaoEncontradaException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}
