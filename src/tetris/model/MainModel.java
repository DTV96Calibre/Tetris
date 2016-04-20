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

    /* A static randomier that picks a randon type of tetrimino from a bag of T-shapes*/
    private static Random Randomizer;

    /* A bag of 7 different types of T-shapes*/
    private ArrayList<TShape> bag = new ArrayList<TShape>();

    /* the Tetrimino that is currently being placed */
    private Tetrimino activeTetrimino;

    /* The location of the center block of the active Tetrimino RELATIVE to the
     game board
     */
    private Point activeTetriminoLocation;

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
        //initialize the Randomizer.
        Randomizer = new Random();
        //initialize the bag.
        initializeBag();
        int index = Randomizer.nextInt(7);

        // TODO: Allow for random Tetrimino instead of a block
        activeTetrimino = new Tetrimino(bag.get(index));
        bag.remove(index);

        initialTetriminoLocation = new Point(myBoard.getWidth() / 2, 1);

        // set the new Tetrimino's location to the top center of the screen
        activeTetriminoLocation = initialTetriminoLocation;
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
        int size = this.bag.size();

        // if this "grab bag" has been depleted, reset it with all 7 TShapes
        if (size == 0) {
            initializeBag();
        }

        int index = Randomizer.nextInt(size);
        TShape shape = bag.get(index);
        bag.remove(index);
        return shape;
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

    public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }
    /* End of getters and setters */
}
