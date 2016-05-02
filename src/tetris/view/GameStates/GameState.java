/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2016
 *
 * Name: Andre Amirsaleh, Brooke Bullek, Daniel Vasquez, Xizhou Li
 * Date: Apr 20, 2016
 * Time: 1:45:59 PM
 *
 * Project: csci205FinalProject
 * Package: tetris.view.GameStates
 * File: HighScoresState
 * Description: The "in-game" screen
 *
 * ****************************************
 */
package tetris.view.GameStates;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import tetris.controller.MainController;
import tetris.resources.Resources;

/**
 * The state of Tetris while the game is active.
 *
 * @author Xizhou Li & Brooke Bullek
 */
public class GameState extends BasicGameState {

    /**
     * The Controller object used to render and update entities.
     */
    private MainController controller;

    /**
     * Background music that plays regardless of the state/screen the player is
     * in.
     */
    private Music music = Resources.getMusics().get("backgroundMusicRemix");

    /**
     * Background image to display on the GameBoard.
     */
    private Image background = Resources.getImages().get("background");

    /**
     * The background to render underneath these elements.
     */
    private final Image panelComponent = Resources.getImages().get(
            "gameComponent");

    /**
     * Timer that records elapsed time since the last game update.
     */
    public int timer = 0;

    /**
     * Initializes a new GameState.
     *
     * @param gc A generic game container that handles the game loop
     * @param s A State based game isolated into different stages
     * @throws SlickException
     */
    @Override
    public void init(GameContainer gc, StateBasedGame s) throws SlickException {
        music.loop();
    }

    /* Getters and setters */
    @Override
    public int getID() {
        return State.GAME.getID();
    }

    public MainController getController() {
        return controller;
    }

    public void setController(MainController controller) {
        this.controller = controller;
    }

    public Image getBackground() {
        return background;
    }

    public Image getPanelComponent() {
        return panelComponent;
    }
    /* End of getters and setters */

    /**
     * Renders on-screen elements while the game is in the GameState.
     *
     * @param gc A generic game container that handles the game loop
     * @param s A State based game isolated into different stages
     * @param g A graphics context used to render primitives to the canvas
     * @throws SlickException
     */
    @Override
    public void render(GameContainer gc, StateBasedGame s, Graphics g) throws SlickException {
        // delegate this method to the game's controller
        this.controller.render(gc, s, g);
    }

    /**
     *
     * @param gc A generic game container that handles the game loop
     * @param s A State based game isolated into different stages
     * @param delta Factor that alter the game's clock/timer
     * @throws SlickException
     */
    @Override
    public void update(GameContainer gc, StateBasedGame s, int delta) throws SlickException {
        // delegate this method to the game's controller
        this.controller.update(gc, s, delta);
    }
}
