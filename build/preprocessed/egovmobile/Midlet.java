/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egovmobile;

import entities.CinEntities;
import entities.facturetype;
import java.io.InputStream;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.Display;
import javax.microedition.media.Manager;
import javax.microedition.media.Player;
import javax.microedition.midlet.*;

/**
 * @author USER
 */
public class Midlet extends MIDlet {

    Display disp = Display.getDisplay(this);

    public static Midlet INSTANCE = null;
    public int STEG;
    public int SONEDE;
    public int TOTAL;

    public static int cin;
    
    public void startApp() {
        INSTANCE = this;

//        audio  
        try {
            InputStream in = getClass().getResourceAsStream("/libs/Catch & Release.wav");
            Player player = Manager.createPlayer(in, "audio/x-wav");
            // player.addPlayerListener((PlayerListener) this);
            player.setLoopCount(1);
            player.prefetch();
            player.realize();
            player.start();
        } catch (Exception e) {
            showException(e);
            return;
        }

        disp.setCurrent(new Intro());
        facturetype[] types = new FactureTypeDao().select();
        if (types.length > 0) {
            for (int i = 0; i < types.length; i++) {
                Midlet.INSTANCE.STEG = (types[i].getSTEG());
                Midlet.INSTANCE.SONEDE = types[i].getSONEDE();
                Midlet.INSTANCE.TOTAL = types[i].getTOTAL();

            }
        }
        System.out.println("steg" + STEG);
        // Midlet.INSTANCE.disp.setCurrent(new MenuDemande());

       // disp.setCurrent(new LoginForm());
        //disp.setCurrent(new cinList("Liste CIN",List.IMPLICIT/*,Midlet.INSTANCE.disp*/));
        //disp.setCurrent(new b3List("Liste B3",List.IMPLICIT,Midlet.INSTANCE.disp));
        // Midlet.INSTANCE.disp.setCurrent(new MenuDemande());
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }

    private void showException(Exception e) {
        Alert a = new Alert("Exception", e.toString(), null, null);
        a.setTimeout(Alert.FOREVER);
        //disp.setCurrent(a, mMainScreen);
    }
}
