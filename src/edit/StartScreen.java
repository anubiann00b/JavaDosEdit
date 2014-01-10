package edit;

import asciiPanel.AsciiPanel;
import java.awt.event.KeyEvent;

public class StartScreen implements Screen {

    public void displayOutput(AsciiPanel terminal) {
        terminal.writeCenter("A DOS Edit clone made in Java.",1);

    }

    public Screen respondToUserInput(KeyEvent key) {
        return this;
    }
}
