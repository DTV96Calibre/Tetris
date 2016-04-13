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
public class ScoreBoard extends Entities {

    /**
     * The current number of points that a player has
     *
     * @author Andre Amirsaleh
     */
    private int points;

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
     * @param pointsToAdd Number of points to add
     * @author Andre Amirsaleh
     */
    public void addPoints(int pointsToAdd) {
        points += pointsToAdd;
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
