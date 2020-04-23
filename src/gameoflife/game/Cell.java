package gameoflife.game;

public class Cell {

    private boolean isAlive;
    private final int horizontalLocation;
    private final int verticalLocation;

    Cell(int horizontalLocation, int verticalLocation) {
        this.isAlive = false;
        this.horizontalLocation = horizontalLocation;
        this.verticalLocation = verticalLocation;
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

    public int getHorizontalLocation() {
        return horizontalLocation;
    }

    public int getVerticalLocation() {
        return verticalLocation;
    }

}