package edit;

import asciiPanel.AsciiPanel;
import java.awt.event.KeyEvent;

public class MainScreen implements Screen {
    
    public MainScreen() {
        
    }
    
    public void displayOutput(AsciiPanel terminal) {
        terminal.write("   ",0,0,AsciiPanel.black,AsciiPanel.white);
        terminal.write("File",3,0,AsciiPanel.black,AsciiPanel.white);
        terminal.writeCenter("A DOS Edit clone made in Java.",1);
    }

    public Screen respondToUserInput(KeyEvent key) {
        return this;
    }
}
