/**
 * 
 */
package compilatore;

import java.io.OutputStream;
import java.io.PrintStream;

/**
 * @author ale
 *
 */
public class CTarget extends ScrittoreTarget {

	private PrintStream ps;
	
	public CTarget(OutputStream o){
		this.ps=new PrintStream(o);
	}
	
	/* (non-Javadoc)
	 * @see compilatore.ScrittoreTarget#registraVariabile(java.lang.String)
	 */
	@Override
	public boolean registraVariabile(String nome) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see compilatore.ScrittoreTarget#caricaVariabile(java.lang.String)
	 */
	@Override
	public void caricaVariabile(String nome) {
		// TODO Auto-generated method stub
		ps.println(nome);
	}

	/* (non-Javadoc)
	 * @see compilatore.ScrittoreTarget#storeInVariabile(java.lang.String, compilatore.Espressione)
	 */
	@Override
	public void storeInVariabile(String identificatore, Espressione valore) {
		// TODO Auto-generated method stub
		String linea = identificatore+" = ";
		ps.printf(linea);
		valore.scriviCodice(this);
		ps.println(";");
	}

	/* (non-Javadoc)
	 * @see compilatore.ScrittoreTarget#costante(int)
	 */
	@Override
	public void costante(int costante) {
		// TODO Auto-generated method stub
		ps.print(costante);
	}

	/* (non-Javadoc)
	 * @see compilatore.ScrittoreTarget#costante(java.lang.String)
	 */
	@Override
	public void costante(String stringa) {
		// TODO Auto-generated method stub
		ps.print("\""+stringa+"\"");
	}

	/* (non-Javadoc)
	 * @see compilatore.ScrittoreTarget#somma(compilatore.Espressione, compilatore.Espressione)
	 */
	@Override
	public void somma(Espressione addendo1, Espressione addendo2) {
		// TODO Auto-generated method stub
		addendo1.scriviCodice(this);
		ps.print(" + ");
		addendo2.scriviCodice(this);
	}

	/* (non-Javadoc)
	 * @see compilatore.ScrittoreTarget#sottrazione(compilatore.Espressione, compilatore.Espressione)
	 */
	@Override
	public void sottrazione(Espressione minuendo, Espressione sottraendo) {
		// TODO Auto-generated method stub
		minuendo.scriviCodice(this);
		ps.print(" - ");
		sottraendo.scriviCodice(this);
	}

	/* (non-Javadoc)
	 * @see compilatore.ScrittoreTarget#prodotto(compilatore.Espressione, compilatore.Espressione)
	 */
	@Override
	public void prodotto(Espressione fattore1, Espressione fattore2) {
		// TODO Auto-generated method stub
		fattore1.scriviCodice(this);
		ps.print(" * ");
		fattore2.scriviCodice(this);
	}

	/* (non-Javadoc)
	 * @see compilatore.ScrittoreTarget#divisione(compilatore.Espressione, compilatore.Espressione)
	 */
	@Override
	public void divisione(Espressione dividendo, Espressione divisore) {
		// TODO Auto-generated method stub
		dividendo.scriviCodice(this);
		ps.print(" / ");
		divisore.scriviCodice(this);
	}

	/* (non-Javadoc)
	 * @see compilatore.ScrittoreTarget#maggiore(compilatore.Espressione, compilatore.Espressione)
	 */
	@Override
	public void maggiore(Espressione parteSinistra, Espressione parteDestra) {
		// TODO Auto-generated method stub
		parteSinistra.scriviCodice(this);
		ps.print(" > ");
		parteDestra.scriviCodice(this);
	}

	/* (non-Javadoc)
	 * @see compilatore.ScrittoreTarget#minore(compilatore.Espressione, compilatore.Espressione)
	 */
	@Override
	public void minore(Espressione parteSinistra, Espressione parteDestra) {
		// TODO Auto-generated method stub
		parteSinistra.scriviCodice(this);
		ps.print(" < ");
		parteDestra.scriviCodice(this);
	}

	/* (non-Javadoc)
	 * @see compilatore.ScrittoreTarget#uguaglianza(compilatore.Espressione, compilatore.Espressione)
	 */
	@Override
	public void uguaglianza(Espressione parteSinistra, Espressione parteDestra) {
		// TODO Auto-generated method stub
		parteSinistra.scriviCodice(this);
		ps.print(" == ");
		parteDestra.scriviCodice(this);
	}

	/* (non-Javadoc)
	 * @see compilatore.ScrittoreTarget#espressioneInParentesi(compilatore.Espressione)
	 */
	@Override
	public void espressioneInParentesi(Espressione ex) {
		// TODO Auto-generated method stub
		ps.print("(");
		ex.scriviCodice(this);
		ps.print(")");
	}

