/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egovmobile;

import entities.CinEntities;
import java.util.Vector;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author lenovo
 */
public class cinHandler extends DefaultHandler {
     private Vector cinVector;

    public cinHandler() {
        cinVector = new Vector();
    }

    public CinEntities[] getAutorisations() {
        CinEntities[] personTab = new CinEntities[cinVector.size()];
        cinVector.copyInto(personTab);
        return personTab;
    }

   String selectedBalise = "";
    CinEntities selectedCin;

    public void startElement(String string, String string1, String qName, Attributes atrbts) throws SAXException {
        if (qName.equals("cin")) {
            selectedCin = new CinEntities();
        } else if (qName.equals("id")) {
            selectedBalise = "id";
        } else if (qName.equals("num_cin")) {
            selectedBalise = "num_cin";
        }
    }

    public void endElement(String string, String string1, String qName) throws SAXException {
        if (qName.equals("cin")) {

            cinVector.addElement(selectedCin);
            selectedCin = null;
        } else if (qName.equals("id")) {
            selectedBalise = "";
        } else if (qName.equals("num_cin")) {
            selectedBalise = "";
        }
        
    }

    public void characters(char[] chars, int i, int i1) throws SAXException {
        if (selectedCin != null) {
            if (selectedBalise.equals("id")) {
                selectedCin.setId(Integer.parseInt(new String(chars, i, i1)));
            }
            if (selectedBalise.equals("num_cin")) {
                selectedCin.setNumcin(new String(chars, i, i1));
            }
        }
    }
}
