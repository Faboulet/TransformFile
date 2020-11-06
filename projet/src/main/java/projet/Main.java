package projet;

import java.util.List;

import org.apache.log4j.Logger;

public class Main {
	
	static final Logger logger = Logger.getLogger(Main.class);

	public static void main(String[] args) {
		/** Méthode d'entrée prenant les paramètres suivants
		 * ◦ Chemin du fichier texte
		 * ◦ Format de sortie (XLM/JSON)
		 * ◦ Chemin du fichier en sortie
		 */
		
		if (logger.isDebugEnabled()) {
            logger.debug("Main() est exécutée !");
        }
		
		if (args.length != 3) {
			logger.error("Problème dans les paramètres d'entrée");
		}
		else {
			String dossierFichierTexte = args[0];
			logger.info("Répertoire fichier texte : " + dossierFichierTexte);
			String formatSortie = args[1];
			logger.info("Format fichier sortie : " + formatSortie);
			String dossierFichierSortie = args[2];
			logger.info("Répertoire fichier sortie : " + dossierFichierSortie);
			
			List<LigneInfos> listeInfos = new LectureFichierEntree(dossierFichierTexte).lireFichier();
			new EcritureFichierSortie(dossierFichierTexte, formatSortie, dossierFichierSortie).ecrireFichier(listeInfos);;
		}
		

	}

}
