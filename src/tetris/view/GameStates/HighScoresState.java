/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2016
 *
 * Name: Andre Amirsaleh, Brooke Bullek, Daniel Vasquez, Xizhou Li
 * Date: Apr 29, 2016
 * Time: 1:45:59 PM
 *
 * Project: csci205FinalProject
 * Package: tetris.view.GameStates
 * File: HighScoresState
 * Description: Implementation of the high score screen
 *
 * ****************************************
 */
package tetris.view.GameStates;

import java.util.ArrayList;
import java.util.List;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import tetris.controller.MainController;
import tetris.utility.HighScoresUtility;

/**
 * Displays the high scores
 *
 * @author Andre Amirsaleh
 */
public class HighScoresState extends BasicGameState {

    /**
     * An array of the high scores as <code>int</code>s.
     */
    private int[] iHighScores;

    /**
     * An array of the high scores as Strings.
     */
    private List<String> sHighScores;

    /**
     * An instance of the primary controller class.
     */
    private MainController controller;

    /**
     * The number of high scores to display.
     */
    private static final int NUM_SCORES_TO_DISPLAY = 10;

    /**
     * Constructs a new <code>HighScoresState</code> instance
     *
     * @param controller an instance of the primary controller class
     */
    public HighScoresState(MainController controller) {
        this.controller = controller;
        iHighScores = HighScoresUtility.getHighScores();
        sHighScores = new ArrayList<>();
        String sScore;
        for (int iScore : iHighScores) {
            sScore = String.valueOf(iScore);
            sHighScores.add(sScore);
        }
    }

    /**
     * Returns the <code>HighScoresState</code> ID
     *
     * @return Integer representing the <code>HighScoresState</code>
     */
    @Override
    public int getID() {
        return state.HIGH_SCORES;
    }

    /**
     * Automatically called by slick but doesn't do anything
     *
     * @param gc
     * @param sbg
     * @throws SlickException
     */
    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
    }

    /**
     * Renders the High Score screen. This method merely calls the
     * <code>controller</code>'s render method.
     *
     * @param gc
     * @param sbg
     * @param grphcs
     * @throws SlickException
     */
    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs) throws SlickException {
        this.controller.render(gc, sbg, grphcs);
    }

    /**
     * Handles user input (mouse clicks) in the high score screen to go back to
     * the main menu screen. This method merely calls the <code>controller<code>'s
     * update method.
     *
     * @param gc
     * @param sbg
     * @param i
     * @throws SlickException
     */
    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        this.controller.update(gc, sbg, i);
    }

    // *************************************************************************
    // GETTERS/SETTERS:
    // *************************************************************************
    public int[] getIHighScores() {
        return iHighScores;
    }

    public List<String> getSHighScores() {
        return sHighScores;
    }

    public MainController getController() {
        return controller;
    }

    public static int getNumScoresToDisplay() {
        return NUM_SCORES_TO_DISPLAY;
    }

    public void setHighScores(int[] newHighScores) {
        this.iHighScores = newHighScores;
        String sHighScore;
        for (int i = 0; i < this.iHighScores.length; i++) {
            sHighScore = String.valueOf(this.iHighScores[i]);
            this.sHighScores.set(i, sHighScore);
        }
    }

    public void setController(MainController controller) {
        this.controller = controller;
    }
}
