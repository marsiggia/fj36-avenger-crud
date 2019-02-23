package br.com.caelum.avenger.avenger;

public class AvengerNotFoundException extends RuntimeException {
	
	public AvengerNotFoundException(Long id) {
		super("Avenger not found with id: "+id);
	}
	
}
