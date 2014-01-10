package edit;

public class MenuOption {
    
    private String name;
    private int spaces;
    
    public String getName() { return name; }
    public int spaces() { return spaces; }
    
    public MenuOption(String name) {
        this(name,3);
    }
    
    public MenuOption(String name, int spaces) {
        this.name = name;
        this.spaces = spaces;
    }
}