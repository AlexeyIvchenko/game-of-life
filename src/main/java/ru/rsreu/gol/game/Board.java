package ru.rsreu.gol.game;

import java.util.Random;

public class Board {
    private Cell[][] matrix;
    private double probability;

    public Board(int width, int height, double probability) {
        this.matrix = new Cell[width][height];
        this.probability = probability;
        initCellsOnBoard();
    }

    private void initCellsOnBoard() {
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[i].length; j++) {
                matrix[i][j] = new Cell();
                matrix[i][j].setNewState(myRandom(probability));
                matrix[i][j].updateState();
            }
        }
    }

    private boolean myRandom(double probability) {
        Random random = new Random();
        return random.nextDouble() < probability;
    }

    public Cell[][] getMatrix() {
        return matrix;
    }

    private int countNeighbours(int x, int y) {
        int neighboursCount = 0;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (x == i && y == j) continue;
                else {
                    if (getCell(i, j).isAlive()) neighboursCount++;
                }
            }
        }
        return neighboursCount;
    }
    //with tor
    private Cell getCell(int x, int y) {
        int newX = x;
        int newY = y;
        if (x < 0 || x >= matrix.length) {
            newX = matrix.length - Math.abs(x);
        }
        if (y < 0 || y >= matrix[0].length) {
            newY = matrix[0].length - Math.abs(y);
        }
        return matrix[newX][newY];
    }

    private void createNextGenerationByRules() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int neighboursCount = countNeighbours(i, j);

                if (getCell(i, j).isAlive()) {
                    getCell(i, j).setNewState(neighboursCount == 2 || neighboursCount == 3);
                } else {
                    getCell(i, j).setNewState(neighboursCount == 3);
                }
            }
        }
    }

    private void updateGeneration() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                getCell(i, j).updateState();
            }
        }
    }

    public void updateBoard() {
        createNextGenerationByRules();
        updateGeneration();
    }
}
