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
 * Description: The "High Scores" screen
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
     * Constructs a new <code>HighScoresState</code> instance
     *
     * @param controller an instance of the primary controller class
     * @author Andre Amirsaleh
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
     * @author Andre Amirsaleh
     */
    @Override
    public int getID() {
        return State.HIGH_SCORES.getID();
    }

    /**
     * Automatically called by slick but doesn't do anything. (This method is
     * required for all <code>BasicGameState</code>s.)
     *
     * @param gc
     * @param sbg
     * @throws SlickException
     * @author Andre Amirsaleh
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
     * @author Andre Amirsaleh
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
    /**
     * Returns the <code>iHighScores</code> attribute
     *
     * @return An array of the high scores as <code>int</code>s
     */
    public int[] getIHighScores() {
        return iHighScores;
    }

    /**
     * Returns the <code>sHighScores</code> attribute
     *
     * @return An array of the high scores as <code>String</code>s.
     */
    public List<String> getSHighScores() {
        return sHighScores;
    }

    /**
     * Returns the <code>controller</code> attribute
     *
     * @return An instance of the primary controller class
     */
    public MainController getController() {
        return controller;
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