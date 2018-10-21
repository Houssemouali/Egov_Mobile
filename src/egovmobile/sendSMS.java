/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egovmobile;

import javax.microedition.io.Connector;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.TextField;
import javax.wireless.messaging.MessageConnection;
import javax.wireless.messaging.TextMessage;

/**
 *
 * @author USER
 */
public class sendSMS extends Form implements CommandListener, Runnable {

    MessageConnection clientConn;
    TextField tftowho = new TextField("numero tel ", "", 11, TextField.NUMERIC);
    TextField tfcontent = new TextField("le message", " ", 200, TextField.ANY);
    Command cmdOk = new Command("OK", Command.SCREEN, 0);
    Alert alert;

    public sendSMS() {
        
        super("Envoyer message");
        append(tftowho);
        append(tfcontent);

        addCommand(cmdOk);
        setCommandListener(this);

    }

    public void commandAction(Command c, Displayable d) {
        if (c == cmdOk) {

            Alert alert = new Alert("Votre SMS a etait envoyer");
            Midlet.INSTANCE.disp.setCurrent(alert);
//            Thread th = new Thread(this);
//            th.start();

            
        }

    }

    public void run() {
        String mno = tftowho.getString();
        String msg = tfcontent.getString();
        try {
            clientConn = (MessageConnection) Connector.open("sms://" + mno);

        } catch (Exception e) {

        }
        try {

            TextMessage textmessage = (TextMessage) clientConn.newMessage(MessageConnection.TEXT_MESSAGE);
            textmessage.setAddress("sms://" + mno);
            textmessage.setPayloadText(msg);
            clientConn.send(textmessage);
        } catch (Exception e) {

            alert = new Alert("Alert");
            alert.setString("Unable to connect to Station because of network problem");
            alert.setTimeout(2000);
            Midlet.INSTANCE.disp.setCurrent(alert);

        }

    }

}
