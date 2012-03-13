package istruzioni.espressioni;

import compilatore.ScrittoreTarget;
import compilatore.SemanticException;

/**
 * 
 * @author Alessandro, Luca, Saro
 *
 */
public class ElementoVettore implements F {
	private String nomeVettore;
	private E indice;
		
	public ElementoVettore(String nomeVettore, E indice) {
		this.indice = indice;
		this.nomeVettore = nomeVettore;
	}

	@Override
	public void scriviCodice(ScrittoreTarget sc) throws SemanticException {
		sc.caricaElementoVettore(nomeVettore, indice);
	}
}
