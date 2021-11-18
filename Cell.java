package tictactoe;

public class Cell {
    private String value;

    Cell() { this.value = " "; }

    public String getValue() { return value; }

    public void setValue(String s) { this.value = s; }

    public boolean isOccupied() { return !" ".equals(value); }
}
