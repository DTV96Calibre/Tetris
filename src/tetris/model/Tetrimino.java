/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.model;

import java.awt.Color;

/**
 * A shaped piece made up of four blocks. Represented as a 2D array of blocks.
 * Rotates about the array's center. "They fall, can be rotated, and used to
 * break lines." -Tetris Wikia
 *
 * @author Daniel Vasquez
 */
public class Tetrimino {
    // PLACEHOLDER!!!
    private static boolean[][] array;

    /**
     * The number of columns/rows in the Tetrimino's array of blocks.
     */
    public static final int TETRIMINO_ARRAY_WIDTH = 5;

    public enum Shape {

        // PLACEHOLDER!!!
        Z(array, Color.BLUE);

        private final boolean[][] blockShape;
        private final Color color;

        public boolean[][] getBlockShape() {
            return blockShape;
        }

        public Color getColor() {
            return color;
        }

        Shape(boolean[][] truthArray, Color color) {
            this.color = color;
            this.blockShape = truthArray;

        }
    }

    public Tetrimino(Shape shape) {
        Block[][] blockArray = new Block[TETRIMINO_ARRAY_WIDTH][TETRIMINO_ARRAY_WIDTH];
        for (int i = 0; i < TETRIMINO_ARRAY_WIDTH; i++) {
            for (int j = 0; i < TETRIMINO_ARRAY_WIDTH; i++) {
                blockArray[i][j] = new Block(shape.getColor(), Color.GRAY); //PLACEHOLDER
            }
        }
        this.array = null;
    }
}
