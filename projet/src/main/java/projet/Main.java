package projet;

import java.util.List;

import org.apache.log4j.Logger;

public class Main {
	
	static final Logger logger = Logger.getLogger(Main.class);

	/**
	 * Méthode principale main
	 * @param args devant contenir les paramètres suivants :
	 * ◦ Chemin du fichier texte
	 * ◦ Format de sortie (XLM/JSON)
	 * ◦ Chemin du fichier en sortie
	 */
	
	public static void main(String[] args) {
		
		if (logger.isDebugEnabled()) {
            logger.debug("Main() est exécutée !");
        }
		
		if (args.length != 3) {
			logger.error("Problème dans les paramètres d'entrée");
		}
		else if (!args[1].trim().toLowerCase().equals("json") && !args[1].trim().toLowerCase().equals("xml")) {
			logger.error("Le format de sortie doit être json ou xml");
		}
		else if (!args[1].trim().toLowerCase().equals(args[2].trim().toLowerCase()
				.substring(args[2].lastIndexOf('.') + 1, args[2].length()))) {
			logger.error("L'extension du fichier de sortie ne correspond pas au type de fichier");
		}
		else {
			String dossierFichierTexte = args[0];
			logger.info("Répertoire fichier texte : " + dossierFichierTexte);
			String formatSortie = args[1];
			logger.info("Format fichier sortie : " + formatSortie);
			String dossierFichierSortie = args[2];
			logger.info("Répertoire fichier sortie : " + dossierFichierSortie);
			
			List<LigneInfos> listeInfos = new LectureFichierEntree(dossierFichierTexte).lireFichier();
			new EcritureFichierSortie(dossierFichierTexte, formatSortie, dossierFichierSortie).ecrireFichier(listeInfos);
		}
	}

}
