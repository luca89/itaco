package test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Map;
import java.util.Scanner;

import org.junit.Test;

import compilatore.JasminTarget;

public class IntegrationTest {

	private static final String cartellaFileTest = "testFiles" + File.separator;
	
	/**
	 * Questo metodo generico, fa il test di corretta esecuzione di un programma scritto in itaco
	 * @param nomeFileSorgente nome del file sorgente inserito nella cartella testFiles/, senza estensione .ita
	 * @param datiIngresso array di stringhe da inserire come dati in ingresso al programma
	 * @param outputPrevisto array di stringhe che compongono l'output del programma, l'output viene letto e confrontato con Scanner.next()
	 */
	private void testFile(String nomeFileSorgente, String[] datiIngresso, String[] outputPrevisto) {
		// Compilo il file .ita
		try {
			JasminTarget.compilaFile(cartellaFileTest + nomeFileSorgente + ".ita", false);
		} catch (Exception e) {
			fail(String.format("Compilazione %s fallita\n:Errore:%s", nomeFileSorgente, e));
		}
		
		// Creo il processo java dove il programma verrà eseguito
		ProcessBuilder pb = new ProcessBuilder("java", nomeFileSorgente);
		// Imposto la variabile di ambiente in modo che riconosce le classi compilate
		// all'interno della cartella testFiles/
		Map<String, String> environment = pb.environment();
		environment.put("CLASSPATH", cartellaFileTest);
		
		try {
			Process process = pb.start();
			
			// Invio al processo tutti i dati in ingresso, separati da un
			// ritorno a capo
			PrintStream pout = new PrintStream(process.getOutputStream());
			for ( String dato : datiIngresso) {
				pout.println(dato);
			}
			// Il flush è importante perché non lo fa in automatico
			// (il test di bloccava)
			pout.flush();
			
			// Verifico che l'output previsto coincida con quello
			// attuale
			Scanner pin = new Scanner(process.getInputStream());
			for (String output : outputPrevisto) {
				try {
					String outputAttuale = pin.next();
					assertEquals(output, outputAttuale);
				} catch (java.util.NoSuchElementException ex) {
					// Nel caso l'output nel processo non è conforme
					// a quello previsto, allora stampo il contenuto
					// dell'error stream per poter meglio fare il debug
					Scanner errorScanner = new Scanner(process.getErrorStream());
					while (errorScanner.hasNextLine()) {
						System.out.println(errorScanner.nextLine());
					}
					fail("Output del processo non conforme");
				}
			}
			
			process.destroy();
			
			// Elimino il file class generato in modo da non creare spazzatura
			File classFile = new File(cartellaFileTest + nomeFileSorgente + ".class");
			classFile.delete();
		} catch (IOException e) {
			fail(String.format("Errore nell'avviare il processo:\n%s", e));
		}
		
	}
	
	@Test
	public void testCalcoloArea() {
		String[] datiIngresso = { "4", "3" };
		String[] outputPrevisto = { "12"};
		testFile("area", datiIngresso, outputPrevisto);
	}
	
	@Test
	public void testEspressioneComplessa() {
		String[] datiIngresso = { "4" };
		String[] outputPrevisto = { "37"};
		testFile("espressioneComplessa", datiIngresso, outputPrevisto);
		String[] datiIngresso2 = { "45" };
		String[] outputPrevisto2 = { "365"};
		testFile("espressioneComplessa", datiIngresso2, outputPrevisto2);
	}

}