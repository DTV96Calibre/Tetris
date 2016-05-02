/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2016
 *
 * Name: Andre Amirsaleh, Brooke Bullek, Daniel Vasquez, Xizhou Li
 * Date: Apr 21, 2016
 * Time: 1:45:59 PM
 *
 * Project: csci205FinalProject
 * Package: tetris.view.GameStates
 * File: HighScoresState
 * Description: The "menu" screen
 *
 * ****************************************
 */
package tetris.view.GameStates;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import tetris.controller.MainController;
import tetris.resources.Resources;

/**
 * The state of Tetris while the main menu is active.
 *
 * @author Xizhou Li & Brooke Bullek
 */
public class MenuState extends BasicGameState {

    /**
     * The Controller object used to render and update entities.
     */
    private MainController controller;

    /**
     * Menu background image.
     */
    private Image background = Resources.getImages().get("menuNoHighlight");

    /**
     * The title logo for the menu.
     */
    private Image tetrisLogo;

    /**
     * The graphic for the Play button on the menu.
     */
    private Image playButton;

    /**
     * Initializes this MenuState
     *
     * @param gc A generic game container that handles the game loop
     * @param s A State based game isolated into different stages
     * @throws SlickException
     */
    @Override
    public void init(GameContainer gc, StateBasedGame s) throws SlickException {
        tetrisLogo = Resources.getImages().get("menu");
        playButton = Resources.getImages().get("play");
    }

    /* Getters and setters */
    @Override
    public int getID() {
        return State.MENU.getID();
    }

    public MainController getController() {
        return controller;
    }

    public void setController(MainController controller) {
        this.controller = controller;
    }

    public Image getTetrisLogo() {
        return tetrisLogo;
    }

    public Image getPlayButton() {
        return playButton;
    }

    public Image getBackground() {
        return background;
    }

    public void setBackground(Image background) {
        this.background = background;
    }
    /* End of getters and setters */

    /**
     * Renders this MenuState (renders the main menu screen)
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
     * Handles user input to update this state
     *
     * @param gc A generic game container that handles the game loop
     * @param s A State based game isolated into different stages
     * @param delta An increment of elapsed time in milliseconds
     * @throws SlickException
     */
    @Override
    public void update(GameContainer gc, StateBasedGame s, int delta) throws SlickException {
        // delegate this method to the game's controller
        controller.update(gc, s, delta);
    }
}
