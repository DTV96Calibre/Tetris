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
    private static final Point INITIAL_TETRIMINO_LOCATION = new Point(
            GenericBoard.getWIDTH() / 2, 0);

    /* The active game board for this game */
    public GenericBoard myBoard;

    /* the Tetrimino that is currently being placed */
    private Tetrimino activeTetrimino;

    /* The location of the center block of the active Tetrimino RELATIVE to the
     game board
     */
    private Point activeTetriminoLocation;

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

        // set the new Tetrimino's location to the top center of the screen
        activeTetriminoLocation = INITIAL_TETRIMINO_LOCATION;
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
    /* End of getters and setters */
}
