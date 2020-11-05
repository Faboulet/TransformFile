package projet;

import java.io.File;

public class LectureFichierEntree {

	private File fichierEntree;
	
	public LectureFichierEntree(String dossier) {
		this.fichierEntree = new File(dossier);
	}

	public File getFichierEntree() {
		return fichierEntree;
	}

	public void setFichierEntree(File fichierEntree) {
		this.fichierEntree = fichierEntree;
	}
	
}
