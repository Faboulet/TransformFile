package projet;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

public class LectureFichierEntreeTest extends TestCase{

	/**
	 * Méthode testLireFichier
	 * Permettant de tester LectureFichierEntree.lireFichier
	 */
	public void testLireFichier() {
		
		String fichier1 = "src/test/resources/test_lire_fichier.txt";
		List<LigneInfos> listeInfos = new ArrayList<LigneInfos>();
		LigneInfos ligneInfos = new LigneInfos(false, 1460100040, "R",
				(float)45.12, 27, 0, "", "");
		listeInfos.add(ligneInfos);
		LectureFichierEntree lecture = new LectureFichierEntree(fichier1);
		assertEquals(listeInfos.toString(), lecture.lireFichier().toString());
	}
	
	/**
	 * Méthode testVerifierLigneOK
	 * Permettant de tester LectureFichierEntree.verifierLigne
	 * Avec des paramètres OK
	 */
	public void testVerifierLigneOK() {
		String fichier = "src/test/resources/test_OK.txt";
		LigneInfos ligneInfos = new LigneInfos(false, 1460100040, "R",
				(float)45.12, 27, 0, "", "");
		LectureFichierEntree lecture = new LectureFichierEntree(fichier);
		assertEquals(ligneInfos.toString(), lecture.verifierLigne("1460100040;R;45.12;27",1).toString());
	}
	
	/**
	 * Méthode testVerifierLigneProblemeNbParametres
	 * Permettant de tester LectureFichierEntree.verifierLigne
	 * Avec un nombre de paramètres incorrect
	 */
	public void testVerifierLigneProblemeNbParametres() {
		String fichier = "src/test/resources/test_nb_parametres.txt";
		LigneInfos ligneInfos = new LigneInfos(true, 0, "",
				(float)0.0, 0, 1, "Problem in the number of parameters", "1460100040;R;45.12");
		LectureFichierEntree lecture = new LectureFichierEntree(fichier);
		assertEquals(ligneInfos.toString(), lecture.verifierLigne("1460100040;R;45.12",1).toString());
	}
	
	/**
	 * Méthode testVerifierLigneProblemeNumRef
	 * Permettant de tester LectureFichierEntree.verifierLigne
	 * Avec un NumRef ne contenant pas 10 numeros
	 */
	public void testVerifierLigneProblemeNumRef() {
		String fichier = "src/test/resources/test_num_ref.txt";
		LigneInfos ligneInfos = new LigneInfos(true, 0, "",
				(float)0.0, 0, 1, "Problem reference doesn't have 10 digits", "146010004;R;45.12;27");
		LectureFichierEntree lecture = new LectureFichierEntree(fichier);
		assertEquals(ligneInfos.toString(), lecture.verifierLigne("146010004;R;45.12;27",1).toString());
	}
	
	/**
	 * Méthode testVerifierLigneProblemeCouleur
	 * Permettant de tester LectureFichierEntree.verifierLigne
	 * Avec une couleur différente de R,G,B
	 */
	public void testVerifierLigneProblemeCouleur() {
		String fichier = "src/test/resources/test_couleur_incorrecte.txt";
		LigneInfos ligneInfos = new LigneInfos(true, 1460100040, "",
				(float)0.0, 0, 1, "Incorrect value for color", "1460100040;A;45.12;27");
		LectureFichierEntree lecture = new LectureFichierEntree(fichier);
		assertEquals(ligneInfos.toString(), lecture.verifierLigne("1460100040;A;45.12;27",1).toString());
	}
}
