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
public class VoirSolde extends List implements CommandListener {

    Command cmdDeco = new Command("Sé Déconnecter", Command.SCREEN, 0);
    Command cmdBack = new Command("Back", Command.BACK, 0);

    public VoirSolde() {
        super("Menu", List.IMPLICIT);
        
        StringBuffer sb2 = new StringBuffer();
        HttpConnection hc;
        try {
            hc = (HttpConnection) Connector.open("http://localhost/EgovNew/getSolde.php?cin=" + Midlet.cin);
            DataInputStream dis = new DataInputStream(hc.openDataInputStream());
            int ch;
            while ((ch = dis.read()) != -1) {
                sb2.append((char) ch);
            }
            append("Votre Solde est:", null);
            append(sb2.toString(), null);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        addCommand(cmdBack);
        setCommandListener(this);
    }

    public void commandAction(Command c, Displayable d) {

//        if (c == cmdDeco) {
//             Midlet.INSTANCE.disp.setCurrent(new LoginForm(null));
//
//        }
        if (c == cmdBack) {
            Midlet.INSTANCE.disp.setCurrent(new MenuCcp());
        }
    }

}
