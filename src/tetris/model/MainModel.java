/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2016
 *
 * Name: Andre Amirsaleh, Brooke Bullek, Daniel Vasquez, Xizhou Li
 * Date: Apr 18, 2016
 * Time: 8:02:16 PM
 *
 * Project: csci205FinalProject
 * Package: tetris.model
 * File: MainModel
 * Description:
 *
 * ****************************************
 */
package tetris.model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

/**
 * Contains all of the internal states of Tetris that are subject to change
 * throughout the duration of a game.
 *
 * @author Brooke Bullek
 */
public class MainModel {
    /* The default location of a new Tetrimino when it's first being loaded.
     Traditionally, the Tetrimino starts at the top of the middle of the
     screen.
     */
    private Point initialTetriminoLocation;

    /* The active game board for this game */
    public GenericBoard myBoard;

    /* A bag of 7 different types of T-shapes*/
    private ArrayList<TShape> bag = new ArrayList<TShape>();

    /* the Tetrimino that is currently being placed */
    private Tetrimino activeTetrimino;

    /* The location of the center block of the active Tetrimino RELATIVE to the
     game board
     */
    private Point activeTetriminoLocation;

    /* The rate at which Tetriminos fall; scales with difficulty and increases
     whenever the user holds the DOWN arrow
     */
    private int gameSpeed;

    private int timer;

    /**
     * Constructs a new instance of MainModel.
     *
     * @author Brooke Bullek
     */
    public MainModel() {
        // TODO: Modify gameboard selection to change with user's choice of
        // game mode?
        myBoard = new GenericBoard();

        // the Tetrimino should spawn at the midpoint of the top of the screen
        initialTetriminoLocation = new Point(myBoard.getWidth() / 2, 1);

        setActiveTetrimino(pickTShape()); // pick the first Tetrimino

        gameSpeed = 800; // initialize to 800 ms

    }

    /* Getters and setters */
    public Point getActiveTetriminoLocation() {
        return activeTetriminoLocation;
    }

    public void setActiveTetriminoLocation(Point activeTetriminoLocation) {
        this.activeTetriminoLocation = activeTetriminoLocation;
    }

    public GenericBoard getMyBoard() {
        return myBoard;
    }

    public void setMyBoard(GenericBoard myBoard) {
        this.myBoard = myBoard;
    }

    public Tetrimino getActiveTetrimino() {
        return activeTetrimino;
    }

    public void setActiveTetrimino(Tetrimino activeTetrimino) {
        this.activeTetrimino = activeTetrimino;
    }

    public void setActiveTetrimino(TShape shape) {
        activeTetrimino = new Tetrimino(shape);
        activeTetriminoLocation = initialTetriminoLocation;
    }

    public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }

    public int getGameSpeed() {
        return gameSpeed;
    }

    public void setGameSpeed(int gameSpeed) {
        this.gameSpeed = gameSpeed;
    }
    /* End of getters and setters */

    /**
     * Places the blocks in the active Tetrimino into the gameboard and load a
     * new Tetrimino at the top of the screen.
     *
     * TODO: Fix this function
     *
     * @author Daniel Vasquez
     */
    public void lockActiveTetrimino() {
        for (Block block : activeTetrimino.getBlockArray()) {
            // extract the location (x/y coordinates) of this block
            int xPos = (int) (block.getLocation().getX() + activeTetriminoLocation.getX());
            int yPos = (int) (block.getLocation().getY() + activeTetriminoLocation.getY());

            myBoard.setBlock(xPos, yPos, block); // stick this Block in the board
        }

        // detect lines that may have been made, clear them, and perform the appropriate drops
        ArrayList<Integer> lines = (ArrayList<Integer>) this.myBoard.detectLines();
        if (!lines.isEmpty()) {
            this.myBoard.clearLines(lines);
            this.myBoard.dropLines(lines);
        }
        // change the active Tetrimino
        setActiveTetrimino(pickTShape());
    }

    /**
     * Inserts each of the 7 Tetrimino types (from the TShape enum) into the
     * "grab bag" to be used for Tetrimino generation.
     *
     * @author Xizhou Li
     */
    public void initializeBag() {
        for (TShape shape : TShape.values()) {
            bag.add(shape);
        }
    }

    /**
     * Randomly selects an available TShape from the "grab bag," removes this
     * from the bag, and returns it.
     *
     * @author Xizhou Li
     * @return an available TShape to set as the next Tetrimino to drop
     */
    public TShape pickTShape() {
        // if this "grab bag" has been depleted, reset it with all 7 TShapes
        if (this.bag.size() == 0) {
            initializeBag();
        }

        // use a random number generator to pull out a new TShape
        Random randomizer = new Random();
        int index = randomizer.nextInt(this.bag.size());
        TShape shape = bag.get(index);

        // remove this TShape from the bag
        bag.remove(index);

        return shape;
    }
}
