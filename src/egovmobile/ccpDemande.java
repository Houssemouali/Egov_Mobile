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
public class ccpDemande extends Form implements CommandListener, Runnable {

    TextField tfnumcp = new TextField("n°compte", "", 11, TextField.NUMERIC);
    TextField tfcin = new TextField("cin", "", 20, TextField.ANY);
    TextField tfmontant = new TextField("montant", "", 20, TextField.NUMERIC);
    
Command cmdOk = new Command("OK", Command.SCREEN, 0);
Command cmdBack = new Command("Back", Command.BACK, 0);
    Image image;
    ImageItem ii;
    HttpConnection hc;
    DataInputStream dis;
    StringBuffer sb;
    String url = "http://localhost/egovmobilee/insertccp.php?";
    public ccpDemande() {
        super("Demande de Ccp");
        Image img = null;
        try {
            img = Image.createImage("/libs/cpp.jpg");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        ii = new ImageItem("", img, ImageItem.LAYOUT_CENTER, "indisponible");

        append(ii);
        append(tfnumcp);
        append(tfcin);
        append(tfmontant);

        addCommand(cmdOk);
        addCommand(cmdBack);
        setCommandListener(this);
    }

    public void commandAction(Command c, Displayable d) {
        if (c == cmdOk) {
            if ((tfnumcp.getString().equals("")) || (tfcin.getString().equals("")) /*||(datenaiss.getDate().equals("000 00,0000"))*/
                    || (tfmontant.getString().equals(""))
                     ) {
                Alert al = new Alert("", "SVP Remplire tous lec Champs!", null, AlertType.WARNING);
                Midlet.INSTANCE.disp.setCurrent(al);

            } else {
                Thread th = new Thread(this);
                th.start();
            }
        }
        if (c == cmdBack) {
            Midlet.INSTANCE.disp.setCurrent(new MenuCcp());
        }
    }

    public void run() {
           try {
           //date = date.trim();
            hc = (HttpConnection) Connector.
                    open(url + "num_compte=" +tfnumcp.getString() + "&cin=" + (tfcin.getString()) + "&montant=" 
                            + Integer.parseInt(tfmontant.getString())  );
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

        if (sb.toString().equals("cpp ajouté avec succés")) {
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
