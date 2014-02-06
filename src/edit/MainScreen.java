package edit;

import asciiPanel.AsciiPanel;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class MainScreen implements Screen {
        
    private static final Color BLUE = AsciiPanel.blue;
    private static final Color GREY = AsciiPanel.white;
    private static final Color BLACK = AsciiPanel.black;
    private static final Color WHITE = AsciiPanel.brightWhite;
    private static final Color TURQUOISE = AsciiPanel.cyan;
    
    private ArrayList<MenuOption> menuOptions = new ArrayList<MenuOption>();
    private File currentFile;
    private int cursorX = 1;
    private int cursorY = 1;
    
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
        terminal.clear(' ',GREY,BLUE);
        displayMenuBar(terminal);
        displayBorder(terminal);
        displayScrollBars(terminal);
        displayStatusBar(terminal);
        terminal.writeCenter("A DOS Edit clone made in Java.",5,GREY,BLUE);
    }
    
    private void displayMenuBar(AsciiPanel terminal) {
        terminal.setCursorPosition(0,0);
        for (MenuOption o : menuOptions) {
            for (int i=0;i<o.spaces();i++)
                terminal.write(' ',BLACK,GREY);
            terminal.write(o.getName(),BLACK,GREY);
        }
        for (int i=0;i<3;i++)
            terminal.write(' ',77+i,0,BLACK,GREY);
    }
    
    private void displayBorder(AsciiPanel terminal) {
        
        // Top left corner
        terminal.write((char)218,0,1,GREY,BLUE);
        
        // Top
        for(int i=1;i<79;i++)
            terminal.write((char)196,i,1,GREY,BLUE);
        
        // Top right corner
        terminal.write((char)191,79,1,GREY,BLUE);
        
        // Left
        for (int i=2;i<23;i++)
            terminal.write((char)179,0,i,GREY,BLUE);
        
        // Bottom right
        terminal.write((char)179,79,22,GREY,BLUE);
    }
    
    private void displayScrollBars(AsciiPanel terminal) {
        
        // Fill bg color
        terminal.clear(' ',0,23,80,1,BLACK,TURQUOISE);
        
        // Side bottom arrow
        terminal.write((char)25,79,21,BLACK,GREY);
        
        // Side top arrow
        terminal.write((char)24,79,2,BLACK,GREY);
        
        // Side bar
        for (int i=3;i<21;i++)
            terminal.write((char)177,79,i,BLACK,GREY);
        
        // Bottom left arrow
        terminal.write((char)27,1,22,BLACK,GREY);
        
        // Bottom right arrow
        terminal.write((char)26,78,22,BLACK,GREY);
        
        // Bottom bar
        for(int i=2;i<78;i++)
            terminal.write((char)177,i,22,BLACK,GREY);
    }
    private void displayStatusBar(AsciiPanel terminal) {
        terminal.write(" Text Editor  (F1=Help) Press ALT to activate menus           ",0,23,WHITE,TURQUOISE);
        
        // Vertical bar.
        terminal.write((char)179,62,23,BLACK, TURQUOISE);
        
        // Cursor position.
        terminal.write(String.format("%05d", cursorX) + ":" + String.format("%03d", cursorY),70,23,BLACK,TURQUOISE);
    }
    
    @Override
    public Screen respondToUserInput(KeyEvent key) {
        return this;
    }
}

/*
 * 24: Up arrow
 * 25: Down arraw
 * 26: Right arrow
 * 27: Left arrow
 * http://everything2.com/title/CP437
 */