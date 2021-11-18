package tictactoe;

public class GameField {
    private final Cell[][] field = new Cell[3][3];

    public GameField() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.field[i][j] = new Cell();
            }
        }
    }

    public Cell getCell(int row, int col) { return field[row][col]; }

    public String getCellValue(int row, int col) { return field[row][col].getValue(); }

    public void setCellValue(int row, int col, String value) { field[row][col].setValue(value);}

    public void printField() {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print((j == 0 ? "| " : "") + field[i][j].getValue() + " " + (j == 2 ? "|\n" : ""));
            }
        }
        System.out.println("---------");
    }
}
