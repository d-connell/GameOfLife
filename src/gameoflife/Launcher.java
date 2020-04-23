package gameoflife;

import gameoflife.game.GameOfLife;

public class Launcher {

    public static void main(String[] args) {
        GameOfLife gameOfLife = new GameOfLife(100, 100);
        gameOfLife.start();
    }

}