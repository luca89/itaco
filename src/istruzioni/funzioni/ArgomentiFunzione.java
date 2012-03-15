package istruzioni.funzioni;

import compilatore.ScrittoreTarget;
import compilatore.EccezioneSemantica;

import istruzioni.espressioni.U;
import istruzioni.espressioni.W2;

/**
 * 
 * @author Alessandro, Luca, Saro
 * 
 */
public class ArgomentiFunzione implements W2 {

	private U argomentoPrecedente;
	private W2 argomentiSuccessivi;

	public ArgomentiFunzione(U argomentoPrecedente, W2 argomentiSuccessivi) {
		this.argomentoPrecedente = argomentoPrecedente;
		this.argomentiSuccessivi = argomentiSuccessivi;
	}

	@Override
	public void scriviCodice(ScrittoreTarget sc) throws EccezioneSemantica {
		argomentoPrecedente.scriviCodice(sc);
		argomentiSuccessivi.scriviCodice(sc);
	}

}
