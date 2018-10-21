package map;

import egovmobile.Midlet;
import egovmobile.menuextrait;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.List;
import javax.microedition.midlet.MIDlet;


abstract public class GoogleMapsCanvas extends Canvas implements CommandListener {

    Command cmdback = new Command("EXIT", Command.EXIT, 0);

    Displayable testListScreen;
    MIDlet midlet;

    public GoogleMapsCanvas(MIDlet m, Displayable testListScreen) {
        this.midlet = m;
        this.testListScreen = testListScreen;

        addCommand(cmdback = new Command("Back", Command.BACK, 1));

        setCommandListener(this);
    }

    public void commandAction(Command c, Displayable d) {
        if (c == cmdback) {
            // Midlet.INSTANCE.disp.setCurrent(new menuextrait());
           
        }
    }

    void showError(String message) {
        Alert error = new Alert("Error", message, null, AlertType.ERROR);

        Display.getDisplay(midlet).setCurrent(error, this);
    }
}
