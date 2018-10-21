/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egovmobile;

import java.io.DataInputStream;
import java.io.IOException;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.ImageItem;
import javax.microedition.lcdui.List;
import javax.microedition.lcdui.StringItem;
import javax.microedition.lcdui.TextField;
import javax.microedition.lcdui.Ticker;

/**
 *
 * @author Houssem
 */
public class LoginForm extends Form implements CommandListener, Runnable {

    Command cmdOk = new Command("OK", Command.SCREEN, 0);
    Command cmdinsc = new Command("inscription", Command.SCREEN, 0);
    Command cmdBack = new Command("back", Command.EXIT, 0);
    //Command inscriv = new Command("S'inscrire",Command.SCREEN,0);
    HttpConnection hc;
    DataInputStream dis;
    StringBuffer sb, sb2;
    String login, password;
    ImageItem ii;
    TextField tflogin = new TextField("login", "", 50, TextField.ANY);
    TextField tfpassword = new TextField("mot de passe", "", 50, TextField.PASSWORD);
    Ticker tk = new Ticker("              Meet your makers          ");
    Form loadingDialog = new Form("Please Wait");

    public LoginForm(String title) {
        super(title);
        //super("Accueil");
        Image img = null;
        try {
            img = Image.createImage("/libs/gov.png");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        ii = new ImageItem("", img, ImageItem.LAYOUT_CENTER, "indisponible");
        tflogin.setLayout(TextField.LAYOUT_CENTER);
        tfpassword.setLayout(TextField.LAYOUT_CENTER);
        this.setTicker(tk);
        append(ii);
        append(tflogin);
        append(tfpassword);
        //addCommand(inscriv);
        addCommand(cmdOk);
        addCommand(cmdBack);

        setCommandListener(this);
    }

//     LoginForm(String title) {
//    super(title);
//        Image img = null;
//        try {
//            img = Image.createImage("/egovj2me/gov.png");
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//
//        ii = new ImageItem("", img, ImageItem.LAYOUT_CENTER, "indisponible");
//        append(ii);
//        append(tflogin);
//        append(tfpassword);
//        addCommand(inscriv);
//        addCommand(cmdOk);
//        addCommand(cmdBack);
//        
//        setCommandListener(this);
//    }
//  public LoginForm() {
//        super("Accueil");
//        Image img = null;
//        try {
//            img = Image.createImage("/egovj2me/gov.png");
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//
//        ii = new ImageItem("", img, ImageItem.LAYOUT_CENTER, "indisponible");
//        append(ii);
//        append(tflogin);
//        append(tfpassword);
//        addCommand(inscriv);
//        addCommand(cmdOk);
//        addCommand(cmdBack);
//        
//        setCommandListener(this);
//    }
    public void commandAction(Command c, Displayable d) {
        if (c == cmdOk) {
            /**/
            if (tflogin.getString().equals("") || tfpassword.getString().equals("")) {
                Alert al = new Alert("", "SVP Remplir tous lec Champs!", null, AlertType.WARNING);
                Midlet.INSTANCE.disp.setCurrent(al);

            } else {
                Thread th = new Thread(this);
                th.start();
            }
        }

        if (c == cmdBack) {
            Midlet.INSTANCE.notifyDestroyed();
        }
        //if(c == inscriv)
        //{
        //Midlet.INSTANCE.disp.setCurrent(new ());
        //}
    }

    public void run() {
        sb = new StringBuffer();
        try {
            String strlogin = tflogin.getString();
            String strPassword = tfpassword.getString();
            hc = (HttpConnection) Connector.open("http://localhost/EgovNew/login.php?username=" + strlogin + "&password=" + strPassword);
            dis = new DataInputStream(hc.openDataInputStream());
            int ch;
            while ((ch = dis.read()) != -1) {
                sb.append((char) ch);
            }
            if (sb.toString().equals("OK")) {
                sb2 = new StringBuffer();
                hc = (HttpConnection) Connector.open("http://localhost/EgovNew/getCin.php?login=" + strlogin);
                dis = new DataInputStream(hc.openDataInputStream());
                while ((ch = dis.read()) != -1) {
                    sb2.append((char) ch);
                }
                System.out.println("CIN:" + sb2.toString());
                if (sb2.toString().length()>0) {
                    Midlet.cin = Integer.parseInt(sb2.toString());
                }
                else{Midlet.cin = -1;}
                Midlet.INSTANCE.disp.setCurrent(new MyCanvas());
            } else {
                Midlet.INSTANCE.disp.setCurrent(new Alert("Error", "invalide login ou wamp fermé", null, AlertType.ERROR));
            }
            dis.close();
            hc.close();

        } catch (IOException ex) {
            System.out.println("" + ex.getMessage());
        }

    }

}
