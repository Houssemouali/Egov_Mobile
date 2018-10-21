/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handler;

import entities.facture;
import java.util.Vector;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author lenovo
 */
public class FactureHandler  extends DefaultHandler {
    private Vector factureVector;

    public FactureHandler() {
        factureVector = new Vector();
    }

    public facture[] getFactures() {
        facture[] personTab = new facture[factureVector.size()];
        factureVector.copyInto(personTab);
        return personTab;
    }

   String selectedBalise = "";
    facture seclectedFacture;

    public void startElement(String string, String string1, String qName, Attributes atrbts) throws SAXException {
        if (qName.equals("facture")) {
            seclectedFacture = new facture();
        } else if (qName.equals("id")) {
            selectedBalise = "id";
        } else if (qName.equals("cin")) {
            selectedBalise = "cin";
        }
    }

    public void endElement(String string, String string1, String qName) throws SAXException {
        if (qName.equals("facture")) {

            factureVector.addElement(seclectedFacture);
            seclectedFacture = null;
        } else if (qName.equals("id")) {
            selectedBalise = "";
        } else if (qName.equals("cin")) {
            selectedBalise = "";
        }
        
    }

    public void characters(char[] chars, int i, int i1) throws SAXException {
        if (seclectedFacture != null) {
            if (selectedBalise.equals("id")) {
                seclectedFacture.setId(Integer.parseInt(new String(chars, i, i1)));
            }
            if (selectedBalise.equals("cin")) {
                seclectedFacture.setcin(Integer.parseInt(new String(chars, i, i1)));
            }
            
            
        }
    }
    
}
