/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handler;

import entities.facturetype;
import java.util.Vector;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author lenovo
 */
public class FactureTypeHandler extends DefaultHandler {
    private Vector facturetypeVector;

    public FactureTypeHandler() {
        facturetypeVector = new Vector();
    }

    public facturetype[] getFactures() {
        facturetype[] personTab = new facturetype[facturetypeVector.size()];
        facturetypeVector.copyInto(personTab);
        return personTab;
    }
     String selectedBalise = "";
    facturetype seclectedFactureType;

    public void startElement(String string, String string1,String qName, Attributes atrbts) throws SAXException {
        if (qName.equals("facturetype")) {
            seclectedFactureType = new facturetype();
        } else if (qName.equals("STEG")) {
            selectedBalise = "STEG";
        } else if (qName.equals("SONEDE")) {
            selectedBalise = "SONEDE";
        }else if (qName.equals("TOTAL")) {
            selectedBalise = "TOTAL";
        }
    }

    public void endElement(String string, String string1, String qName) throws SAXException {
        if (qName.equals("facturetype")) {

            facturetypeVector.addElement(seclectedFactureType);
            seclectedFactureType = null;
        } else if (qName.equals("STEG")) {
            selectedBalise = "";
        } else if (qName.equals("SONEDE")) {
            selectedBalise = "";
        }else if (qName.equals("TOTAL")) {
            selectedBalise = "";
        }
        
    }

    public void characters(char[] chars, int i, int i1) throws SAXException {
        if (seclectedFactureType != null) {
            if (selectedBalise.equals("STEG")) {
                seclectedFactureType.setSTEG(Integer.parseInt(new String(chars, i, i1)));
            }
            if (selectedBalise.equals("SONEDE")) {
                seclectedFactureType.setSONEDE(Integer.parseInt(new String(chars, i, i1)));
            }
            if (selectedBalise.equals("TOTAL")) {
                seclectedFactureType.setTOTAL(Integer.parseInt(new String(chars, i, i1)));
            }
            
            
        }
    }
}
