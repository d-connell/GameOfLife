package gameoflife.output;

import gameoflife.game.Board;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class GameRenderer {

    private final int blocksWide;
    private final int blocksHigh;
    private final Display display;
    private final int cellSize = 5;

    public GameRenderer(int blocksWide, int blocksHigh, String title) {
        this.blocksWide = blocksWide;
        this.blocksHigh = blocksHigh;
        this.display = new Display(blocksWide * cellSize, blocksHigh * cellSize, title);
    }

    public void display(Board board) {
        display.getCanvas().createBufferStrategy(2);
        BufferStrategy bufferStrategy = display.getCanvas().getBufferStrategy();
        Graphics graphics = bufferStrategy.getDrawGraphics();
        graphics.clearRect(0, 0, blocksWide * cellSize, blocksHigh * cellSize);
        displayBoard(graphics, board);
        graphics.dispose();
        bufferStrategy.show();
    }

    private void displayBoard(Graphics graphics, Board board) {
        for (int i = 0; i < blocksHigh; ++i) {
            for (int j = 0; j < blocksWide; ++j) {
                graphics.setColor(board.getCellState(i, j) ? Color.BLACK : Color.WHITE);
                graphics.fillRect(j * cellSize, i * cellSize, cellSize, cellSize);
            }
        }
    }

}