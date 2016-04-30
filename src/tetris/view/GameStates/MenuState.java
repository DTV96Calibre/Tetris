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
 *
 * @author Xizhou Li
 */
public class MenuState extends BasicGameState {
    /* The Controller object used to render & update entities */
    private MainController controller;

    /* Menu background image */
    private Image background = Resources.getImages().get("menuNoHighlightPlay");

    /* The title logo for the menu */
    private Image tetrisLogo;

    /* The graphic for the Play button on the menu */
    private Image playButton;

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

    @Override
    public void render(GameContainer gc, StateBasedGame s, Graphics g) throws SlickException {
        // delegate this method to the game's controller
        this.controller.render(gc, s, g);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame s, int delta) throws SlickException {
        // delegate this method to the game's controller
        controller.update(gc, s, delta);
    }
}
