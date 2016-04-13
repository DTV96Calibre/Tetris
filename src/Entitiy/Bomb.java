/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitiy;

import amaingGame.Resources;
import amaingGame.states.GameStates;
import org.newdawn.slick.GameContainer;

/**
 *
 * @author xizhouli
 */
public class Bomb extends Entity {
    private static int timer;
    // The owner attribute defines which owner this bomb belongs to
    private Hero owner;

    public Bomb(float x, float y, Hero owner) {
        init(x, y);
        Bomb.timer = 0;
        this.owner = owner;
    }

    public void init(float x, float y) {
        this.x = x;
        this.y = y;
        this.width = 32;
        this.height = 32;
    }

    @Override
    public void update(GameContainer gc, int delta) {
        if (timer <= 3000) {
            timer += delta;
        } else {
            GameStates.entities.remove(this);
            owner.setNum_Bomb(owner.getNum_Bomb() + 1);
        }

    }

    @Override
    public void init() {
        x = 100;
        y = 100;
        width = 32;
        height = 32;
        image = Resources.getImageFromImage("bomb");
    }
}
