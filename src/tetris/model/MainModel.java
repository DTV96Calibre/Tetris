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

        // TODO: Allow for random Tetrimino instead of an I-block
        activeTetrimino = new Tetrimino(TShape.I_BLOCK);

        initialTetriminoLocation = new Point(myBoard.getWidth() / 2, 1);

        // set the new Tetrimino's location to the top center of the screen
        activeTetriminoLocation = initialTetriminoLocation;
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

    /**
     * Check to see whether the active Tetrimino may be moved down 1 unit on the
     * gameboard.
     *
     * @authors Daniel Vasquez & Brooke Bullek
     */
    public void moveTetriminoDown() {
        // iterate through blocks & determine if the proposed new space is occupied
        for (Block block : activeTetrimino.getBlockArray()) {
            // maintain x coordinate
            int newX = (int) (block.getLocation().getX() + activeTetriminoLocation.getX());
            // Get new y location for block by adding 1 to y coordinate
            int newY = (int) (block.getLocation().getY() + activeTetriminoLocation.getY() + 1);

            if (newY >= myBoard.getHeight()) {
                return;
            }

            if (myBoard.getBlockArray()[newX][newY] != null) {
                return;
            }
        }

        // Update Tetrimino location relative to the gameboard
        this.activeTetriminoLocation.y += 1;
    }
}
