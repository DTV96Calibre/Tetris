/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.view.GameStates;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
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
public class GameStates extends BasicGameState {
    /* The Controller object used to render & update entities */
    private MainController controller;
    private Music music = Resources.getMusics().get("backgroundMusic");

//    public static ArrayList<Tetrimino> entities;
//    public int x = 10;
//    public int y = 10;
//    public int side = 10;
    public int timer = 0;

    @Override
    public int getID() {
        return state.GAME;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame s) throws SlickException {
        music.loop();
    }

    /* Getters and setters */
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
        this.controller.render(gc, s, g);
        //        g.setColor(Color.cyan);
        //        g.drawRect(x, y, 10, 10);
        //        g.drawRect(x + 10, y, 10, 10);
        //        g.drawRect(x, y + 10, 10, 10);
        //        g.drawRect(x + 10, y + 10, 10, 10);
        //        int amount = entities.size();
        //        for (int i = 0; i < amount; i++) {
        //            entities.get(i).render(gc, g);
        //        }
        //        g.resetTransform();
    }

    @Override
    public void update(GameContainer gc, StateBasedGame s, int delta) throws SlickException {
        if (gc.getInput().isKeyPressed(Input.KEY_ENTER)) {

            s.enterState(state.MENU);
        }
        this.controller.update(gc, s, delta);
//        for (int i = 0; i < entities.size(); i++) {
//            entities.get(i).update(gc, delta);
//        }
//        int amount = entities.size();
//        for (int i = 0; i < amount; i++) {
//            entities.get(i).update(gc, delta);
//        }
//        if (timer <= 1000) {
//            timer += delta;
//        } else {
//
//            y += 10;
//            timer = 0;
//
//        }
    }

}
