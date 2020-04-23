package gameoflife.game;

public class Board {

    private final int blocksWide;
    private final int blocksHigh;
    private final Cell[][] cells;

    public Board(int blocksWide, int blocksHigh) {
        this.blocksWide = blocksWide;
        this.blocksHigh = blocksHigh;
        this.cells = new Cell[blocksHigh][blocksWide];
        createCells();
    }

    private void createCells() {
        for (int i = 0; i < blocksHigh; ++i) {
            for (int j = 0; j < blocksWide; ++j) {
                cells[i][j] = new Cell();
            }
        }
    }

    public void setStartValues() {
        for (int i = 0; i < blocksHigh; ++i) {
            for (int j = 0; j < blocksWide; ++j) {
                cells[i][j].setInitialValue();
            }
        }
    }

    public int countLiveNeighbours(int verticalPosition, int horizontalPosition) {
        int liveNeighbours = 0;

        int columnToCheck = horizontalPosition - 1;
        if (columnToCheck >= 0 && columnToCheck < blocksWide) {
            liveNeighbours = checkRows(columnToCheck, verticalPosition, liveNeighbours, 1);
        }

        columnToCheck = horizontalPosition;
        // middle cell of this column is the active cell so do not check it, interval increased to 2
        if (columnToCheck >= 0 && columnToCheck < blocksWide) {
            liveNeighbours = checkRows(columnToCheck, verticalPosition, liveNeighbours, 2);
        }

        columnToCheck = horizontalPosition + 1;
        if (columnToCheck >= 0 && columnToCheck < blocksWide) {
            liveNeighbours = checkRows(columnToCheck, verticalPosition, liveNeighbours, 1);

        }
        return liveNeighbours;
    }

    public int checkRows(int columnToCheck, int verticalPosition, int liveNeighbours, int interval) {
        for (int i = verticalPosition - 1; i <= verticalPosition + 1; i += interval) {
            if (i >= 0 && i < blocksHigh) {
                liveNeighbours = cells[i][columnToCheck].isAlive() ? ++liveNeighbours : liveNeighbours;
            }
        }
        return liveNeighbours;
    }

    public boolean isCellAlive(int verticalPosition, int horizontalPosition, int liveNeighbours) {
        if (cells[verticalPosition][horizontalPosition].isAlive()) {
            switch (liveNeighbours) {
                case 2:
                case 3: {
                    return true;
                }
                default: {
                    return false;
                }
            }
        }
        return liveNeighbours == 3;
    }

    public void setCellState(int verticalPosition, int horizontalPosition, boolean newState) {
        cells[verticalPosition][horizontalPosition].setIsAlive(newState);
    }

    public boolean getCellState(int verticalPosition, int horizontalPosition) {
        return cells[verticalPosition][horizontalPosition].isAlive();
    }

}