/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egovmobile;

import java.io.DataInputStream;
import java.io.IOException;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.List;

/**
 *
 * @author Houssem
 */
public class MenuCcp extends List implements CommandListener {

    Command choisir = new Command("Choisir", Command.SCREEN, 0);
    Command cmdDeco = new Command("Sé Déconnecter", Command.SCREEN, 0);
    Command cmdBack = new Command("Back", Command.BACK, 0);

    public MenuCcp() {
        super("Menu", List.IMPLICIT);
        append("Demande Compte Courant Postale", null);
        append("Send Sms", null);
        append("Voir Solde", null);
        addCommand(cmdBack);
        addCommand(choisir);
        setCommandListener(this);
    }

    public void commandAction(Command c, Displayable d) {
        if (c == choisir) {
            if (getSelectedIndex() == 0) {
                Alert a = new Alert("Votre demande a etait deposer");
                try {
                    //date = date.trim();
                    
                    HttpConnection hc = (HttpConnection) Connector.
                            open("http://localhost/EgovNew/insertccp.php?cin="+Midlet.cin);
                    DataInputStream dis = new DataInputStream(hc.openDataInputStream());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                Midlet.INSTANCE.disp.setCurrent(a);
            }
            if (getSelectedIndex() == 1) {
                Alert a = new Alert("Votre SMS a etait envoyer");
                Midlet.INSTANCE.disp.setCurrent(a);
                Midlet.INSTANCE.disp.setCurrent(new sendSMS());
            }
            if (getSelectedIndex() == 2) {
                Midlet.INSTANCE.disp.setCurrent(new VoirSolde());
            }
        }
//        if (c == cmdDeco) {
//             Midlet.INSTANCE.disp.setCurrent(new LoginForm(null));
//
//        }
        if (c == cmdBack) {
            Midlet.INSTANCE.disp.setCurrent(new MyCanvas());
        }
    }

}
