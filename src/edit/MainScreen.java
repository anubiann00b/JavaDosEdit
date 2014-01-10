package edit;

import asciiPanel.AsciiPanel;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class MainScreen implements Screen {
    
    ArrayList<MenuOption> menuOptions = new ArrayList<MenuOption>();
    
    public MainScreen() {
        menuOptions.add(new MenuOption("File"));
        menuOptions.add(new MenuOption("Edit"));
        menuOptions.add(new MenuOption("Search"));
        menuOptions.add(new MenuOption("Options"));

    }
    
    public void displayOutput(AsciiPanel terminal) {
        displayMenuBar(terminal);
        terminal.writeCenter("A DOS Edit clone made in Java.",5);
    }
    
    private void displayMenuBar(AsciiPanel terminal) {
        terminal.setCursorPosition(0,0);
        for (MenuOption o : menuOptions) {
            terminal.write("   ",AsciiPanel.black,AsciiPanel.white);
            terminal.write(o.getName(),AsciiPanel.black,AsciiPanel.white);
        }
        while (terminal.getCursorX()<terminal.getWidthInCharacters()-1)
            terminal.write(" ",AsciiPanel.black,AsciiPanel.white);
    }

    public Screen respondToUserInput(KeyEvent key) {
        return this;
    }
}
