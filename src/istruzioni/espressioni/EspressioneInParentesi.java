package istruzioni.espressioni;

import compilatore.ScrittoreTarget;
import compilatore.SemanticException;

public class EspressioneInParentesi implements F {
	private E espressione;

	public EspressioneInParentesi(E espressione) {
		this.espressione = espressione;
	}

	@Override
	public void scriviCodice(ScrittoreTarget sc) throws SemanticException {
		sc.espressioneInParentesi(espressione);
	}
	
}
