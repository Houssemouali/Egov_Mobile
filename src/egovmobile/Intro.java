/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egovmobile;

import java.io.IOException;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

/**
 *
 * @author Houssem
 */
public class Intro extends Canvas implements Runnable {

     private Image mImage;
    
    
      public Intro(){
       
        try{
        mImage = Image.createImage("/libs/logome.png");

        Thread t = new Thread(this);
        t.start();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        
    }
     
    protected void paint(Graphics g) {
       int width = getWidth();
        int height = getHeight();

        //set background color to overdraw what ever was previously displayed
        g.setColor(0x000000);
        g.fillRect(0,0, width, height);
        g.drawImage(mImage, width/2 , height/2 ,
                Graphics.HCENTER | Graphics.VCENTER);
    }

    public void exitSplash() {
         //Midlet.INSTANCE.disp.setCurrent(new LoginForm("authentification"));
        
        Midlet.INSTANCE.disp.setCurrent(new LoginForm("authentification"));
    }

//public void run() {
//while(true) {
//    int imgIndex = 0;
//imgIndex++;
//imgIndex%=3;
//try {
//Thread.sleep(500);
//}catch(Exception e){}
//}

    public void run() {
        try {
            Thread.sleep(2000);//set for 3 seconds
        }
        catch (InterruptedException e) {
            System.out.println("InterruptedException");
            e.printStackTrace();
        }
        if (Thread.currentThread().isAlive())
        exitSplash();
    }

    /**
     * A key release event triggers the exitSplash()
     * method to be called.
     */
    public void keyReleased(int keyCode) {
        exitSplash();
    }

    /**
     * A pointer release event triggers the exitSplash()
     * method to be called.
     */
    public void pointerReleased(int x, int y) {
       exitSplash();
    }
    
}
