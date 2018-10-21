/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egovmobile;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.List;

/**
 *
 * @author Houssem
 */
public class MenuConnecte extends List implements CommandListener {

    Command choisir = new Command("Choisir", Command.SCREEN, 0);
     Command cmdDeco = new Command("Sé Déconnecter", Command.SCREEN, 0);
     Command cmdBack = new Command("Back", Command.BACK, 0);

    public MenuConnecte() {
        super("Menu", List.IMPLICIT);
        append("Demande Carte d'Identité Nationale", null);
        append("Liste Carte d'Identité Nationale", null);
        addCommand(cmdBack);
        addCommand(choisir);
        setCommandListener(this);
    }

    public void commandAction(Command c, Displayable d) {
        if (c == choisir) {
            if (getSelectedIndex() == 0) {
                Midlet.INSTANCE.disp.setCurrent(new CinDemande());
            }
            if (getSelectedIndex() == 1) {
                Midlet.INSTANCE.disp.setCurrent(new Listcin());
            }
        }
//        if (c == cmdDeco) {
//             Midlet.INSTANCE.disp.setCurrent(new LoginForm(null));
//
//        }
         if (c==cmdBack) {
            Midlet.INSTANCE.disp.setCurrent(new MyCanvas());
        }
    }

}
