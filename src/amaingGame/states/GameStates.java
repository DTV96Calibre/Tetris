/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amaingGame.states;

import Entitiy.Entity;
import Entitiy.Hero;
import amazingGame.world.World;
import java.util.ArrayList;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author xizhouli
 */
public class GameStates extends BasicGameState {
    public static ArrayList<Entity> entities;

    @Override
    public int getID() {
        return state.GAME;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame s) throws SlickException {
        entities = new ArrayList<Entity>();
        entities.add(new Hero());
    }

    @Override
    public void render(GameContainer gc, StateBasedGame s, Graphics g) throws SlickException {

//        Resources.getSpriteImage("tiles", 3, 3).draw(50, 50);
        g.setColor(Color.yellow);
        g.drawString("Game State, Hoorray", 200, 200);
//        g.translate(-40, -40);
        World.render(400, 400);
        int amount = entities.size();
        for (int i = 0; i < amount; i++) {
            entities.get(i).render(gc, g);
        }
        g.resetTransform();
    }

    @Override
    public void update(GameContainer gc, StateBasedGame s, int delta) throws SlickException {
        if (gc.getInput().isKeyPressed(Input.KEY_ENTER)) {
            s.enterState(state.MENU);
        }
        int amount = entities.size();
        for (int i = 0; i < amount; i++) {
            entities.get(i).update(gc, delta);
        }

    }

}
