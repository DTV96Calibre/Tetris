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

import static org.newdawn.slick.Color.black;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;
import tetris.model.Block;
import tetris.model.GenericBoard;
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
     * Updates various components of theView based on the state of the model.
     */
    public void render(GameContainer gc, StateBasedGame s, Graphics g) {
        renderActiveTetrimino(gc, g);
    }

    public void update(GameContainer gc, StateBasedGame s, int delta) {
        updateActiveTetrimino(gc, delta);
    }

    public void renderActiveTetrimino(GameContainer gc, Graphics g) {
        // get the array of blocks from the active tetrimino
        Block[] blockArray = this.theModel.getActiveTetrimino().getBlockArray();

        // iterate through the blocks of the active tetrimino and draw them
        // relative to the gameboard
        for (int i = 0; i < blockArray.length; i++) {
            renderBlock(gc, g, blockArray[i]);
        }
    }

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

    public void updateActiveTetrimino(GameContainer gc, int delta) {
        // get the appropriate variables we'll be using from theModel
        int timer = theModel.getTimer();
        Block[] blockArray = this.theModel.getActiveTetrimino().getBlockArray();
        GenericBoard myBoard = theModel.getMyBoard();

        if (timer < 800) { // TODO: Scale timer with difficulty so blocks fall faster
            theModel.setTimer(timer + delta);
        } else {
            theModel.setTimer(0); // reset timer event
            theModel.moveTetriminoDown(); // logic to drop tetrimino by 1 space
        }
    }

}
