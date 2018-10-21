/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egovmobile;

import entities.facturetype;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;


import javax.microedition.lcdui.Graphics;

/**
 *
 * @author lenovo
 */
public class PieChart extends Canvas implements CommandListener,Runnable  {
    int STEGG =Midlet.INSTANCE.STEG;
    int SONEDEE=Midlet.INSTANCE.SONEDE;
    int TOTALL=Midlet.INSTANCE.TOTAL;
    String STEGPERCENT;
    String SONEDEPERCENT;
    int[] data = { ((STEGG*100)/TOTALL)+10,((SONEDEE*100)/TOTALL)+10 };
    Command cmdOk = new Command("OK", Command.SCREEN, 0);
    
    Command cmdBack = new Command("Back", Command.EXIT, 0);
    int colors[] = { 0xFF0000, 0xA9E969 };

   
    

public PieChart() {
    super();
        this.STEGPERCENT = ""+((STEGG*100)/TOTALL);
         this.SONEDEPERCENT = ""+((SONEDEE*100)/TOTALL);
   
    addCommand(cmdBack);
    setCommandListener(this);
    Thread th = new Thread((Runnable) this);
    th.start();
  }
    
    public void paint(Graphics g) {
    int width = this.getWidth();
    int height = this.getHeight();

    g.setColor(255, 255, 255);
    g.fillRect(0, 0, width, height);

    int sum = 0;
    for (int i = 0; i < data.length; i++) {
      sum += data[i];
    }
    int deltaAngle = 360 * 100 / sum / 100;
    int x = 4;
    int y = 4;
    int diameter;

    if (width > height)
      diameter = height - y * 2;
    else
      diameter = width - x * 2;

    int startAngle = 0;

    for (int i = 0; i < data.length; i++) {
      g.setColor(colors[i]);
      g.fillArc(x, y, diameter, diameter, startAngle, deltaAngle * data[i]);
      startAngle += deltaAngle * data[i];
    }
    g.setColor(0xFF0000);
     g.drawString("STEG "+STEGPERCENT+"% ", width/2, height-height/9, Graphics.BASELINE|Graphics.HCENTER);
      g.setColor(0x00C400);
      g.drawString("SONEDE "+SONEDEPERCENT+"% ", width/2, height-height/15, Graphics.BASELINE|Graphics.HCENTER);
  }

    public void commandAction(Command c, Displayable d) {
     
      if (c==cmdBack) {
            Midlet.INSTANCE.disp.setCurrent(new MyCanvas());
        }
    }

    public void run() {
        facturetype[] types = new FactureTypeDao().select();
        if (types.length > 0) {
            for (int i = 0; i < types.length; i++) {
                 Midlet.INSTANCE.STEG=(types[i].getSTEG());
                 Midlet.INSTANCE.SONEDE=types[i].getSONEDE();
                 Midlet.INSTANCE.TOTAL=types[i].getTOTAL();
               
                
            }
        }
    }

    

   
    
}

   
    

