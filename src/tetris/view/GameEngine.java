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
 * File: GameEngine
 * Description: Contains the necessary methods to launch and run the Tetris
 * application
 * ****************************************
 */
package tetris.view;

import java.io.File;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import tetris.view.GameStates.GameStates;

/**
 * Contains the necessary methods to launch and run the Tetris application
 *
 * @author Xizhou Li
 */
public class GameEngine extends StateBasedGame {

    public static boolean _APPLET = true;

    /**
     * Main method to run the Tetris application
     *
     * @param args Command line arguments
     * @author Xizhou Li
     */
    public static void main(String[] args) {
        // TODO code application logic here
        _APPLET = false;
        // set native folder
        File file = new File("natives");
        if (file.exists()) {
            System.setProperty("org.lwjgl.librarypath", file.getAbsolutePath());
        }
        try {
            AppGameContainer game = new AppGameContainer(
                    new GameEngine("Tetris"));
            game.setDisplayMode(tetris.view.Window.getWIDTH(),
                                tetris.view.Window.getHEIGHT(), false);
            game.start();
        } catch (SlickException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Constructs a new <code>GameEngine</code> instance
     *
     * @param name The <code>GameEngine</code>'s name
     * @author Xizhou Li
     */
    public GameEngine(String name) {
        super("Tetris");
    }

    /**
     * Initializes the <code>GameStates</code>
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
