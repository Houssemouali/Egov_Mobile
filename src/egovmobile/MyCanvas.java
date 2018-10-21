/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egovmobile;

import java.io.IOException;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.List;

/**
 *
 * @author lenovo
 */
class MyCanvas extends Canvas {

    public Display disp;
    int h = getHeight();
    int w = getWidth();
    Image image;
    Command cmdOk = new Command("OK", Command.SCREEN, 0);
    Command cmdBack = new Command("back", Command.EXIT, 0);
    int x = 0;
    int y = 0;

    public MyCanvas() {
        super();

        try {
            image = Image.createImage("libs/menu.png");

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    protected void paint(Graphics g) {

        g.setColor(0, 0, 0);
        g.drawImage(image, w / 2, h / 2,
                Graphics.HCENTER | Graphics.VCENTER);
        /*g.drawString("TUN254", w/2,h/6, Graphics.BASELINE|Graphics.HCENTER);
         g.drawString("TUN254", w/2, h/2, Graphics.BASELINE|Graphics.HCENTER);
         g.drawString("TUN254", w/2, h-h/6, Graphics.BASELINE|Graphics.HCENTER);*/
        g.setColor(255, 0, 0);
        g.drawRect(x, y, w, h / 4);

    }

    protected void keyPressed(int keyCode) {
        int code = getGameAction(keyCode);

        if (code == DOWN) {

            if (y >= 320) {
            } else {
                y = y + 80;
                repaint();
            }
        }
        if (code == UP) {
            if (y <= 0) {
            } else {
                y = y - 80;
                repaint();
            }

        }
        if (code == FIRE) {

            if (y == 0) {

                Midlet.INSTANCE.disp.setCurrent(new MenuConnecte());

            }
            if (y == 80) {
                     //Midlet.INSTANCE.disp.setCurrent(new Ajout_ex());
                // Midlet.INSTANCE.disp.setCurrent(new ExtraitForm("Demande Extrait", List.IMPLICIT,disp));        
                Midlet.INSTANCE.disp.setCurrent(new menuextrait());

            }
            if (y == 160) {
                Midlet.INSTANCE.disp.setCurrent(new MenuIndus());
            }
            if (y == 240) {
                if (Midlet.cin != -1) {
                    Midlet.INSTANCE.disp.setCurrent(new MenuCcp());
                }
                else
                {
                    Alert a = new Alert("Vous n'avez pas de cin, vous ne pas demander de compte courant postale");
                    Midlet.INSTANCE.disp.setCurrent(a);
                }

            }

        }
    }

}
