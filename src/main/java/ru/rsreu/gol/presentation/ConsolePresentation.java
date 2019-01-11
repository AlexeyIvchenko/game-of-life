package ru.rsreu.gol.presentation;

import ru.rsreu.gol.game.Board;
import ru.rsreu.gol.game.Cell;

public class ConsolePresentation implements Presentation {

    public void showBoard(Board board) {
        Cell[][] matrix = board.getMatrix();
        String border = " ";
        for (int i = 0; i < matrix[0].length; i++) {
            border += "-";
        }

        System.out.println(border);

        for (Cell[] row : matrix) {
            String r = "|";
            for (Cell c : row) {
                r += c.getCurrentState() ? "*" : " ";
            }
            r += "|";
            System.out.println(r);
        }
        System.out.println(border);
    }
}
