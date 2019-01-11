package ru.rsreu.gol;

import ru.rsreu.gol.game.Board;
import ru.rsreu.gol.presentation.ConsolePresentation;
import ru.rsreu.gol.presentation.Presentation;

public class Main {
    public static final int GENERATION_COUNT = 10;
    public static final double LIFE_PROBABILITY = 0.2;  //on first generation

    public static void main(String[] args) {
        Presentation presentation = new ConsolePresentation();
        Board board = new Board(10, 10, LIFE_PROBABILITY);

        for (int i = 0; i < GENERATION_COUNT; i++) {
            System.out.println(i + 1 + " generation");
            presentation.showBoard(board);
            board.updateBoard();
        }
    }
}
