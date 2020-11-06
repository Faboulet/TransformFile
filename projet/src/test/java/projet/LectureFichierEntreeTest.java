package projet;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

public class LectureFichierEntreeTest extends TestCase{

	public void testVerifierLigne() {
		String fichier2 = "src/test/resources/test2.txt";
		LigneInfos ligneInfos = new LigneInfos(true, 1462100403, "",
				(float)0.0, 0, 1, "Incorrect value for color", "1462100403;A;100.1;9");
		LectureFichierEntree lecture = new LectureFichierEntree(fichier2);
		assertEquals(ligneInfos.toString(), lecture.verifierLigne("1462100403;A;100.1;9",1).toString());
	}
	
	public void testLireFichier() {
		
		String fichier1 = "src/test/resources/test1.txt";
		List<LigneInfos> listeInfos = new ArrayList<LigneInfos>();
		LigneInfos ligneInfos = new LigneInfos(false, 1460100040, "R",
				(float)45.12, 27, 0, "", "");
		listeInfos.add(ligneInfos);
		LectureFichierEntree lecture = new LectureFichierEntree(fichier1);
		assertEquals(listeInfos.toString(), lecture.lireFichier().toString());
	}
}
