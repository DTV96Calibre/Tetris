/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2016
 *
 * Name: Andre Amirsaleh, Brooke Bullek, Daniel Vasquez, Xizhou Li
 * Date: Apr 29, 2016
 * Time: 12:17:39 AM
 *
 * Project: csci205FinalProject
 * Package: tetris.view.GameStates
 * File: GameOverState
 * Description: Tetris enters this state when a player loses a game
 *
 * ****************************************
 */
package tetris.view.GameStates;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import tetris.controller.MainController;
import tetris.resources.Resources;

/**
 * The State entered when the player loses the game and is greeted by a Game
 * Over screen.
 *
 * @author Brooke Bullek
 */
public class GameOverState extends BasicGameState {
    /* The Controller object used to render & update entities */
    private MainController controller;

    /**
     * The "game over" animation.
     */
    private Animation gameOverAnimation;

    /**
     * Initializes a new GameOverState.
     *
     * @param gc
     * @param s
     * @throws SlickException
     */
    @Override
    public void init(GameContainer gc, StateBasedGame s) throws SlickException {
        gameOverAnimation = Resources.getAnimations().get("gameOverAnimation");
    }

    /* Getters and setters */
    @Override
    public int getID() {
        return State.GAME_OVER;
    }

    public MainController getController() {
        return controller;
    }

    public void setController(MainController controller) {
        this.controller = controller;
    }

    public Animation getGameOverAnimation() {
        return gameOverAnimation;
    }
    /* End of getters and setters */

    /**
     * Renders on-screen elements while the game is in the GameOverState.
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

    @Override
    public void update(GameContainer gc, StateBasedGame s, int delta) throws SlickException {
        // delegate this method to the game's controller
        this.controller.update(gc, s, delta);
    }
}
