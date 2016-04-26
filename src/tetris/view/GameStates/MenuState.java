/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.view.GameStates;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author xizhouli
 * @see https://www.youtube.com/watch?v=EZcQe2EMJIs
 */
public class MenuState extends BasicGameState {

    /**
     * The button to start a new game
     */
    Image playNow;

    /**
     * The button to exit the program
     */
    Image exitGame;

    public MenuState(int state) {
    }

    @Override
    public int getID() {
        return state.MENU;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame s) throws SlickException {
        playNow = new Image("playImage.png");
        exitGame = new Image("exitImage");
    }

    @Override
    public void render(GameContainer gc, StateBasedGame s, Graphics g) throws SlickException {
        g.drawString("Welcome to Tetris!", 100, 50);
        playNow.draw(100, 100);
        exitGame.draw(100, 300);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame s, int delta) throws SlickException {
        int posX = Mouse.getX();
        int posY = Mouse.getY();
        if ((posX > 100 && posX < 600) && (posY > 100 && posY < 600)) {
            if (Mouse.isButtonDown(0)) {
                s.enterState(1);
            }
        }
        if (gc.getInput().isKeyPressed(Input.KEY_ENTER)) {
            s.enterState(state.GAME);
        }
    }

}
