package egovmobile;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import entite.Extrait_Naissance;
import handler.Extrait_handler;
import java.io.DataInputStream;
import java.io.IOException;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.ChoiceGroup;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.DateField;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.List;
import javax.microedition.lcdui.TextField;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

/**
 *
 * @author iheb
 */
public class ExtraitForm extends List implements CommandListener, Runnable{
/*Command cmdOk = new Command("OK", Command.SCREEN, 0);
    Command cmdBack = new Command("back", Command.EXIT, 0);
        TextField nom = new TextField("nom", "", 50, TextField.ANY);
            TextField nompere = new TextField("nom pere", "", 50, TextField.ANY);
         TextField prenom = new TextField("prenom", "", 50, TextField.ANY);

        TextField nommere = new TextField("nom mere", "", 50, TextField.ANY);

     
        TextField adresse = new TextField("adresse naissance", "", 50, TextField.ANY);
            TextField nationalite = new TextField("nationalite", "", 50, TextField.ANY);
            
            String[] items = {"homme","femme"};
                ChoiceGroup cg = new ChoiceGroup("sex", ChoiceGroup.EXCLUSIVE, items, null);
                     DateField dat=new DateField ("Date naissance",2);


              String url = "http://localhost/pi3amobile/insert.php";



*/  String url = "http://localhost/egovmobilee/affichext.php?cin="+Midlet.cin;
//static int s;
    HttpConnection hc;
    DataInputStream dis;
    
 Command cmdRefresh = new Command("refresh", Command.SCREEN, 0);
   Extrait_Naissance[] extrait;
    StringBuffer sb;
    Display disp;
    
    
    public ExtraitForm(String title, int listType, Display d) {
       /* append(nom);
        append(prenom);
                append(nompere);
                        append(nommere);
        append(adresse);
        append(cg);
        append(dat);
        append(nationalite);
        addCommand(cmdOk);
        addCommand(cmdBack);*/
                super(title, listType);
        disp=d;
        Thread th = new Thread(this);
        th.start();
        setCommandListener(this);
        addCommand(cmdRefresh);


    }

    public void commandAction(Command c, Displayable d) {
         if (c == cmdRefresh) {
            //disp.setCurrent(loadingDialog);
            Thread th = new Thread(this);
            th.start();
        }
    }

    public void run() {
        
        
        
        
         try {
            
            Extrait_handler extraitHandler = new Extrait_handler();
            // get a parser object
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            // get an InputStream from somewhere (could be HttpConnection, for example)
            /* hc = (HttpConnection) Connector.open(url + "nom=" + nom.getString() + "&prenom=" + prenom.getString() + "&cinpere=" + Integer.parseInt(cinpere.getString()) + "&cinmere=" + Integer.parseInt(cinmere.getString()) + "&lieu=" + lieu.getString() 
                    + "&dat=" + date.trim());
            dis = new DataInputStream(hc.openDataInputStream());*/
            hc = (HttpConnection) Connector.open(url);
             dis = new DataInputStream(hc.openDataInputStream());
            parser.parse(dis, extraitHandler);
            // display the result
            extrait = extraitHandler.getExtrait();
         
            if (extrait.length > 0) {
                deleteAll();
                for (int i = 0; i < extrait.length; i++) {
                    append(extrait[i].getFullName(), null);
                }
            }
        } catch (ParserConfigurationException ex) {
            ex.printStackTrace();
        } catch (SAXException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }



    
}
