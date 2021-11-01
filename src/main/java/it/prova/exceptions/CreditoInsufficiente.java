package it.prova.exceptions;

public class CreditoInsufficiente extends RuntimeException{
private static final long serialVersionUID = 1L;
	
	public CreditoInsufficiente(String message) {
		super(message);
	}
}
