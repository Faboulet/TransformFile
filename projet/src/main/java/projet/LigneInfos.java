package projet;

public class LigneInfos {
	
	int numRef;
	String couleur;
	float valeur;
	int taille;
	
	boolean erreur;
	int noLigneErreur;
	String messageErreur;
	String ligneErreur;
	
	public LigneInfos() {
		this.erreur = false;
		this.numRef = 0;
		this.couleur = "";
		this.valeur = (float) 0.0;
		this.taille = 0;
		this.noLigneErreur = 0;
		this.messageErreur = "";
		this.ligneErreur = "";
	}
	
	public LigneInfos(boolean erreur, int numRef, String couleur,
			float valeur, int taille, int noLigneErreur, String messageErreur, String ligneErreur) {
		this.erreur = erreur;
		this.numRef = numRef;
		this.couleur = couleur;
		this.valeur = valeur;
		this.taille = taille;
		this.noLigneErreur = noLigneErreur;
		this.messageErreur = messageErreur;
		this.ligneErreur = ligneErreur;
	}
	
	public int getNumRef() {
		return numRef;
	}
	public void setNumRef(int numRef) {
		this.numRef = numRef;
	}
	public String getCouleur() {
		return couleur;
	}
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	public float getValeur() {
		return valeur;
	}
	public void setValeur(float valeur) {
		this.valeur = valeur;
	}
	public int getTaille() {
		return taille;
	}
	public void setTaille(int taille) {
		this.taille = taille;
	}
	public boolean isErreur() {
		return erreur;
	}
	public void setErreur(boolean erreur) {
		this.erreur = erreur;
	}
	public int getNoLigneErreur() {
		return noLigneErreur;
	}
	public void setNoLigneErreur(int noLigneErreur) {
		this.noLigneErreur = noLigneErreur;
	}
	public String getMessageErreur() {
		return messageErreur;
	}
	public void setMessageErreur(String messageErreur) {
		this.messageErreur = messageErreur;
	}
	public String getLigneErreur() {
		return ligneErreur;
	}
	public void setLigneErreur(String ligneErreur) {
		this.ligneErreur = ligneErreur;
	}
	
	public String toString () {
		return "Num ref : ".concat(String.valueOf(this.getNumRef())).concat(" Couleur : ").concat(this.getCouleur())
				.concat(" Valeur : ").concat(String.valueOf(this.getValeur())).concat(" Taille : ").concat(String.valueOf(this.getTaille()))
				.concat(" Erreur : ").concat(String.valueOf(this.isErreur())).concat(" NoLigneErreur : ")
				.concat(String.valueOf(this.getNoLigneErreur())).concat(" Message erreur : ".concat(this.getMessageErreur()))
				.concat(" LigneErreur ").concat(this.getLigneErreur());
	}
	
	
}
