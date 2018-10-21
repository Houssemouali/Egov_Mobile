/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package egovmobile;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.List;
//import map.GoogleMapsMarkerCanvas;

/**
 *
 * @author USER
 */

    
    public class menuextrait extends List implements CommandListener {
         public Display disp ;

    Command choisir = new Command("Choisir", Command.SCREEN, 0);
     Command cmdDeco = new Command("Sé Déconnecter", Command.SCREEN, 0);
     Command cmdBack = new Command("Back", Command.BACK, 0);

    public menuextrait() {
        super("Menu", List.IMPLICIT);
        append("Demande extrait naissance", null);
        append("Afficher demande", null);
         append("map", null);
        addCommand(cmdBack);
        addCommand(choisir);
        setCommandListener(this);
    }

   

    public void commandAction(Command c, Displayable d) {
        if (c == choisir) {
            if (getSelectedIndex() == 0) {
                Midlet.INSTANCE.disp.setCurrent(new Ajout_ex());
            }
            if (getSelectedIndex() == 1) {
               Midlet.INSTANCE.disp.setCurrent(new ExtraitForm("Demande Extrait", List.IMPLICIT,disp));                    

            }
//             if (getSelectedIndex() == 2) {
//               Midlet.INSTANCE.disp.setCurrent(new GoogleMapsMarkerCanvas());                    
//
//            }
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




