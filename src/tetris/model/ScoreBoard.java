/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2016
 *
 * Name: Andre Amirsaleh, Brooke Bullek, Daniel Vasquez, Xizhou Li
 * Date: Apr 9, 2016
 * Time: 5:26:33 PM
 *
 * Project: csci205FinalProject
 * Package: tetris.model
 * File: ScoreBoard
 * Description: Class that represents the score board.
 *
 * ****************************************
 */
package tetris.model;

/**
 * Contains data and methods for the score board
 *
 * @author Andre Amirsaleh
 */
public class ScoreBoard {

    /**
     * Your current score.
     */
    private int points;

    /**
     * The number of points you get for clearing a line.
     */
    private final int POINTS_PER_LINE = 1;

    /**
     * Constructs a new <code>ScoreBoard</code> instance
     *
     * @author Andre Amirsaleh
     */
    public ScoreBoard() {
        points = 0;
    }

    /**
     * Adds points to the <code>points</code> attribute
     *
     * @author Andre Amirsaleh and Xizhou Li
     */
    public void addPoints() {
        this.points += this.POINTS_PER_LINE;
    }

    /**
     * Returns the <code>points</code> attribute
     *
     * @return Current number of points that a player has
     * @author Andre Amirsaleh
     */
    public int getPoints() {
        return points;
    }

}
