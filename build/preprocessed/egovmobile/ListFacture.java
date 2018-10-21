/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egovmobile;

import entities.facture;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.List;

/**
 *
 * @author lenovo
 */
public class ListFacture extends List implements CommandListener,Runnable {
     Command cmdExit = new Command("Back", Command.BACK, 0);
      Command cmdRefresh = new Command("Refresh", Command.SCREEN,0);
       Command cmdDeco = new Command("Se Déconnecter", Command.BACK, 0);
      public ListFacture() {
        super("Liste ", List.IMPLICIT);
       
        addCommand(cmdExit);
        setCommandListener(this);
        Thread th = new Thread(this);
        th.start();
        
    }
      public void commandAction(Command c, Displayable d) {
            if (c == cmdRefresh) {
           
            Thread th = new Thread(this);
            th.start();
        }
       
        if (c == cmdExit) {
                       Midlet.INSTANCE.disp.setCurrent(new LoginForm(null));

        }
        if (c == cmdDeco) {
                       Midlet.INSTANCE.disp.setCurrent(new LoginForm(null));

        }
    }

    public void run() {
        facture[] matches = new FactureDao().select();
        if (matches.length > 0) {
            for (int i = 0; i < matches.length; i++) {
               
                append("N°Facture : "+matches[i].getId()+" cin = "+matches[i].getcin(), null);
            }
        }
    }
}
