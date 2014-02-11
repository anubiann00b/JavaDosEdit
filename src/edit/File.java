package edit;

public class File {
    
    private String filename;
    private char[][] text;
    
    public String getFilename() { return filename; }
    
    public char[][] getText() { return text; }
    public char[] getLine(int i) { return text[i]; }
    public char getChar(int i, int j) { return text[i][j]; }
    
    public File(String filename) {
        this.filename = filename;
        text = new char[79][22];
    }
    
    public void writeChar(char c, int i, int j) {
        text[i][j] = c;
    }
}