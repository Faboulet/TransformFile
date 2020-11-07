package projet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

public class LectureFichierEntree {

	private static final Logger logger = Logger.getLogger(LectureFichierEntree.class);
	
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
	
	/**
	 * Méthode verifierLigne
	 * Permettant de vérifier chaque ligne d'entrée
	 * @param ligne la ligne à traiter
	 * @param noLigne numero de la ligne 
	 * @return LigneInfos : contenant chaque élément de la ligne
	 */
	
	public LigneInfos verifierLigne(String ligne, int noLigne) {
		
		if (logger.isDebugEnabled()) {
            logger.debug("verifierLigne() est exécutée !");
        }
		LigneInfos ligneInfos = new LigneInfos();
		
		String[] infos = ligne.split(";");
		//Verification s'il y a bien 4 paramètres
		if (infos.length != 4) {
			ligneInfos.setErreur(true);
			ligneInfos.setNoLigneErreur(noLigne);
			ligneInfos.setMessageErreur("Problem in the number of parameters");
			logger.error("Problem in the number of parameters : " + ligne);
			ligneInfos.setLigneErreur(ligne);
		}
		else {
			//Verification si le numero de reference fait 10 chiffres
			if (infos[0].length() != 10) {
				ligneInfos.setErreur(true);
				ligneInfos.setNoLigneErreur(noLigne);
				ligneInfos.setMessageErreur("Problem reference doesn't have 10 digits");
				logger.error("Problem reference doesn't have 10 digits : " + infos[0]);
				ligneInfos.setLigneErreur(ligne);
			}
			else {
				ligneInfos.setNumRef(Integer.parseInt(infos[0]));
				//Verification si la couleur est différente de R, G ou B
				if (!(infos[1].equals(String.valueOf('R')) || infos[1].equals(String.valueOf('G'))
						|| infos[1].equals(String.valueOf('B')))) {
					ligneInfos.setErreur(true);
					ligneInfos.setNoLigneErreur(noLigne);
					ligneInfos.setMessageErreur("Incorrect value for color");
					logger.error("Incorrect value for color : " + infos[1]);
					ligneInfos.setLigneErreur(ligne);
				}
				else {
					// tous les éléments sont corrects
					ligneInfos.setErreur(false);
					ligneInfos.setCouleur(infos[1]);
					ligneInfos.setValeur(Float.parseFloat(infos[2]));
					ligneInfos.setTaille(Integer.parseInt(infos[3]));
					logger.info("Toutes les infos de la ligne " + ligne + " ont été traités correctement.");
				}
			}
		}
		
		return ligneInfos;
		
	}
	
	/**
	 * Méthode lireFichier
	 * Permettant de lire le fichier d'entrée 
	 * @return List<LigneInfos> : contenant la liste des éléments du fichier
	 */
	
	public List<LigneInfos> lireFichier(){
		if (logger.isDebugEnabled()) {
            logger.debug("lireFichier() est exécutée !");
        }
		FileReader fr;
		BufferedReader br;
		List<LigneInfos> listeInfos = new ArrayList<LigneInfos>();
		try {
			fr = new FileReader(this.fichierEntree);
			br = new BufferedReader(fr);
			String ligne = "";
			int nbLigne = 1;
			while ((ligne = br.readLine()) != null) {
				logger.info("Information de la ligne : " + ligne);
				LigneInfos ligneInfos = this.verifierLigne(ligne, nbLigne);
				listeInfos.add(ligneInfos);
				nbLigne ++;
			}
			br.close();
			
		} catch (FileNotFoundException e) {
			logger.error("Le fichier " + this.fichierEntree + " n'existe pas");
			e.printStackTrace();
		}  catch (IOException e) {
			logger.error("Problème d'entrée/sortie");
			e.printStackTrace();
		}
		return listeInfos;
	}
}
