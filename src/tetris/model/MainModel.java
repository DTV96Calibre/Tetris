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
import tetris.resources.Resources;

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
    public GameBoard myBoard;

    /* A bag of 7 different types of T-shapes*/
    private ArrayList<TShape> bag = new ArrayList<TShape>();

    /* The Tetrimino that is currently being placed */
    private Tetrimino activeTetrimino;

    /* The Tetrimino that will be available to the
     player when the active Tetrimino is placed
     */
    private TShape nextTetrimino;

    /* The Tetrimino stored in the hold place.
     Switched with the active Tetrimino when the hold button is pressed.
     */
    private Tetrimino heldTetrimino;

    /* The location of the center block of the active Tetrimino RELATIVE to the
     game board
     */
    private Point activeTetriminoLocation;

    /* The rate at which Tetriminos fall; scales with difficulty and increases
     whenever the user holds the DOWN arrow
     */
    private int dropSpeed;

    /**
     * A toggle that indicates whether to perform a soft drop (holding the down
     * arrow key) on the Tetrimino
     */
    private boolean softDropActivated;

    private int timer;

    /**
     * Indicates whether the current game is still active or has been lost
     */
    private boolean gameOver;

    /**
     * Constructs a new instance of MainModel.
     *
     * @author Brooke Bullek
     */
    public MainModel() {
        // TODO: Modify gameboard selection to change with user's choice of
        // game mode?
        myBoard = new GameBoard();

        // the Tetrimino should spawn at the midpoint of the top of the screen
        initialTetriminoLocation = new Point(myBoard.getWidth() / 2, 0);

        heldTetrimino = null;

        setNextTetrimino(pickTShape());     // pick the first shape
        advanceTetriminoQueue(); // set the first active Tetrimino

        dropSpeed = 800; // initialize to 800 ms

        softDropActivated = false; // will change if user holds DOWN arrow key

        gameOver = false;
    }

    private void advanceTetriminoQueue() {
        setActiveTetrimino(nextTetrimino);
        setNextTetrimino(pickTShape());
    }

    /* Getters and setters */
    public Point getActiveTetriminoLocation() {
        return activeTetriminoLocation;
    }

    public void setActiveTetriminoLocation(Point activeTetriminoLocation) {
        this.activeTetriminoLocation = activeTetriminoLocation;
    }

    public GameBoard getMyBoard() {
        return this.myBoard;
    }

    public void setMyBoard(GameBoard myBoard) {
        this.myBoard = myBoard;
    }

    public Tetrimino getActiveTetrimino() {
        return this.activeTetrimino;
    }

    public void setActiveTetrimino(Tetrimino activeTetrimino) {
        this.activeTetrimino = activeTetrimino;
    }

    public void setActiveTetrimino(TShape shape) {
        this.activeTetrimino = new Tetrimino(shape);
        this.activeTetriminoLocation = initialTetriminoLocation;
    }

    public TShape getNextTetrimino() {
        return this.nextTetrimino;
    }

    public void setNextTetrimino(TShape nextTetrimino) {
        this.nextTetrimino = nextTetrimino;
    }

    public Tetrimino getHeldTetrimino() {
        return this.heldTetrimino;
    }

    public void setHeldTetrimino(Tetrimino heldTetrimino) {
        this.heldTetrimino = heldTetrimino;
    }

    /**
     * Swaps the active Tetrimino with the held Tetrimino.
     *
     * @author Daniel Vasquez
     */
    public void holdActiveTetrimino() {
        if (this.heldTetrimino == null) {
            this.heldTetrimino = this.activeTetrimino;
            this.setActiveTetrimino(pickTShape());
        } else {
            Tetrimino oldHeldTetrimino = this.heldTetrimino;
            this.heldTetrimino = this.activeTetrimino;
            this.activeTetrimino = oldHeldTetrimino;
        }

    }

    public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }

    public int getGameSpeed() {
        return dropSpeed;
    }

    public void setGameSpeed(int gameSpeed) {
        this.dropSpeed = gameSpeed;
    }

    public int getPoints() {
        return this.myBoard.getScoreBoard().getPoints();
    }

    public void addPoints(int points) {
        this.myBoard.getScoreBoard().addPoints(points);
    }

    public boolean isSoftDropActivated() {
        return softDropActivated;
    }

    public void setSoftDropActivated(boolean softDropActivated) {
        this.softDropActivated = softDropActivated;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    /**
     * Sets the gameOver attribute and will reset the model if gameOver == true.
     *
     * @author Brooke Bullek
     * @param gameOver
     */
    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
        if (gameOver) {
            // reset attributes to start a new game

        }

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
        if (gameOver) {
            return; // prevent loading new Tetriminos if the game is over
        }

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
            Resources.getSounds().get("breakSound").play();
            this.myBoard.dropLines(lines);
        }
        // change the active Tetrimino and add shape to queue
        advanceTetriminoQueue();
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

    /**
     * Returns an array of points corresponding to updated locations on the
     * gameboard if we were to move the active Tetrimino.
     *
     * @author Brooke Bullek
     * @param shiftAmountX the number of horizontal blocks to move the Tetrimino
     * @param shiftAmountY the number of vertical blocks to move the Tetrimino
     * @return an array of the new positions of the Tetrimino's blocks
     */
    public Point[] calculateNewBlockPositions(int shiftAmountX, int shiftAmountY) {
        Point newBlockPositions[] = new Point[4];
        int i = 0;
        for (Block block : activeTetrimino.getBlockArray()) {
            /* calculate the new coordinate, which is the absolute position
             * of this Tetrimino on the gameboard, plus the relative position
             * of this individual block to the Tetrimino, plus the shift amount
             */
            int newX = (int) (block.getLocation().getX()
                              + activeTetriminoLocation.getX()
                              + shiftAmountX);
            int newY = (int) (block.getLocation().getY()
                              + activeTetriminoLocation.getY()
                              + shiftAmountY);
            newBlockPositions[i] = new Point(newX, newY);
            i++;
        }
        return newBlockPositions;
    }
}
