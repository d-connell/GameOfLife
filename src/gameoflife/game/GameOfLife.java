package gameoflife.game;

import gameoflife.output.GameRenderer;

public class GameOfLife {

    private final int blocksWide;
    private final int blocksHigh;
    private final GameRenderer gameRenderer;
    private final Board currentBoard;
    private final Board newBoard;

    public GameOfLife(int blocksWide, int blocksHigh) {
        this.blocksWide = blocksWide;
        this.blocksHigh = blocksHigh;
        this.gameRenderer = new GameRenderer(blocksWide, blocksHigh, "Game Of Life");
        this.currentBoard = new Board(blocksWide, blocksHigh);
        this.currentBoard.setStartValues();
        this.newBoard = new Board(blocksWide, blocksHigh);
    }

    public void start() {
        gameRenderer.display(currentBoard);
        while (true) {
            pause();
            calculateNextBoard();
            copyNextBoardToCurrentBoard();
            gameRenderer.display(currentBoard);
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
            for (int j = 0; j < blocksWide; ++j) {
                int liveNeighbours = currentBoard.countLiveNeighbours(i, j);
                boolean newState = currentBoard.isCellAlive(i, j, liveNeighbours);
                newBoard.setCellState(i, j, newState);
            }
        }
    }

    private void copyNextBoardToCurrentBoard() {
        for (int i = 0; i < blocksHigh; ++i) {
            for (int j = 0; j < blocksWide; ++j) {
                boolean newState = newBoard.getCellState(i, j);
                currentBoard.setCellState(i, j, newState);
            }
        }
    }

}