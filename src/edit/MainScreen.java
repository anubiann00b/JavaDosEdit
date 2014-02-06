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
        menuOptions.add(new MenuOption("Help",40));
    }
    
    @Override
    public void displayOutput(AsciiPanel terminal) {
        displayMenuBar(terminal);
        terminal.writeCenter("A DOS Edit clone made in Java.",5);
    }
    
    private void displayMenuBar(AsciiPanel terminal) {
        terminal.setCursorPosition(0,0);
        for (MenuOption o : menuOptions) {
            for (int i=0;i<o.spaces();i++)
                terminal.write(' ',AsciiPanel.black,AsciiPanel.white);
            terminal.write(o.getName(),AsciiPanel.black,AsciiPanel.white);
        }
        for (int i=0;i<3;i++)
            terminal.write(' ',77+i,0,AsciiPanel.black,AsciiPanel.white);
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        return this;
    }
}
