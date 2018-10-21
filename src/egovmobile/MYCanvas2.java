/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egovmobile;

import javax.microedition.lcdui.*;


/**
 * @author iheb
 */
public class MYCanvas2 extends Canvas implements CommandListener {

        public Display disp ;

     int h = getHeight();
    int w =getWidth();
     Image image;
    Command cmdOk = new Command("OK", Command.SCREEN, 0);
    Command cmdBack = new Command("back", Command.EXIT, 0);
     int x=0;
     int y=0;
    public MYCanvas2() {
       
            super();
    }

    /**
     * paint
     */
    public void paint(Graphics g) {
 g.setColor(255,255,255);
      g.fillRect(0, 0, w, h);
     
      g.setColor(0,0,0);
          g.drawString("ajouter extrait", w/2, h/4, Graphics.BASELINE|Graphics.HCENTER);
           g.drawString("afficher les extrait", w/2, h/2, Graphics.BASELINE|Graphics.HCENTER);
           g.setColor(255,0,0);
     g.drawRect(x, y, w, h/4);
 
    }

    /**
     * Called when a key is pressed.
     */
    protected void keyPressed(int keyCode) {
        int code = getGameAction(keyCode);
       
       
        if (code == DOWN) {
           
            if (y >= 320) {
            } else {
                y = y +100;
                repaint();
            }
        }
        if (code == UP) {
            if (y <= 0) {
            } else {
                y = y - 100;
                repaint();
            }

        }if (code == FIRE) {
            
            
                if (y == 0) {
                   Midlet.INSTANCE.disp.setCurrent(new Ajout_ex());
                   
                   
                }
                if (y == 100) {
Midlet.INSTANCE.disp.setCurrent(new ExtraitForm("Demande Extrait", List.IMPLICIT,disp));                    
                }
                
                   
                }
            
            }

    public void commandAction(Command c, Displayable d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
    

    /**
     * Called when a key is released.
     */
   


    /**
     * Called when a key is repeated (held down).
     */
   
   
