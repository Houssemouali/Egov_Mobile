/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handler;

import entite.Extrait_Naissance;
import java.util.Date;
import java.util.Vector;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author iheb
 */
public class Extrait_handler extends DefaultHandler {
    //static int s;
    private Vector extraitVector;
    
    public Extrait_handler(){
        extraitVector = new Vector();
    }
    
     public Extrait_Naissance [] getExtrait(){
        
        Extrait_Naissance[] extraiTab = new Extrait_Naissance[extraitVector.size()];
        extraitVector.copyInto(extraiTab);
        
        return extraiTab;
    }
     
     
      private Extrait_Naissance currentJExtrait;
      
      public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("demandeextrait")) {

            String nom = attributes.getValue("nom");
            String prenom = attributes.getValue("prenom");
            //String lieu = attributes.getValue("lieu_naissance");
            //String datenaissance = attributes.getValue("date_naissance");
            //String cin_pere = attributes.getValue("cin_pere");
            //String cin_mere = attributes.getValue("cin_mere");
            String etat = attributes.getValue("etat");
            String commentaire = attributes.getValue("commentaire");
           // String num = attributes.getValue("id");
             //s=Integer.parseInt(num);
            
            // Date date = attributes.getValue("nomPere");
             
                                //String sex = attributes.getValue("sex");

            currentJExtrait = new Extrait_Naissance(nom,prenom,etat,commentaire);
//            if (nom == null || prenom == null) {
//                throw new IllegalArgumentException("Extrait requires both nom and prenom");
//            }
     
        } }
      
          
        
    
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("demandeextrait")) {
            
             extraitVector.addElement(currentJExtrait);
            
            currentJExtrait = null;
        }
    }
}
