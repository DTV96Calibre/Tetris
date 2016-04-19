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
import tetris.controller.MainController;
import tetris.view.GameStates.GameStates;

/**
 * Contains the visual components that must be rendered and everything that's
 * associated with the Tetris GUI.
 *
 * @author Xizhou Li
 */
public class MainView extends StateBasedGame {
    private GameStates gameStates;

    // TODO: Refactor so MainView doesn't have a dependency on MainController.
    // However, this would require a revamp of the GameState class which is
    // unfortunately integral to the Slick API
    private MainController controller;

    /**
     * Constructs a new <code>MainView</code> instance
     *
     * @param name The <code>GameEngine</code>'s name
     * @author Xizhou Li
     */
    public MainView(String name, MainController mainController) {
        super("Tetris");
        this.controller = mainController;
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
        gameStates = new GameStates();
        // associate this GameStates object with the controller (important!)
        gameStates.setController(controller);
        gc.setVSync(true);
        gc.setShowFPS(false);
        this.addState(gameStates);
    }

    /* Getters and setters */
    public GameStates getGameStates() {
        return gameStates;
    }

    public void setGameStates(GameStates gameStates) {
        this.gameStates = gameStates;
    }

    public MainController getMainController() {
        return controller;
    }

    public void setMainController(MainController mainController) {
        this.controller = mainController;
    }
    /* End of getters and setters */
}
