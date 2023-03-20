package dev.cerezo.lemonair.exceptions;

public class AvionesNotFoundException extends RuntimeException {


	private static final long serialVersionUID = 8021262161765199616L;

	public AvionesNotFoundException(final String message) {
		super(message);
	}

}
