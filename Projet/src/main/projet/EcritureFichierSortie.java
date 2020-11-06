package projet;

import java.io.File;

public class EcritureFichierSortie {

	private String format;
	private File fichierSortie;
	
	public EcritureFichierSortie(String format, String dossierSortie) {
		this.format = format;
		this.fichierSortie = new File(dossierSortie);
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public File getFichierSortie() {
		return fichierSortie;
	}

	public void setFichierSortie(File fichierSortie) {
		this.fichierSortie = fichierSortie;
	}
	
	
	
	
}
