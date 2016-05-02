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
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import tetris.controller.MainController;
import tetris.resources.Resources;

/**
 * The State entered when the player loses the game and is greeted by a Game
 * Over screen.
 *
 * @author Brooke Bullek
 */
public class GameOverState extends BasicTetrisState {

    /**
     * The "game over" animation.
     */
    private Animation gameOverAnimation;

    /**
     * The ID associated with the GameOverState
     */
    private static final int ID = State.GAME_OVER.getID();

    public GameOverState(MainController controller) {
        super(controller);
    }

    /**
     * Initializes a new GameOverState.
     *
     * @param gc A generic game container that handles the game loop
     * @param s A State based game isolated into different stages
     * @throws SlickException
     */
    @Override
    public void init(GameContainer gc, StateBasedGame s) throws SlickException {
        gameOverAnimation = Resources.getAnimations().get("gameOverAnimation");
    }

    /* Getters and setters */
    @Override
    public int getID() {
        return ID;
    }

    public Animation getGameOverAnimation() {
        return gameOverAnimation;
    }
    /* End of getters and setters */
}
