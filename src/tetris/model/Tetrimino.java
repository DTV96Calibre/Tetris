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

    /**
     * The number of columns/rows in the Tetrimino's array of blocks.
     */
    public static final int WIDTH_OF_TETRIMINO_ARRAY = 5;

    public enum Shape {
        Z();

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

    public Tetrimino() {
        Block[][] blockArray = new Block[WIDTH_OF_TETRIMINO_ARRAY][WIDTH_OF_TETRIMINO_ARRAY];

    }
}
