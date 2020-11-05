package projet;

public class Main {

	public static void main(String[] args) {
		/**Méthode d'entrée prenant les paramètres suivants
		 * ◦ Chemin du fichier texte
		 * ◦ Format de sortie (XLM/JSON)
		 * ◦ Chemin du fichier en sortie
		 */
		
		if (args.length != 3) {
			System.out.println("Problème dans les paramètres d'entrée");
		}
		else {
			String dossierFichierTexte = args[0];
			String formatSortie = args[1];
			String dossierFichierSortie = args[2];
			
			System.out.println("Répertoire fichier texte : " + dossierFichierTexte);
			System.out.println("Format fichier sortie : " + formatSortie);
			System.out.println("Répertoire fichier sortie : " + dossierFichierSortie);
		}
		

	}

}
