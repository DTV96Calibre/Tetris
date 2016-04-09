/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.model;

/**
 *
 * @author Daniel Vasquez
 */
public class Board {
    private static int BOARD_WIDTH;
    private static int BOARD_HEIGHT;
    private Block[][] blockArray;

    public static int getBOARD_WIDTH() {
        return BOARD_WIDTH;
    }

    public static int getBOARD_HEIGHT() {
        return BOARD_HEIGHT;
    }

    public Block[][] getBlockArray() {
        return blockArray;
    }

    /**
     * Constructs an empty standard size Tetris board.
     */
    public Board() {
        this.blockArray = new Block[BOARD_WIDTH][BOARD_HEIGHT];
    }

    /**
     * Constructs an empty custom size Tetris board.
     *
     * @param width
     * @param height
     */
    public Board(int width, int height) {
        this.blockArray = new Block[width][height];
    }
}
