/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 *
 * @author xizhouli
 */
public class GameState extends BasicGameState {
    /* The Controller object used to render & update entities */
    private MainController controller;

    /* Background music */
    private Music music = Resources.getMusics().get("backgroundMusicRemix");

    /* Background image */
    private Image background = Resources.getImages().get("background");

    /* Timer that records elapsed time since the last game update */
    public int timer = 0;

    @Override
    public void init(GameContainer gc, StateBasedGame s) throws SlickException {
        music.loop();
    }

    /* Getters and setters */
    @Override
    public int getID() {
        return state.GAME;
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
    /* End of getters and setters */

    /**
     * Renders on-screen elements while the game is in the GameState.
     *
     * @param gc A generic game container that handles the game loop
     * @param s A state based game isolated into different stages
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
