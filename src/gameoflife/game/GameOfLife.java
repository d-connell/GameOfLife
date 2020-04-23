package gameoflife.game;

import gameoflife.output.GameRenderer;

public class GameOfLife {

    private final int blocksWide;
    private final int blocksHigh;
    private final GameRenderer gameRenderer;
    private final Board[] boards;

    public GameOfLife(int blocksWide, int blocksHigh) {
        this.blocksWide = blocksWide;
        this.blocksHigh = blocksHigh;
        this.gameRenderer = new GameRenderer(blocksWide, blocksHigh, "Game Of Life");
        this.boards = new Board[2];
        this.boards[0] = new Board(blocksWide, blocksHigh);
        this.boards[0].setStartValues();
        this.boards[1] = new Board(blocksWide, blocksHigh);
    }

    public void start() {
        gameRenderer.display(boards[0]);
        while (true) {
            pause();
            calculateNextBoard();
            copyNextBoardToCurrentBoard();
            gameRenderer.display(boards[0]);
        }
    }

    private void pause() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void calculateNextBoard() {
        for (int i = 0; i < blocksHigh; ++i) {
            for (int j = 0; j < blocksHigh; ++j) {
                int liveNeighbours = boards[0].countLiveNeighbours(i, j);
                boolean newState = boards[0].isCellAlive(i, j, liveNeighbours);
                boards[1].setCellState(i, j, newState);
            }
        }
    }

    private void copyNextBoardToCurrentBoard() {
        for (int i = 0; i < blocksHigh; ++i) {
            for (int j = 0; j < blocksWide; ++j) {
                boolean newState = boards[1].getCellState(i, j);
                boards[0].setCellState(i, j, newState);
            }
        }
    }

}