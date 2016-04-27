/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.view.GameStates;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import tetris.resources.Resources;

/**
 *
 * @author xizhouli
 */
public class MenuState extends BasicGameState {

    @Override
    public int getID() {
        return state.MENU;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame s) throws SlickException {
    }

    @Override
    public void render(GameContainer gc, StateBasedGame s, Graphics g) throws SlickException {
        Resources.getImages().get("menu").draw(200, 100, 240, 160);
        Resources.getImages().get("play").draw(223, 300, 194, 200);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame s, int delta) throws SlickException {
        if (gc.getInput().isKeyPressed(Input.KEY_ENTER)) {
            s.enterState(state.GAME);
        }
    }

}
