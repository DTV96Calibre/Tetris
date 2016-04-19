/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2016
 *
 * Name: Andre Amirsaleh, Brooke Bullek, Daniel Vasquez, Xizhou Li
 * Date: Apr 10, 2016
 * Time: 11:31:24 PM
 *
 * Project: csci205FinalProject
 * Package: tetris.view
 * File: MainView
 * Description: Contains the necessary methods to launch and run the Tetris
 * application
 * ****************************************
 */
package tetris.view;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import tetris.view.GameStates.GameStates;

/**
 * Contains the visual components that must be rendered and everything that's
 * associated with the Tetris GUI.
 *
 * @author Xizhou Li
 */
public class MainView extends StateBasedGame {

    /**
     * Constructs a new <code>MainView</code> instance
     *
     * @param name The <code>GameEngine</code>'s name
     * @author Xizhou Li
     */
    public MainView(String name) {
        super("Tetris");
    }

    /**
     * Initializes the <code>MainView</code>
     *
     * @param gc Automatically passed parameter
     * @throws SlickException
     * @author Xizhou Li
     */
    @Override
    public void initStatesList(GameContainer gc) throws SlickException {
        // The frame will update 60 time a second
        gc.setTargetFrameRate(60);
        // This implements multiwindow rendering
        gc.setAlwaysRender(true);
        // The game will update 60 times a second
        gc.setMaximumLogicUpdateInterval(60);
        //
        gc.setVSync(true);
        gc.setShowFPS(false);
        this.addState(new GameStates());
    }
}
