package projet;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

public class EcritureFichierSortieTest extends TestCase {

	/**
	 * Méthode testEcrireFichier
	 * Permettant de tester EcritureFichierSortie.ecrireFichier
	 */
	public void testEcrireFichier() {
		
		String dossierEntree = "src/test/resources/test_ecriture.txt";
		String dossierSortie = "src/test/resources/test_ecriture.xml";
		
		List<LigneInfos> listeInfos = new ArrayList<LigneInfos>();
		LigneInfos ligneInfos = new LigneInfos(false, 1460100040, "R",
				(float)45.12, 27, 0, "", "");
		listeInfos.add(ligneInfos);
		
		EcritureFichierSortie fichier = new EcritureFichierSortie(dossierEntree, "XML", dossierSortie);
		fichier.ecrireFichier(listeInfos);
	}
	
	/**
	 * Méthode testEcrireFichierXML
	 * Permettant de tester EcritureFichierSortie.ecrireFichierXML
	 */
	public void testEcrireFichierXML() {
		
		String dossierEntree = "src/test/resources/test_ok.txt";
		String dossierSortie = "src/test/resources/test_ok.xml";
		List<LigneInfos> listeInfos = new ArrayList<LigneInfos>();
		LigneInfos ligneInfos = new LigneInfos(false, 1460100040, "R",
				(float)45.12, 27, 0, "", "");
		listeInfos.add(ligneInfos);
		
		EcritureFichierSortie fichier = new EcritureFichierSortie(dossierEntree, "XML", dossierSortie);
		fichier.ecrireFichierXML(listeInfos);
	}
	
	/**
	 * Méthode testEcrireFichierJSON
	 * Permettant de tester EcritureFichierSortie.ecrireFichierJSON
	 */
	public void testEcrireFichierJSON() {
		
		String dossierEntree = "src/test/resources/test_couleur_incorrecte.txt";
		String dossierSortie = "src/test/resources/test_couleur_incorrecte.json";
		
		List<LigneInfos> listeInfos = new ArrayList<LigneInfos>();
		LigneInfos ligneInfos = new LigneInfos(true, 1460100040, "",
				(float)0.0, 0, 1, "Incorrect value for color", "1460100040;A;45.12;27");
		listeInfos.add(ligneInfos);
		
		EcritureFichierSortie fichier = new EcritureFichierSortie(dossierEntree, "JSON", dossierSortie);
		fichier.ecrireFichierJSON(listeInfos);
	}
}