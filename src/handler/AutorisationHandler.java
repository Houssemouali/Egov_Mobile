/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handler;

import entities.autorisation;
import java.util.Vector;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author lenovo
 */
public class AutorisationHandler extends DefaultHandler {
     private Vector autorisationVector;

    public AutorisationHandler() {
        autorisationVector = new Vector();
    }

    public autorisation[] getAutorisations() {
        autorisation[] personTab = new autorisation[autorisationVector.size()];
        autorisationVector.copyInto(personTab);
        return personTab;
    }

   String selectedBalise = "";
    autorisation seclectedAutorisation;

    public void startElement(String string, String string1, String qName, Attributes atrbts) throws SAXException {
        if (qName.equals("autorisation")) {
            seclectedAutorisation = new autorisation();
        } else if (qName.equals("id")) {
            selectedBalise = "id";
        } else if (qName.equals("cin")) {
            selectedBalise = "cin";
        }
    }

    public void endElement(String string, String string1, String qName) throws SAXException {
        if (qName.equals("autorisation")) {

            autorisationVector.addElement(seclectedAutorisation);
            seclectedAutorisation = null;
        } else if (qName.equals("id")) {
            selectedBalise = "";
        } else if (qName.equals("cin")) {
            selectedBalise = "";
        }
        
    }

    public void characters(char[] chars, int i, int i1) throws SAXException {
        if (seclectedAutorisation != null) {
            if (selectedBalise.equals("id")) {
                seclectedAutorisation.setId(Integer.parseInt(new String(chars, i, i1)));
            }
            if (selectedBalise.equals("cin")) {
                seclectedAutorisation.setcin(Integer.parseInt(new String(chars, i, i1)));
            }
        }
    }
}
