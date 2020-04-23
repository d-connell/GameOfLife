package gameoflife.game;

public class Cell {

    private boolean isAlive;

    Cell() {
        this.isAlive = false;
    }

    public void setInitialValue() {
        this.isAlive = Math.random() > 0.5;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setIsAlive(boolean newState) {
        this.isAlive = newState;
    }

}