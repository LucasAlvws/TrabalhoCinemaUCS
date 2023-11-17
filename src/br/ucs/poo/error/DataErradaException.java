package br.ucs.poo.error;

public class DataErradaException extends Exception{
	private static final String MESSAGE = "Formato incorreto de data informado.";
	public DataErradaException() {
		super(MESSAGE);
		// TODO Auto-generated constructor stub
	}

	public DataErradaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(MESSAGE + " " + message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public DataErradaException(String message, Throwable cause) {
		super(MESSAGE + " " + message, cause);
		// TODO Auto-generated constructor stub
	}

	public DataErradaException(String message) {
		super(MESSAGE + " " + message);
		// TODO Auto-generated constructor stub
	}

	public DataErradaException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}
