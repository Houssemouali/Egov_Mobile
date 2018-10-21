/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egovmobile;

import egovmobile.Midlet;
import egovmobile.cinDao;
import entities.CinEntities;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.List;

/**
 *
 * @author lenovo
 */
public class Listcin extends List implements CommandListener,Runnable {
     
    Command cmdExit = new Command("Retour", Command.EXIT, 0);

    public Listcin() {
        super("Liste ", List.IMPLICIT);
       
        addCommand(cmdExit);
        setCommandListener(this);
        Thread th = new Thread((Runnable) this);
        th.start();
        
    }

    public void commandAction(Command c, Displayable d) {
       
        if (c == cmdExit) {
           Midlet.INSTANCE.disp.setCurrent(new MenuConnecte());
        }
    }

    public void run() {
        CinEntities[] matches = new cinDao().select();
        if (matches.length > 0) {
            for (int i = 0; i < matches.length; i++) {
               
                append("Id :  "
                        +matches[i].getId()+" n°cin = "+matches[i].getNumcin(), null);
            }
        }
    }

   
}
