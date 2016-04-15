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

/**
 * Generic gameboard which contains falling and sitting blocks
 *
 * @author Daniel Vasquez
 */
public class GenericBoard {

    /**
     * Width of the <code>GenericBoard</code>'s grid
     *
     * @author Daniel Vasquez
     */
    private static final int WIDTH = 10;

    /**
     * Height of the <code>GenericBoard</code>'s grid
     *
     * @author Daniel Vasquez
     */
    private static final int HEIGHT = 20;

    /**
     * The <code>GenericBoard</code>'s grid
     *
     * @author Daniel Vasquez
     */
    private Block[][] blockArray;

    /**
     * Returns <code>WIDTH</code> (static) attribute
     *
     * @return Width of the <code>GenericBoard</code>'s grid
     * @author Daniel Vasquez
     */
    public static int getWidth() {
        return WIDTH;
    }

    /**
     * Returns <code>getHeight</code> (static) attribute
     *
     * @return Height of the <code>GenericBoard</code>'s grid
     * @author Daniel Vasquez
     */
    public static int getHeight() {
        return HEIGHT;
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
     * Constructs an empty standard size Tetris board.
     *
     * @author Daniel Vasquez
     */
    public GenericBoard() {
        this.blockArray = new Block[WIDTH][HEIGHT];
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
    }

}
