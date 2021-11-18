package tictactoe;

import java.util.Scanner;

public class Game {
    private static final Scanner sc = new Scanner(System.in);
    private GameField field;

    public void run() {
        field = new GameField();
        field.printField();

        for (int step = 1; !checkWin("X") && !checkWin("O") && checkStep(step); step++){
            makeNewMove(step % 2 != 0 ? "X" : "O");
            field.printField();
        }
    }

    private void makeNewMove(String value) {
        System.out.print("Enter the coordinates: ");
        try {
            String[] input = sc.nextLine().split(" ");
            int row = Integer.parseInt(input[0]) - 1;
            int col = Integer.parseInt(input[1]) - 1;

            if (!checkCoords(row) || !checkCoords(col)) {
                System.out.println("Coordinates should be from 1 to 3!");
                makeNewMove(value);
            } else if (field.getCell(row, col).isOccupied()) {
                System.out.println("This cell is occupied! Choose another one!");
                makeNewMove(value);
            } else {
                field.setCellValue(row, col, value);
            }
        } catch (Exception e) {
            System.out.println("You should enter numbers!");
            makeNewMove(value);
        }
    }

    private static boolean checkCoords(int coord) { return coord >= 0 && coord <= 2; }

    private boolean checkStep(int step) {
        if (step == 10) {
            System.out.println("Draw");
            return false;
        }
        return true;
    }

    private boolean checkWin(String value) {
        for (int i = 0; i < 3; i++) {
            if (field.getCellValue(i, 0).equals(value)
                    && field.getCellValue(i, 1).equals(value)
                    && field.getCellValue(i, 2).equals(value)) {
                System.out.println(value + " wins");
                return true;
            } else if ((field.getCellValue(0, i).equals(value)
                    && field.getCellValue(1, i).equals(value)
                    && field.getCellValue(2, i).equals(value))) {
                System.out.println(value + " wins");
                return true;
            }
        }
        if (field.getCellValue(0, 0).equals(value)
                && field.getCellValue(1, 1).equals(value)
                && field.getCellValue(2, 2).equals(value)) {
            System.out.println(value + " wins");
            return true;
        }
        if (field.getCellValue(0, 2).equals(value)
                    && field.getCellValue(1, 1).equals(value)
                    && field.getCellValue(2, 0).equals(value)) {
            System.out.println(value + " wins");
            return true;
        }
        return false;
    }
}
