package gameoflife;

import gameoflife.game.GameOfLife;

public class Launcher {

    public static final int width = 150;
    public static final int height = 100;

    public static void main(String[] args) {
        GameOfLife gameOfLife = new GameOfLife(width, height);
        gameOfLife.start();
    }

}