package projet;

import junit.framework.*;

public class MainTest extends TestCase{

	public void testMain() {
		
		String dossierFichierTexte = "src/test/resources/test.txt";
		String format = "JSON";
		String dossierFichierSortie = "src/test/resources/test.json";

		Main.main(new String[] {dossierFichierTexte, format,dossierFichierSortie });
	}
	
}
