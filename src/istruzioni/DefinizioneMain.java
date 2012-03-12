package istruzioni;

import compilatore.ScrittoreTarget;

public class DefinizioneMain implements S {

	private N codiceProgramma;
	
	
	/**
	 * 
	 * @param codiceProgramma
	 */
	public DefinizioneMain(N codiceProgramma) {
		this.codiceProgramma = codiceProgramma;
	}



	@Override
	public void scriviCodice(ScrittoreTarget sc) {
		sc.scriviMain(codiceProgramma);
	}

}