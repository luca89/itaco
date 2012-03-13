package istruzioni.funzioni;

import compilatore.ScrittoreTarget;
import compilatore.SemanticException;

import istruzioni.I;
import istruzioni.espressioni.F;
import istruzioni.espressioni.W;

public class ChiamaFunzioneSenzaRitorno implements F,I {

	private String id;
	private W argomenti;

	public ChiamaFunzioneSenzaRitorno(String id, W w) {
		this.id = id;
		this.argomenti = w;
	}

	@Override
	public void scriviCodice(ScrittoreTarget sc) throws SemanticException {
		sc.eseguiFunzioneSenzaRitorno(id, argomenti);
	}

}
