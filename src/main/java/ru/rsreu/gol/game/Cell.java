package ru.rsreu.gol.game;

public class Cell {
    private boolean currentState;
    private boolean newState;

    public Cell() {

    }

    public void setNewState(boolean newState) {
        this.newState = newState;
    }

    public boolean getCurrentState() {
        return this.currentState;
    }

    public void updateState() {
        currentState = newState;
    }

    public boolean isAlive() {
        return currentState;
    }
}
