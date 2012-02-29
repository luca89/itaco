package istruzioni.espressioni;

import main.ScrittoreTarget;

public class Sottrazione implements E {
	private E parteSinistra;
	private T parteDestra;
	
	public Sottrazione(E parteSinistra, T parteDestra) {
		this.parteSinistra = parteSinistra;
		this.parteDestra = parteDestra;
	}
	@Override
	public void scriviCodice(ScrittoreTarget sc) {
		parteSinistra.scriviCodice(sc);
		parteDestra.scriviCodice(sc);
		sc.scriviSottrazione();
	}
}
