/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egovmobile;

import entities.autorisation;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.List;

/**
 *
 * @author lenovo
 */
public class ListAuto extends List implements CommandListener,Runnable {
     
    Command cmdExit = new Command("Back", Command.EXIT, 0);
    Command cmdRefresh = new Command("refresh", Command.SCREEN, 0);

    public ListAuto() {
        super("Liste ", List.IMPLICIT);
       
        addCommand(cmdExit);
        setCommandListener(this);
        Thread th = new Thread((Runnable) this);
        th.start();
        
    }

    public void commandAction(Command c, Displayable d) {
        if (c == cmdRefresh) {
           
            Thread th = new Thread(this);
            th.start();
        }
       
        if (c == cmdExit) {
         Midlet.INSTANCE.disp.setCurrent(new MenuIndus());

        }
    }

    public void run() {
        autorisation[] matches = new AutoDao().select();
        if (matches.length > 0) {
            for (int i = 0; i < matches.length; i++) {
               
                append("N°Autorisation : "+matches[i].getId()+" CIN = "+matches[i].getcin(), null);
            }
        }
    }

   
}
