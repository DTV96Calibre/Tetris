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
 * Description: Primary controller class
 *
 * ****************************************
 */
package tetris.controller;

import java.awt.Point;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.newdawn.slick.Color.pink;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;
import tetris.model.Block;
import tetris.model.Direction;
import tetris.model.MainModel;
import tetris.model.Tetrimino;
import tetris.resources.Resources;
import tetris.view.MainView;
import tetris.view.Window;

/**
 * The controller of the Tetris program, which syncs the model and view.
 *
 * @author Brooke Bullek
 */
public class MainController {

    /**
     * Instance of the primary model class .
     */
    private MainModel theModel;

    /**
     * Instance of the primary view class.
     */
    private MainView theView;

    /**
     * Constructor to instantiate a new TetrisController instance.
     *
     * @author Brooke Bullek
     * @param theModel An instance of the primary model class
     * @param theView An instance of the primary view class
     */
    public MainController(MainModel theModel, MainView theView) {
        this.theModel = theModel;
        this.theView = theView;
    }

    /**
     * Renders various components of theView based on the state of the model.
     *
     * @param gc Automatically generated by Slick
     * @param s Automatically generated by Slick
     * @param g Automatically generated by Slick
     */
    public void render(GameContainer gc, StateBasedGame s, Graphics g) {
        renderBackground(gc, g); // render the background with a space picture
        renderScoreBoard(gc, g);
        renderTetrimino(gc, g); // draw the active tetrimino
        renderBoard(gc, g); // draw the blocks on the gameboard

    }

    public void renderBackground(GameContainer gc, Graphics g) {
        Image image = Resources.getImages().get("background");
        image.draw(0, 0, Window.getWIDTH(), Window.getHEIGHT());
    }

    /**
     * Executes logic of the main game loop, both using a timer and by checking
     * for user input.
     *
     * @param gc Automatically generated by Slick
     * @param s Automatically generated by Slick
     * @param delta Effectively the game's timer. Automatically generated by
     * Slick
     */
    public void update(GameContainer gc, StateBasedGame s, int delta) {
        // check user input
        Input input = gc.getInput();
        // preserve game speed in case DOWN arrow was pressed
        int oldGameSpeed = theModel.getGameSpeed();
        // if user pressed the up arrow key, try to rotate the active tetrimino
        if (input.isKeyPressed(Input.KEY_UP)) {
            rotateActiveTetrimino(1);
        } // if user pressed the left arrow key, try to move the tetrimino left
        else if (input.isKeyPressed(Input.KEY_LEFT)) {
            moveActiveTetrimino(Direction.LEFT);
        } // if user pressed the right arrow key, try to move right
        else if (input.isKeyPressed(Input.KEY_RIGHT)) {
            moveActiveTetrimino(Direction.RIGHT);
        } else if (input.isKeyDown(Input.KEY_DOWN)) {
            // the Tetriminos should fall faster
            theModel.setGameSpeed(50);
        }

        updateActiveTetrimino(gc, delta);
        theModel.setGameSpeed(oldGameSpeed);
    }

    /**
     * Allows the active Tetrimino to fall downward by 1 block if enough time
     * has passed since the last fall. This method is constantly called within
     * the main game loop and its timer threshold should scale with the current
     * difficulty level.
     *
     * @author Xizhou Li
     * @param gc Automatically generated by Slick
     * @param delta Automatically generated by Slick
     */
    public void updateActiveTetrimino(GameContainer gc, int delta) {
        int timer = theModel.getTimer();

        if (timer < theModel.getGameSpeed()) {
            theModel.setTimer(timer + delta);
        } else {
            theModel.setTimer(0); // reset timer event
            moveActiveTetrimino(Direction.DOWN); // drop tetrimino by 1 space
        }
    }

