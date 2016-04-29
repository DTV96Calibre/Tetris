/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.view.GameStates;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
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

    private Music music = Resources.getMusics().get("backgroundMusic");

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
    /* End of getters and setters */

    /**
     * Renders Tetrimino.
     *
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
