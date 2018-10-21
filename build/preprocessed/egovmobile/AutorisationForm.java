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
import javax.microedition.lcdui.TextField;

/**
 *
 * @author lenovo
 */
class AutorisationForm extends Form implements CommandListener, Runnable {

    TextField tfCarteGrise = new TextField("Carte Grise", null, 50, TextField.NUMERIC);

    Command cmdOk = new Command("OK", Command.SCREEN, 0);

    Command cmdBack = new Command("Back", Command.EXIT, 0);
    Command cmdDeco = new Command("Se Déconnecter", Command.EXIT, 0);

    Image image;
    ImageItem ii;
    HttpConnection hc;
    DataInputStream dis;
    StringBuffer sb;

    String url = "http://localhost/egovmobilee/insert.php?";

    public AutorisationForm() {
        super("Accueil");
        try {
            ii = new ImageItem("", image.createImage("libs/mines.png"), ImageItem.LAYOUT_CENTER, "");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        append(ii);

        append(tfCarteGrise);

        addCommand(cmdOk);

        addCommand(cmdBack);

        setCommandListener(this);
    }

    public void commandAction(Command c, Displayable d) {
        if (c == cmdOk) {
            if (tfCarteGrise.getString().equals("")) {
                Alert al = new Alert("", "SVP Remplire tous lec Champs!", null, AlertType.WARNING);
                Midlet.INSTANCE.disp.setCurrent(al);

            } else {
                Thread th = new Thread(this);
                th.start();
            }
            if (c == cmdBack) {
                Midlet.INSTANCE.disp.setCurrent(new MenuIndus());
            }
            if (c == cmdDeco) {
                Midlet.INSTANCE.disp.setCurrent(new LoginForm(""));
            }
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

        try {
            hc = (HttpConnection) Connector.
                    open(url + "cin=" + Midlet.cin + "&CarteGrise=" + tfCarteGrise.getString());
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
            while ((ascii = dis.read()) != -1) { /* Lir la réponse "kilma = kilma" succflully added */

                sb.append((char) ascii);

            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        if (sb.toString().equals("successfully added")) {
            Alert a = new Alert("Information", sb.toString(), null, AlertType.CONFIRMATION);
            a.setTimeout(3000);
            Midlet.INSTANCE.disp.setCurrent(a);
            try {
                dis.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            try {
                hc.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        } else { //eror
            Alert a = new Alert("Information", sb.toString(), null, AlertType.ERROR);
            a.setTimeout(3000);
            Midlet.INSTANCE.disp.setCurrent(a);
            try {
                dis.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            try {
                hc.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }

}
