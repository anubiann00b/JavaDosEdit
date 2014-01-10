package edit;

import asciiPanel.AsciiPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

public class ApplicationMain extends JFrame implements KeyListener {
    
    private AsciiPanel terminal;
    private Screen screen;
    
    public final int CSL_WIDTH=80;
    public final int CSL_HEIGHT=24;
    
    public ApplicationMain() {
        super();
        terminal = new AsciiPanel(CSL_WIDTH,CSL_HEIGHT);
        add(terminal);
        pack();
        screen = new MainScreen();
        addKeyListener(this);
        repaint();
    }
    
    @Override
    public void repaint() {
        terminal.clear();
        screen.displayOutput(terminal);
        super.repaint();
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        screen = screen.respondToUserInput(e);
        repaint();
    }
    
    @Override
    public void keyTyped(KeyEvent e) { }



    @Override
    public void keyReleased(KeyEvent e) { }
    
    public static void main(String[] args) {
        ApplicationMain app = new ApplicationMain();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
        app.setTitle("Edit");
    }
}