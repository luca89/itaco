package istruzioni.espressioni;

import main.ScrittoreTarget;

public class EspressioneInParentesi implements F {
	private E espressione;

	public EspressioneInParentesi(E espressione) {
		this.espressione = espressione;
	}

	@Override
	public void scriviCodice(ScrittoreTarget sc) {
		espressione.scriviCodice(sc);
	}
	
}