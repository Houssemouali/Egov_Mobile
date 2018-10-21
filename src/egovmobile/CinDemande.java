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
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.DateField;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.ImageItem;
import javax.microedition.lcdui.TextField;

/**
 *
 * @author Houssem
 */
public class CinDemande extends Form implements CommandListener, Runnable {

    //TextField tfextrait = new TextField("n°extrait", "", 11, TextField.NUMERIC);
    //DateField datenaiss = new DateField("Date de naissance", DateField.DATE);
    //TextField tfadressve = new TextField("Adresse", "", 20, TextField.ANY);
    TextField tfadresse = new TextField("Adresse", "", 20, TextField.ANY);
    TextField tfprofession = new TextField("Profession", "", 20, TextField.ANY);
    Command cmdOk = new Command("OK", Command.SCREEN, 0);
    Command cmdBack = new Command("Back", Command.EXIT, 0);
    Image image;
    ImageItem ii;
    HttpConnection hc;
    DataInputStream dis;
    StringBuffer sb;
    String url = "http://localhost/egovmobilee/insertcin.php?";

    public CinDemande() {
        super("Demande de CIN");
        Image img = null;
        try {
            img = Image.createImage("/libs/CIN.png");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        ii = new ImageItem("", img, ImageItem.LAYOUT_CENTER, "indisponible");

        append(ii);
        //append(tfextrait);
        //append(datenaiss);
        append(tfadresse);
        append(tfprofession);
        addCommand(cmdOk);
        addCommand(cmdBack);
        setCommandListener(this);
    }

    public void commandAction(Command c, Displayable d) {
        if (c == cmdOk) {
            if (tfadresse.getString().equals("") || tfprofession.getString().equals("")) {
                Alert al = new Alert("", "SVP Remplire tous lec Champs!", null, AlertType.WARNING);
                Midlet.INSTANCE.disp.setCurrent(al);

            } else {
                Thread th = new Thread(this);
                th.start();
            }
        }
        if (c == cmdBack) {
            Midlet.INSTANCE.disp.setCurrent(new MenuConnecte());
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
        /*tfnom.setString("");
         tfprenom.setString("");
         //datenaiss.setDate("");
         tfville.setString("");
         tfadresse.setString("");
         tfnompere.setString("");
         tfnommere.setString("");
         tfprofession.setString("");*/

        try {

            hc = (HttpConnection) Connector.
                    open(url +"cin="+Midlet.cin + "&adresse=" + tfadresse.getString()
                            + "&profession=" + tfprofession.getString());

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try {
            dis = hc.openDataInputStream();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        int ascii;
        sb = new StringBuffer();

        try {
            while ((ascii = dis.read()) != -1) {

                sb.append((char) ascii);

            }
            dis.close();
            hc.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        if (sb.toString().equals("Demande de cin ajouté avec succés")) {
            Alert a = new Alert("Information", sb.toString(), null, AlertType.CONFIRMATION);
            a.setTimeout(3000);
            // Midlet.INSTANCE.disp.setCurrent(a, new MenuConnecte());

        } else { //eror
            Alert a = new Alert("Information", sb.toString(), null, AlertType.ERROR);
            a.setTimeout(3000);
            Midlet.INSTANCE.disp.setCurrent(a);

        }

    }
}