	/* (non-Javadoc)
	 * @see compilatore.ScrittoreTarget#stampa(compilatore.Espressione)
	 */
	@Override
	public void stampa(Espressione espressione) {
		// TODO Auto-generated method stub
		ps.print("printf(\"%d\",");
		espressione.scriviCodice(this);
		ps.print(");\n");
	}

	/* (non-Javadoc)
	 * @see compilatore.ScrittoreTarget#stampa(java.lang.String)
	 */
	@Override
	public void stampa(String stringa) {
		// TODO Auto-generated method stub
		ps.print("printf(\""+stringa+"\");\n");
	}

	/* (non-Javadoc)
	 * @see compilatore.ScrittoreTarget#leggi(java.lang.String)
	 */
	@Override
	public void leggi(String identificatore) {
		// TODO Auto-generated method stub
		ps.print("scanf(\"%d\", &"+identificatore+");\n");
	}

	/* (non-Javadoc)
	 * @see compilatore.ScrittoreTarget#leggiElementoVettore(java.lang.String, compilatore.Espressione)
	 */
	@Override
	public void leggiElementoVettore(String identificatore, Espressione indice) {
		// TODO Auto-generated method stub
		ps.print("scanf(\"%d\", &"+identificatore+"+");
		indice.scriviCodice(this);
		ps.print(");\n");
	}

	/* (non-Javadoc)
	 * @see compilatore.ScrittoreTarget#se(compilatore.Espressione, compilatore.Blocco)
	 */
	@Override
	public void se(Espressione ex, Blocco codice) {
		// TODO Auto-generated method stub
		ps.print("if(");
		ex.scriviCodice(this);
		ps.print("){\n");
		codice.scriviCodice(this);
		ps.print("\n}\n");
	}

	/* (non-Javadoc)
	 * @see compilatore.ScrittoreTarget#seAltrimenti(compilatore.Espressione, compilatore.Blocco, compilatore.Blocco)
	 */
	@Override
	public void seAltrimenti(Espressione ex, Blocco codice,
			Blocco codiceAltrimenti) {
		// TODO Auto-generated method stub
		se(ex, codice);
		ps.print("else {\n");
		codiceAltrimenti.scriviCodice(this);
		ps.print("\n}\n");
	}

	/* (non-Javadoc)
	 * @see compilatore.ScrittoreTarget#finche(compilatore.Espressione, compilatore.Blocco)
	 */
	@Override
	public void finche(Espressione ex, Blocco codice) {
		// TODO Auto-generated method stub
		ps.print("while(");
		ex.scriviCodice(this);
		ps.print("){\n");
		codice.scriviCodice(this);
		ps.print("\n}\n");
	}

	/* (non-Javadoc)
	 * @see compilatore.ScrittoreTarget#definisciVettore(java.lang.String, java.lang.Integer)
	 */
	@Override
	public void definisciVettore(String identificatore, Integer dimensione) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see compilatore.ScrittoreTarget#caricaElementoVettore(java.lang.String, compilatore.Espressione)
	 */
	@Override
	public void caricaElementoVettore(String identificatore, Espressione indice) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see compilatore.ScrittoreTarget#storeElementoVettore(java.lang.String, compilatore.Espressione, compilatore.Espressione)
	 */
	@Override
	public void storeElementoVettore(String identificatore, Espressione indice,
			Espressione elemento) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see compilatore.ScrittoreTarget#definisciFunzione(java.lang.String, java.lang.String[], java.lang.String, compilatore.Blocco)
	 */
	@Override
	public void definisciFunzione(String nome, String[] ingressi,
			String uscita, Blocco codice) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see compilatore.ScrittoreTarget#eseguiFunzione(java.lang.String, compilatore.Espressione)
	 */
	@Override
	public void eseguiFunzione(String nome, Espressione parametri) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see compilatore.ScrittoreTarget#eseguiFunzioneSenzaRitorno(java.lang.String, compilatore.Espressione)
	 */
	@Override
	public void eseguiFunzioneSenzaRitorno(String nome, Espressione parametri) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see compilatore.ScrittoreTarget#scriviMain(compilatore.Blocco)
	 */
	@Override
	public void scriviMain(Blocco codice) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see compilatore.ScrittoreTarget#caricaVettore(java.lang.String)
	 */
	@Override
	public void caricaVettore(String nome) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see compilatore.ScrittoreTarget#caricaDimensioneVettore(java.lang.String)
	 */
	@Override
	public void caricaDimensioneVettore(String nome) {
		// TODO Auto-generated method stub

	}

}
