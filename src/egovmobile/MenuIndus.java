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
 * @author lenovo
 */
public class MenuIndus extends List implements CommandListener {

    Command choisir = new Command("Choisir", Command.SCREEN, 0);
    Command CmdDeco = new Command("Se Déconnecter", Command.BACK, 0);
    Command cmdBack = new Command("Back", Command.BACK, 0);
    

    public MenuIndus() {
        super("Menu", List.IMPLICIT);
        append("Ajouter Autorisation", null);
         append("List Des Autorisations", null);
          append("Ajouter Facture", null);
           append("List Des Factures", null);
        append("Voir les Statistiques Des Factures", null);
        addCommand(choisir);
        addCommand(cmdBack);
        addCommand(CmdDeco);
        setCommandListener(this);
    }

    public void commandAction(Command c, Displayable d) {
        if (c == CmdDeco) {
                       Midlet.INSTANCE.disp.setCurrent(new LoginForm(null));

        }
        if (c == cmdBack) {
            Midlet.INSTANCE.disp.setCurrent(new MyCanvas());
        }
        if (c == choisir) {
            if (getSelectedIndex() == 0) {
                Midlet.INSTANCE.disp.setCurrent(new AutorisationForm());
            }
            if (getSelectedIndex() == 1) {
                Midlet.INSTANCE.disp.setCurrent(new ListAuto());
            }
            if (getSelectedIndex() == 2) {
                Midlet.INSTANCE.disp.setCurrent(new FactureForm());
            }
            if (getSelectedIndex() == 3) {
                Midlet.INSTANCE.disp.setCurrent(new ListFacture());
            }
            if (getSelectedIndex() == 4) {
                Midlet.INSTANCE.disp.setCurrent(new PieChart());
            }
        }
        
    }

}