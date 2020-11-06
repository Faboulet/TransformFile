package projet;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class EcritureFichierSortie {
	
	private static final Logger logger = Logger.getLogger(EcritureFichierSortie.class);

	private String fichierEntree;
	private String format;
	private String fichierSortie;
	
	public EcritureFichierSortie(String fichierEntree, String format, String dossierSortie) {
		this.fichierEntree = fichierEntree;
		this.format = format;
		this.fichierSortie = dossierSortie;
	}
	
	public String getFichierEntree() {
		return fichierEntree;
	}

	public void setFichierEntree(String fichierEntree) {
		this.fichierEntree = fichierEntree;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getFichierSortie() {
		return fichierSortie;
	}

	public void setFichierSortie(String fichierSortie) {
		this.fichierSortie = fichierSortie;
	}
	
	public void ecrireFichierXML(List<LigneInfos> listeInfos) {
		if (logger.isDebugEnabled()) {
	        logger.debug("ecrireFichierXML() est exécutée !");
	    }
		
		try {
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();
            document.setXmlStandalone(true);
            
            //Element à la racine
            Element root = document.createElement("report");
            document.appendChild(root);
            
            //Element inputFile
            Element inputFile = document.createElement("inputFile");
            inputFile.appendChild(document.createTextNode(this.getFichierEntree()));
            root.appendChild(inputFile);
            
            if (listeInfos.size() > 0) {
            	
        		//Element references
                Element references = document.createElement("references");
                
            	for (int i=0; i < listeInfos.size(); i++) {
            		
            		LigneInfos ligne = listeInfos.get(i);
                	Attr attr;
                	
                	if (!ligne.isErreur()) {
                        
                		//Element reference
                        Element reference = document.createElement("reference");
                        //Creation d'un attribut color
                        attr = document.createAttribute("color");
                        attr.setValue(ligne.getCouleur());
                        reference.setAttributeNode(attr);

                        //Creation d'un attribut price
                        attr = document.createAttribute("price");
                        attr.setValue(String.valueOf(ligne.getValeur()));
                        reference.setAttributeNode(attr);
                        
                        //Creation d'un attribut size
                        attr = document.createAttribute("size");
                        attr.setValue(String.valueOf(ligne.getTaille()));
                        reference.setAttributeNode(attr);
                        
                        //Creation d'un attribut numReference
                        attr = document.createAttribute("numReference");
                        attr.setValue(String.valueOf(ligne.getNumRef()));
                        reference.setAttributeNode(attr);
                        
                        references.appendChild(reference);
                	}

            	}
                root.appendChild(references);
                
        		//Element errors
                Element errors = document.createElement("errors");
                
                for (int i=0; i < listeInfos.size(); i++) {
                	
                	LigneInfos ligne = listeInfos.get(i);
                	Attr attr;
                	
                	if (ligne.isErreur()) {
                        
                        //Element error
                        Element error = document.createElement("error");
                        //Creation d'un attribut line
                        attr = document.createAttribute("line");
                        attr.setValue(String.valueOf(ligne.getNoLigneErreur()));
                        error.setAttributeNode(attr);

                        //Creation d'un attribut price
                        attr = document.createAttribute("message");
                        attr.setValue(String.valueOf(ligne.getMessageErreur()));
                        error.setAttributeNode(attr);
                        
                        error.appendChild(document.createTextNode(ligne.getLigneErreur()));
                        
                        errors.appendChild(error);

                	}
                }
                root.appendChild(errors);
            }
            
            //Creation du fichier XML
            //Transformation de l'objet DOM en fichier XML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(this.getFichierSortie());
            
            // Pour debugguer
            // StreamResult result = new StreamResult(System.out);
 
            transformer.transform(domSource, streamResult);
            
        } catch (ParserConfigurationException e) {
        	logger.error("Problème de configuration du fichier XML " + this.getFichierSortie());
            e.printStackTrace();
        } catch (TransformerException e) {
        	logger.error("Problème de création du fichier XML " + this.getFichierSortie());
            e.printStackTrace();
        }
		
		logger.info("Le fichier XML " + this.getFichierSortie() + " a été créé");
	}
	
	public void ecrireFichierJSON(List<LigneInfos> listeInfos) {
		if (logger.isDebugEnabled()) {
	        logger.debug("ecrireFichierJSON() est exécutée !");
	    }
		JSONObject json = new JSONObject();
		
		json.put("inputFile", this.getFichierEntree());
		
		JSONArray references = new JSONArray();
		JSONArray errors = new JSONArray();
		
		for (int i=0; i < listeInfos.size(); i++) {
			LigneInfos ligneInfos = listeInfos.get(i);
			
			if (!ligneInfos.isErreur()) {
				//Création des références
				JSONObject item = new JSONObject();
				item.put("numReference", ligneInfos.getNumRef());
				item.put("size", ligneInfos.getTaille());
				item.put("price", ligneInfos.getValeur());
				item.put("type", ligneInfos.getCouleur());
				references.put(item);
			}
			else {
				//Création des erreurs
				JSONObject item = new JSONObject();
				item.put("line", ligneInfos.getNoLigneErreur());
				item.put("message", ligneInfos.getMessageErreur());
				item.put("value", ligneInfos.getLigneErreur());
				errors.put(item);
			}
			
		}
		
		json.put("references", references);
		json.put("errors", errors);
		
        //Ecrire le fichier JSON
        try {
        	FileWriter file = new FileWriter(this.getFichierSortie());
        	file.write(json.toString());
            file.flush();
 
        } catch (IOException e) {
        	logger.error("Problème d'écriture du fichier " + this.getFichierSortie());
            e.printStackTrace();
        }
        
        logger.info("Le fichier JSON " + this.getFichierSortie() + " a été créé");
	}
	
	public void ecrireFichier(List<LigneInfos> listeInfos) {
		if (logger.isDebugEnabled()) {
	        logger.debug("ecrireFichier() est exécutée !");
	    }
		if (this.format.trim().toUpperCase().equals("JSON")) this.ecrireFichierJSON(listeInfos);
		else this.ecrireFichierXML(listeInfos);
	}
	
	
}
