package projet;

import junit.framework.*;

public class MainTest extends TestCase{

	/**
	 * Méthode testMainOK
	 * Permettant de tester Main.main
	 */
	public void testMainOK() {
		
		String dossierFichierTexte = "src/test/resources/test.txt";
		String format = "JSON";
		String dossierFichierSortie = "src/test/resources/test.json";
		
		Main.main(new String[] {dossierFichierTexte, format, dossierFichierSortie });
	}
	
	/**
	 * Méthode testMainNbParameters
	 * Permettant de tester Main.main
	 * Avec un nombre de paramètres incorrect
	 */
	public void testMainNbParameters() {
		
		String dossierFichierTexte = "src/test/resources/test.txt";
		String format = "JSON";

		Main.main(new String[] {dossierFichierTexte, format});
	}
	
	/**
	 * Méthode testMainFormat
	 * Permettant de tester Main.main
	 * Avec un format incorrect
	 */
	public void testMainFormat() {
		
		String dossierFichierTexte = "src/test/resources/test.txt";
		String format = "test";
		String dossierFichierSortie = "src/test/resources/test.json";
		
		Main.main(new String[] {dossierFichierTexte, format, dossierFichierSortie});
	}
	
	/**
	 * Méthode testMainExtension
	 * Permettant de tester Main.main
	 * Avec un fichier de sortie incorrect
	 */
	public void testMainExtension() {
		
		String dossierFichierTexte = "src/test/resources/test.txt";
		String format = "json";
		String dossierFichierSortie = "src/test/resources/test.js";
		
		Main.main(new String[] {dossierFichierTexte, format, dossierFichierSortie});
	}
	
}
