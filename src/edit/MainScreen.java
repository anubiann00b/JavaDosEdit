package edit;

import asciiPanel.AsciiPanel;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class MainScreen implements Screen {
    
    ArrayList<MenuOption> menuOptions = new ArrayList<MenuOption>();
    File currentFile;
    
    public MainScreen() {
        menuOptions.add(new MenuOption("File"));
        menuOptions.add(new MenuOption("Edit"));
        menuOptions.add(new MenuOption("Search"));
        menuOptions.add(new MenuOption("Options"));
        menuOptions.add(new MenuOption("Help",40));
        currentFile = new File("New File");
    }
    
    @Override
    public void displayOutput(AsciiPanel terminal) {
        displayMenuBar(terminal);
        displayBorder(terminal);
        displayScrollBars(terminal);
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
    
    private void displayBorder(AsciiPanel terminal) {
        terminal.write((char)218,0,1,AsciiPanel.white,AsciiPanel.brightBlue);
        for(int i=1;i<79;i++)
            terminal.write((char)196,i,1,AsciiPanel.white,AsciiPanel.brightBlue);
        terminal.write((char)191,79,1,AsciiPanel.white,AsciiPanel.brightBlue);
        for (int i=2;i<23;i++)
            terminal.write((char)179,0,i,AsciiPanel.white,AsciiPanel.brightBlue);
        terminal.write((char)179,79,23,AsciiPanel.white,AsciiPanel.brightBlue);
    }
    
    private void displayScrollBars(AsciiPanel terminal) {
        terminal.write(' ',2,22,AsciiPanel.white,AsciiPanel.brightBlue);
    }

    @Override
    public Screen respondToUserInput(KeyEvent key) {
        return this;
    }
}
