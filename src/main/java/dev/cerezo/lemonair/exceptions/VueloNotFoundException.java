package dev.cerezo.lemonair.exceptions;

public class VueloNotFoundException extends RuntimeException {


	private static final long serialVersionUID = 8021262161765199616L;

	public VueloNotFoundException(final String message) {
		super(message);
	}

}
