/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.model;

import java.awt.Point;

/**
 * A shaped piece made up of four blocks. Represented as a 2D array of blocks.
 * Rotates about the array's center. "They fall, can be rotated, and used to
 * break lines." -Tetris Wikia
 *
 * @author Daniel Vasquez & Brooke Bullek
 */
public class Tetrimino {

    /**
     * The number of blocks that form a Tetrimino.
     */
    public static final int TETRIMINO_ARRAY_WIDTH = 4;

    /* An array of four Blocks that stores the internal layout of the Tetrimino
     * piece. Each Block contains a Point where (0, 0) is the center (pivot)
     * block of the Tetrimino.
     */
    private Block[] blockArray;

    /* The general "shape" of this Tetrimino (e.g. S-block, L-block). */
    private TShape shape;

    /**
     * Constructs a new Tetrimino of type TShape.
     *
     * @author Brooke Bullek
     * @param shape the TShape of this piece (e.g. S-block, L-block)
     */
    public Tetrimino(TShape shape) {
        Block[] blockArray = new Block[TETRIMINO_ARRAY_WIDTH];

        // iterate through the Point array of this TShape and create four Blocks
        for (int i = 0; i < shape.getMinoLocations().length; i++) {
            blockArray[i] = new Block(shape.getColor(),
                                      shape.getMinoLocations()[i]);
        }

        /* Assign attributes to this Tetrimino. No need to assign a Color
         * since that information is contained within the TShape enum.
         */
        this.shape = shape;
        this.blockArray = blockArray;
    }

    /* Getters and setters */
    public Block[] getBlockArray() {
        return blockArray;
    }

    public void setBlockArray(Block[] blockArray) {
        this.blockArray = blockArray;
    }

    public TShape getShape() {
        return shape;
    }

    public void setShape(TShape shape) {
        this.shape = shape;
    }
    /* End of getters and setters */

    /**
     * Rotates the Tetrimino 90 degrees left or right, depending on the factor
     * given (-1 denotes a left rotation, 1 denotes a right rotation). All
     * Tetriminos will be rotated around their pivot (center) point.
     *
     * @author Brooke Bullek
     *
     * @see <a html="http://www.blitzmax.com/Community/posts.php?topic=77559">
     * http://www.blitzmax.com/Community/posts.php?topic=77559</a>
     *
     * @param factor a positive or negative value indicating CW or CCW rotation
     */
    public void rotate(int factor) {
        // if Tetrimino is an O-block (non-rotatable), do nothing
        if (this.shape == TShape.O_BLOCK) {
            return;
        }

        // update each of the Blocks (i.e. their locations) of this Tetrimino
        for (int i = 0; i < TETRIMINO_ARRAY_WIDTH; i++) {
            // first extract old x, y coordinates of this block
            int oldX = (int) this.blockArray[i].getLocation().getX();
            int oldY = (int) this.blockArray[i].getLocation().getY();

            // if performing a right (clockwise) rotation
            if (factor > 0) {
                this.blockArray[i].setLocation(new Point(oldY, -oldX));
            } // if performing a left (counter-clockwise) rotation
            else if (factor < 0) {
                this.blockArray[i].setLocation(new Point(-oldY, oldX));
            }
        }

        //TODO: Integrate with GenericBoard class to determine whether this
        // Tetrimino can't be rotated (for example, it's in a corner)
    }
}
