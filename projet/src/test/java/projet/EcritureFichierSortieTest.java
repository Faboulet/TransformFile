package projet;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

public class EcritureFichierSortieTest extends TestCase {

	public void testEcrireFichier() {
		
		String dossierEntree = "src/test/resources/test1.txt";
		String dossierSortie = "src/test/resources/test1.xml";
		
		List<LigneInfos> listeInfos = new ArrayList<LigneInfos>();
		LigneInfos ligneInfos = new LigneInfos(false, 1460100040, "R",
				(float)45.12, 27, 0, "", "");
		listeInfos.add(ligneInfos);
		
		EcritureFichierSortie fichier = new EcritureFichierSortie(dossierEntree, "XML", dossierSortie);
		fichier.ecrireFichier(listeInfos);
	}
	
	public void testEcrireFichierXML() {
		
		String dossierEntree = "src/test/resources/test1.txt";
		String dossierSortie = "src/test/resources/test1.xml";
		
		List<LigneInfos> listeInfos = new ArrayList<LigneInfos>();
		LigneInfos ligneInfos = new LigneInfos(false, 1460100040, "R",
				(float)45.12, 27, 0, "", "");
		listeInfos.add(ligneInfos);
		
		EcritureFichierSortie fichier = new EcritureFichierSortie(dossierEntree, "XML", dossierSortie);
		fichier.ecrireFichierXML(listeInfos);
	}
	
	public void testEcrireFichierJSON() {
		
		String dossierEntree = "src/test/resources/test2.txt";
		String dossierSortie = "src/test/resources/test2.json";
		
		List<LigneInfos> listeInfos = new ArrayList<LigneInfos>();
		LigneInfos ligneInfos = new LigneInfos(true, 1462100403, "",
				(float)0.0, 0, 1, "Incorrect value for color", "1462100403;A;100.1;9");
		listeInfos.add(ligneInfos);
		
		EcritureFichierSortie fichier = new EcritureFichierSortie(dossierEntree, "JSON", dossierSortie);
		fichier.ecrireFichierJSON(listeInfos);
	}
}
