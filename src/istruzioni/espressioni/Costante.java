package istruzioni.espressioni;

import compilatore.ScrittoreTarget;

public class Costante implements F {
	private int valore;
	
	public Costante(int valore) {
		this.valore = valore;
	}

	@Override
	public void scriviCodice(ScrittoreTarget sc) {
		sc.costante(valore);
	}
}
