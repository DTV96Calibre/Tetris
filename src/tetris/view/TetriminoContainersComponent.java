/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2016
 *
 * Name: Andre Amirsaleh, Brooke Bullek, Daniel Vasquez, Xizhou Li
 * Date: Apr 30, 2016
 * Time: 11:50:27 PM
 *
 * Project: csci205FinalProject
 * Package: tetris.view
 * File: TetriminoContainersComponent
 * Description: Component class used to display elements
 * relevant to blocks/Tetriminos not on the gameboard.
 *
 * ****************************************
 */
package tetris.view;

import java.awt.Point;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import tetris.model.Block;
import tetris.model.Tetrimino;
import tetris.resources.Resources;

/**
 * Displays the next Tetrimino that will be available.
 *
 * @author Daniel Vasquez
 */
public class TetriminoContainersComponent {

    public static final int PIXELS_IN_BLOCK_WIDTH = 32;

    private final Point RELATIVE_LOCATION = new Point(14, 5);

    private final Point NEXT_OFFSET = new Point(0, 0);
    private final Point HOLD_OFFSET = new Point(0, 8);

    /**
     * A TetriminoComponent used to draw the Tetrimino preview.
     */
    private Tetrimino nextTetrimino;
    private Tetrimino holdTetrimino;

    /**
     * Constructs a NextTetriminoComponent object.
     *
     * @author Daniel Vasquez
     */
    public TetriminoContainersComponent() {
        // Initialize tetriminos to something
        this.nextTetrimino = null;
        this.holdTetrimino = null;
    }

    /**
     * Constructs a NextTetriminoComponent object with nextShape and
     * holdTetrimino preinitialized.
     *
     * @author Daniel Vasquez
     * @param nextTetrimino
     * @param holdTetrimino
     */
    public TetriminoContainersComponent(Tetrimino nextTetrimino,
                                        Tetrimino holdTetrimino) {
        this.nextTetrimino = nextTetrimino;
        this.holdTetrimino = holdTetrimino;
    }

    public void setNextTetrimino(Tetrimino nextTetrimino) {
        if (nextTetrimino != this.nextTetrimino) {
            this.nextTetrimino = nextTetrimino;
        }
    }

    public void setHoldTetrimino(Tetrimino holdTetrimino) {
        if (holdTetrimino != this.holdTetrimino) {
            this.holdTetrimino = holdTetrimino;
        }
    }

    /**
     * Renders the Hold and Next Tetrimino previews and their graphical
     * elements.
     *
     * @author Daniel Vasquez
     * @param gc A generic game container that handles the game loop
     * @param g A graphics context used to render primitives to the canvas
     */
    public void render(GameContainer gc, Graphics g) {
        Point[] offsets = {NEXT_OFFSET, HOLD_OFFSET};
        Tetrimino[] tetriminos = {nextTetrimino, holdTetrimino};
        for (int i = 0; i < tetriminos.length; i++) {
            if (tetriminos[i] != null) {
                for (Block block : tetriminos[i].getBlockArray()) {
                    // record absolute position of this Block
                    int xLocation = (int) (RELATIVE_LOCATION.getX() + offsets[i].getX()
                                           + block.getLocation().getX());
                    int yLocation = (int) (RELATIVE_LOCATION.getY() + offsets[i].getY()
                                           + block.getLocation().getY());

                    // extract the color of this Block
                    String color = block.getColor();
                    // draw the block as a small square
                    Image image = Resources.getImages().get(color);
                    image.draw(xLocation * Window.BLOCK_PIXEL_OFFSET,
                               yLocation * Window.BLOCK_PIXEL_OFFSET,
                               PIXELS_IN_BLOCK_WIDTH, PIXELS_IN_BLOCK_WIDTH);
                }
            }
        }
    }

}
