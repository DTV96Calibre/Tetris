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
 * Description:
 *
 * ****************************************
 */
package tetris.view.GameStates;

/**
 * A collection of states that represent allowable game screens/modes.
 *
 * @author xizhouli
 */
// TODO: THIS CLASS SHOULD TOTALLY BE AN ENUM!!!
public class state {
    public static final int GAME = 0;
    public static final int MENU = 1;
    public static final int GAME_OVER = 2;

    /**
     * The ID for the <code>HighScoresState</code>
     */
    public static final int HIGH_SCORES = 3;
}