    /**
     * Allows the active Tetrimino to rotate if there is room on the gameboard.
     * If so, this position is updated; else, nothing happens.
     *
     * @author Brooke Bullek
     * @param factor
     */
    public void rotateActiveTetrimino(int factor) {
        // preserve old arrangement of blocks in case a rotation isn't possible
        Block oldBlockArray[] = new Block[Tetrimino.TETRIMINO_ARRAY_WIDTH];
        // creates a deep copy to avoid copying references to these Blocks
        for (int i = 0; i < Tetrimino.TETRIMINO_ARRAY_WIDTH; i++) {
            try {
                oldBlockArray[i] = (Block) theModel.getActiveTetrimino().getBlockArray()[i].copy();
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(MainController.class.getName()).log(
                        Level.WARNING,
                        "Block could not be copied; Cloning not supported", ex);
            }
        }

        // create a new array of Points which reflects the rotated Tetrimino
        Point newBlockPositions[] = new Point[Tetrimino.TETRIMINO_ARRAY_WIDTH];
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
     * Moves the active Tetrimino in a specified direction if there is room on
     * the gameboard. If so, this position is updated; else, nothing happens.
     *
     * @authors Daniel Vasquez & Brooke Bullek
     * @param d A Direction associated with this movement; e.g. left/right/down.
     */
    public void moveActiveTetrimino(Direction d) {
        // for more info, see the Direction enum in tetris.model package
        int shiftAmountX = (int) d.getDirection().getX();
        int shiftAmountY = (int) d.getDirection().getY();

        // compose a new series of Points corresponding to locations if we were
        // to move this Tetrimino
        Point newBlockPositions[] = new Point[4];
        int i = 0;
        for (Block block : theModel.getActiveTetrimino().getBlockArray()) {
            /* calculate the new coordinate, which is the absolute position
             * of this Tetrimino on the gameboard, plus the relative position
             * of this individual block to the Tetrimino, plus whatever shift
             * amount is specified by the direction of motion
             */
            int newX = (int) (block.getLocation().getX()
                              + theModel.getActiveTetriminoLocation().getX()
                              + shiftAmountX);
            int newY = (int) (block.getLocation().getY()
                              + theModel.getActiveTetriminoLocation().getY()
                              + shiftAmountY);
            newBlockPositions[i] = new Point(newX, newY);
            i++;
        }

        // use the validate method to make sure these pieces will fit
        if (theModel.getMyBoard().validate(newBlockPositions) == true) {
            // it's safe to move this piece down
            Point newPosition = new Point(
                    (int) theModel.getActiveTetriminoLocation().getX() + shiftAmountX,
                    (int) theModel.getActiveTetriminoLocation().getY() + shiftAmountY);
            theModel.setActiveTetriminoLocation(newPosition);
        } // else, we check whether this Tetrimino should be locked
        else {
            if (d == Direction.DOWN) {
                theModel.lockActiveTetrimino();
            }
        }
    }

    /**
     * Renders a Tetrimino within the game window by drawing each of its 4
     * Blocks.
     *
     * @author Xizhou Li
     * @param gc Automatically generated by Slick
     * @param g Automatically generated by Slick
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
     *
     * @author Xizhou Li
     * @param gc Automatically generated by Slick
     * @param g Automatically generated by Slick
     * @param block The <code>Block</code> to render
     */
    public void renderBlock(GameContainer gc, Graphics g, Block block) {

        int xLocation = (int) (theModel.getActiveTetriminoLocation().getX()
                               + block.getLocation().getX());
        int yLocation = (int) (theModel.getActiveTetriminoLocation().getY()
                               + block.getLocation().getY());
//        g.setColor(block.getColor());
        String color = block.getColor().toString();
        // draw the block as a small square
        Image image = Resources.getImages().get(color);
        image.draw(xLocation * Window.getPIXEL_OFFSET(),
                   yLocation * Window.getPIXEL_OFFSET(), 32, 32);
//        g.fillRect(xLocation * Window.getPIXEL_OFFSET(),
//                   (int) (yLocation * Window.getPIXEL_OFFSET()),
//                   Window.getPIXEL_OFFSET(), Window.getPIXEL_OFFSET());
//        g.setColor(black);
//        g.drawRect((int) xLocation * Window.getPIXEL_OFFSET(),
//                   (int) (yLocation * Window.getPIXEL_OFFSET()),
//                   Window.getPIXEL_OFFSET(), Window.getPIXEL_OFFSET());
    }

    /**
     * Renders the <code>ScoreBoard</code> on the LEFT half of the screen
     *
     * @param gc Automatically generated by Slick
     * @param g Automatically generated by Slick
     * @author Andre Amirsaleh
     */
    public void renderScoreBoard(GameContainer gc, Graphics g) {
        String sPoints = String.valueOf(
                theModel.getMyBoard().getScoreBoard().getPoints());
        String title = "Score:";
        g.setColor(pink);
        g.drawString(title, 32 * 11, 0);
        g.drawString(sPoints, 32 * 11, 32);
    }

    /**
     * Draws the gameboard by iterating through the Block array and rendering
     * colorful squares wherever the board is occupied.
     *
     * @author Brooke Bullek
     * @param gc Automatically generated by Slick
     * @param g Automatically generated by Slick
     */
    public void renderBoard(GameContainer gc, Graphics g) {
        // iterate through the rows and columns of the Board, drawing each block
        for (int i = 0; i < theModel.getMyBoard().getWidth(); i++) {
            for (int j = 0; j < theModel.getMyBoard().getHeight(); j++) {
                // be careful to check that there is indeed a block to draw
                if (theModel.getMyBoard().getBlockArray()[i][j] != null) {
                    // set the color of this block and fill in the square
                    String color = theModel.getMyBoard().getBlockArray()[i][j].getColor().toString();
                    // draw the block as a small square
                    Image image = Resources.getImages().get(color);
                    image.draw(i * Window.getPIXEL_OFFSET(),
                               j * Window.getPIXEL_OFFSET(), 32, 32);
//                    g.setColor(
//                            theModel.getMyBoard().getBlockArray()[i][j].getColor());
//                    g.fillRect(i * Window.getPIXEL_OFFSET(),
//                               j * Window.getPIXEL_OFFSET(),
//                               Window.getPIXEL_OFFSET(),
//                               Window.getPIXEL_OFFSET());
//                    // draw the black border around the square
//                    g.setColor(black);
//                    g.drawRect(i * Window.getPIXEL_OFFSET(),
//                               j * Window.getPIXEL_OFFSET(),
//                               Window.getPIXEL_OFFSET(),
//                               Window.getPIXEL_OFFSET());
                }
            }
        }
    }
}
