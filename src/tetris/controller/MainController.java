/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2016
 *
 * Name: Andre Amirsaleh, Brooke Bullek, Daniel Vasquez, Xizhou Li
 * Date: Apr 18, 2016
 * Time: 7:51:51 PM
 *
 * Project: csci205FinalProject
 * Package: tetris.controller
 * File: MainController
 * Description:
 *
 * ****************************************
 */
package tetris.controller;

import java.awt.Point;
import static org.newdawn.slick.Color.black;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;
import tetris.model.Block;
import tetris.model.MainModel;
import tetris.view.MainView;
import tetris.view.Window;

/**
 * The controller of the Tetris program, which syncs the model and view.
 *
 * @author Brooke Bullek
 */
public class MainController {
    private MainModel theModel;
    private MainView theView;

    /**
     * Constructor to instantiate a new TetrisController instance.
     *
     * @author Brooke Bullek
     * @param theModel
     * @param theView
     */
    public MainController(MainModel theModel, MainView theView) {
        this.theModel = theModel;
        this.theView = theView;
    }

    /**
     * Renders various components of theView based on the state of the model.
     */
    public void render(GameContainer gc, StateBasedGame s, Graphics g) {
        renderTetrimino(gc, g); // draw the active tetrimino
    }

    /**
     * Executes logic of the main game loop, both using a timer and by checking
     * for user input.
     */
    public void update(GameContainer gc, StateBasedGame s, int delta) {
        // check user input
        Input input = gc.getInput();
        // if user pressed the up arrow key, try to rotate the active tetrimino
        if (input.isKeyPressed(Input.KEY_UP)) {
            rotateActiveTetrimino(1);
        }

        updateActiveTetrimino(gc, delta);
    }

    /**
     * Allows the active Tetrimino to fall downward by 1 block if enough time
     * has passed since the last fall.
     *
     * @author Xizhou Li
     */
    public void updateActiveTetrimino(GameContainer gc, int delta) {
        int timer = theModel.getTimer();

        if (timer < 800) { // TODO: Scale timer with difficulty so blocks fall faster
            theModel.setTimer(timer + delta);
        } else {
            theModel.setTimer(0); // reset timer event
            moveActiveTetriminoDown(); // logic to drop tetrimino by 1 space
        }
    }

    /**
     * Allows the active Tetrimino to rotate if there is room on the gameboard.
     * If so, this position is updated; else, nothing happens.
     *
     * @author Brooke Bullek
     * @param 1 is rotating clockwise, -1 if rotating counterclockwise
     */
    public void rotateActiveTetrimino(int factor) {
        // preserve old arrangement of blocks in case a rotation isn't possible
        Block oldBlockArray[] = theModel.getActiveTetrimino().getBlockArray();

        // create a new array of Points which reflects the rotated Tetrimino
        Point newBlockPositions[] = new Point[4];
        theModel.getActiveTetrimino().rotate(factor);
        // grab the new absolute positions (i.e. their positions on the board)
        int i = 0;
        for (Block block : theModel.getActiveTetrimino().getBlockArray()) {
            int newX = (int) (block.getLocation().getX()
                              + theModel.getActiveTetriminoLocation().getX());
            int newY = (int) (block.getLocation().getY()
                              + theModel.getActiveTetriminoLocation().getY());
            newBlockPositions[i] = new Point(newX, newY);
            i++;
        }

        // use the validate method to make sure these pieces will fit
        if (theModel.getMyBoard().validate(newBlockPositions) == false) {
            // if not, we need to restore the previous arrangement of blocks
            theModel.getActiveTetrimino().setBlockArray(oldBlockArray);
        }
    }

    /**
     * Moves the active Tetrimino down by 1 unit if there is room on the
     * gameboard. If so, this position is updated; else, nothing happens.
     *
     * @authors Daniel Vasquez & Brooke Bullek
     */
    public void moveActiveTetriminoDown() {
        // compose a new series of Points corresponding to locations if we were
        // to move this Tetrimino down
        Point newBlockPositions[] = new Point[4];
        int i = 0;
        for (Block block : theModel.getActiveTetrimino().getBlockArray()) {
            int newX = (int) (block.getLocation().getX() + theModel.getActiveTetriminoLocation().getX());
            int newY = (int) (block.getLocation().getY() + theModel.getActiveTetriminoLocation().getY() + 1);
            newBlockPositions[i] = new Point(newX, newY);
            i++;
        }

        // use the validate method to make sure these pieces will fit
        if (theModel.getMyBoard().validate(newBlockPositions) == true) {
            // it's safe to move this piece down
            Point newPosition = new Point(
                    (int) theModel.getActiveTetriminoLocation().getX(),
                    (int) theModel.getActiveTetriminoLocation().getY() + 1);
            theModel.setActiveTetriminoLocation(newPosition);
        } // else, we don't update the Tetrimino's position
    }

    /**
     * Renders a Tetrimino within the game window by drawing each of its 4
     * Blocks.
     */
    public void renderTetrimino(GameContainer gc, Graphics g) {
        // get the array of blocks from the active tetrimino
        Block[] blockArray = this.theModel.getActiveTetrimino().getBlockArray();

        // iterate through the blocks of the active tetrimino and draw them
        // relative to the gameboard
        for (int i = 0; i < blockArray.length; i++) {
            renderBlock(gc, g, blockArray[i]);
        }
    }

    /**
     * Renders a Block (1/4 of a Tetrimino) within the game window.
     */
    public void renderBlock(GameContainer gc, Graphics g, Block block) {
        g.setColor(block.getColor());
        int xLocation = (int) (theModel.getActiveTetriminoLocation().getX()
                               + block.getLocation().getX());
        int yLocation = (int) (theModel.getActiveTetriminoLocation().getY()
                               + block.getLocation().getY());

        // draw the block as a small square
        g.fillRect(xLocation * Window.getPIXEL_OFFSET(),
                   (int) (yLocation * Window.getPIXEL_OFFSET()),
                   Window.getPIXEL_OFFSET(), Window.getPIXEL_OFFSET());
        g.setColor(black);
        g.drawRect((int) xLocation * Window.getPIXEL_OFFSET(),
                   (int) (yLocation * Window.getPIXEL_OFFSET()),
                   Window.getPIXEL_OFFSET(), Window.getPIXEL_OFFSET());
    }
}
