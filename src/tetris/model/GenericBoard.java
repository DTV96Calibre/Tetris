/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2016
 *
 * Name: Andre Amirsaleh, Brooke Bullek, Daniel Vasquez, Xizhou Li
 * Date: Apr 9, 2016
 * Time: 5:26:33 PM
 *
 * Project: csci205FinalProject
 * Package: tetris.model
 * File: ScoreBoard
 * Description: Class that represents a generic gameboard
 *
 * ****************************************
 */
package tetris.model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 * Generic gameboard which contains falling and sitting blocks
 *
 * @author Daniel Vasquez
 */
public class GenericBoard {
    // default board sizes
    public static final int WIDTH = 10;
    public static final int HEIGHT = 20;

    /**
     * Width of the <code>GenericBoard</code>'s grid
     *
     * @author Daniel Vasquez
     */
    private int width;

    /**
     * Height of the <code>GenericBoard</code>'s grid
     *
     * @author Daniel Vasquez
     */
    private int height;

    /**
     * The <code>GenericBoard</code>'s grid
     *
     * @author Daniel Vasquez
     */
    private Block[][] blockArray;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    /**
     * Returns the <code>blockArray</code> attribute
     *
     * @return The <code>GenericBoard</code>'s grid
     * @author Daniel Vasquez
     */
    public Block[][] getBlockArray() {
        return blockArray;
    }

    /**
     * Constructs an empty standard size Tetris board with default height and
     * width.
     *
     * @author Daniel Vasquez
     */
    public GenericBoard() {
        this.blockArray = new Block[WIDTH][HEIGHT];
        this.width = WIDTH;
        this.height = HEIGHT;
    }

    /**
     * Constructs an empty custom size Tetris board.
     *
     * @param width Width of the <code>Board</code>'s grid
     * @param height Height of the <code>Board</code>'s grid
     * @author Daniel Vasquez
     */
    public GenericBoard(int width, int height) {
        this.blockArray = new Block[width][height];
        this.width = width;
        this.height = height;
    }

    /**
     * <<<<<<< HEAD Validates that a given array of cells (represented by
     * Points) are empty on this board so that we can place Blocks here. Returns
     * false if any of the Points exceed the boundary of this board or if the
     * cell is already full.
     *
     * @author Brooke Bullek
     */
    public boolean validate(Point[] newPositions) {
        int newXPos;
        int newYPos;

        // check each of the Points and only return true if they all fit
        for (int i = 0; i < newPositions.length; i++) {
            // grab the x and y coordinates from this Point
            newXPos = (int) newPositions[i].getX();
            newYPos = (int) newPositions[i].getY();

            // return false if this Point exceeds the vertical boundary
            if (newYPos < 0 || newYPos >= this.height) {
                return false;
            }
            // return false if this Point exceeds the horizontal boundary
            if (newXPos < 0 || newXPos >= this.width) {
                return false;
            }
            // return false if this is a valid cell that is already occupied
            if (this.blockArray[newXPos][newYPos] != null) {
                return false;
            }
        }
        return true; // everything's good!
    }

    /**
     * Detects lines in the board's block array.
     *
     * @author Daniel Vasquez
     * @return List of indexes where lines are located
     */
    public List detectLines() {
        List rowIndices = new ArrayList();
        for (int j = 0; j < HEIGHT; j++) {
            for (int i = 0; i < WIDTH; i++) {
                if (this.blockArray[i][j] == null) {
                    break;
                } else if (i + 1 == WIDTH) {
                    rowIndices.add(j);
                }
            }
        }
        return rowIndices;
    }
}
