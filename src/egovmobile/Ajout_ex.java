/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egovmobile;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.Calendar;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.ChoiceGroup;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.DateField;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.ImageItem;
import javax.microedition.lcdui.List;
import javax.microedition.lcdui.TextField;
import javax.microedition.midlet.MIDlet;

/**
 *
 * @author iheb
 */
public class Ajout_ex extends Form implements CommandListener, Runnable {

    HttpConnection hc;
    DataInputStream dis;

    Command cmdok = new Command("VALIDER", Command.SCREEN, 0);
    Command cmdback = new Command("EXIT", Command.EXIT, 0);

    TextField nom = new TextField("nom", "", 50, TextField.ANY);
    TextField cinpere = new TextField("cin pere", "", 50, TextField.NUMERIC);
    TextField prenom = new TextField("prenom", "", 50, TextField.ANY);

    TextField cinmere = new TextField("cin mere", "", 50, TextField.NUMERIC);

    TextField lieu = new TextField("adresse naissance", "", 50, TextField.ANY);
    TextField nationalite = new TextField("nationalite", "", 50, TextField.ANY);

//    String[] items = {"homme", "femme"};
//    ChoiceGroup cg = new ChoiceGroup("sexe", ChoiceGroup.EXCLUSIVE, items, null);
   // DateField dat = new DateField("Date naissance", 3);
        DateField datenaiss = new DateField("Date de Naissance", DateField.DATE);
    ImageItem ii;
    String url = "http://localhost/egovmobilee/insertextrait.php?";

    public Ajout_ex() {

        super("ajout extrait");
        Image img = null;
        try {
            img = Image.createImage("/libs/bbb.PNG");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        ii = new ImageItem("", img, ImageItem.LAYOUT_CENTER, "indisponible");
        
         append(ii);
       append(nom);
        append(prenom);
      append(cinpere);
        append(cinmere);
       append(lieu);
      //append(cg);
        append(datenaiss);
        //append(nationalite);*/
       
        addCommand(cmdok);
        addCommand(cmdback);
        setCommandListener(this);

    }

    public void commandAction(Command c, Displayable d) {

        if (c == cmdok) {
            Thread th = new Thread(this);
            th.start();
        }
        if (c == cmdback) {
           Midlet.INSTANCE.disp.setCurrent(new menuextrait());
        }
    }
 public String getDateField(DateField dd) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(dd.getDate());
        String date;
        date = cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" + (cal.get(Calendar.DAY_OF_MONTH));
        return date;
    }
    public void run() {
        try {         String date=getDateField(datenaiss);
            System.out.println(url + "nom=" + nom.getString() + "&prenom=" + prenom.getString() + "&cinpere=" +cinpere.getString() + "&cinmere=" + cinmere.getString() + "&lieu=" + lieu.getString() 
                    + "&dat=" + date.trim()+"&cin="+Midlet.cin);
//"&sex=" + cg.getString(cg.getSelectedIndex())
            // System.out.println(url+"?nom=" + nom.getString() + "&prenom=" + prenom.getString() +"&civilite="+civilite.getString(civilite.getSelectedIndex())+ "&cin=" + Integer.parseInt(cin.getString())+ "&mail=" + mail.getString() + "&montant=" + Integer.parseInt(montant.getString()));
            hc = (HttpConnection) Connector.open(url + "nom=" + nom.getString() + "&prenom=" + prenom.getString() + "&cinpere=" + cinpere.getString() + "&cinmere=" + cinmere.getString() + "&lieu=" + lieu.getString() 
                    + "&dat=" + date.trim()+"&cin="+Midlet.cin);
            dis = new DataInputStream(hc.openDataInputStream());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            dis = hc.openDataInputStream();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        int ascii;

        StringBuffer sb = new StringBuffer();

        try {
            while ((ascii = dis.read()) != -1) {

                sb.append((char) ascii);

            }
            dis.close();
            hc.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        if (sb.toString().equals("successfully added")) {
            Alert a = new Alert("Information", sb.toString(), null, AlertType.CONFIRMATION);
            a.setTimeout(3000);
            Midlet.INSTANCE.disp.setCurrent(a);

        } else {
            Alert a = new Alert("Information", sb.toString(), null, AlertType.ERROR);
            a.setTimeout(3000);
            Midlet.INSTANCE.disp.setCurrent(a);

        }

    }
}
