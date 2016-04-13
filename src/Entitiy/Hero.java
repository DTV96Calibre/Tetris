/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitiy;

import amaingGame.Resources;
import static amaingGame.states.GameStates.entities;
import amazingGame.world.World;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;

/**
 *
 * @author xizhouli
 */
public class Hero extends Entity {
    private float speed = 0.2f;
    private int num_Life = 1;
    private int num_Bomb = 1;
    private int bomb_damage_level = 1;
    private boolean has_Freeze = false;

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public void setNum_Life(int num_Life) {
        this.num_Life = num_Life;
    }

    public void setNum_Bomb(int num_Bomb) {
        this.num_Bomb = num_Bomb;
    }

    public float getSpeed() {
        return speed;
    }

    public int getNum_Life() {
        return num_Life;
    }

    public int getNum_Bomb() {
        return num_Bomb;
    }

    @Override
    public void update(GameContainer gc, int delta) {
        Input input = gc.getInput();
        if (inPortal()) {
            if (input.isKeyDown(Input.KEY_W)) {
                if (!testUp()) {
                    y -= speed * delta;
                }
            } else if (input.isKeyDown(Input.KEY_S)) {
                if (!testDown()) {
                    y += speed * delta;
                }
            } else if (input.isKeyDown(Input.KEY_D)) {
                if (!testRight()) {
                    x += speed * delta;
                }
            } else if (input.isKeyDown(Input.KEY_A)) {
                if (!testLeft()) {
                    x -= speed * delta;
                }
            } else if (input.isKeyPressed(Input.KEY_SPACE)) {
                // player can only place bomb when he has more than 0 bomb
                if (this.num_Bomb > 0) {
                    Bomb bomb = this.placeBomb();
                    this.num_Bomb -= 1;
                    entities.add(bomb);
                } else {

                }

            }
        }

    }

    @Override
    public void init() {
        x = 350;
        y = 350;
        width = 30;
        height = 45;
        image = Resources.getImageFromImage("soldier");

    }

    public Bomb placeBomb() {
        Bomb bomb = new Bomb(x, y, this);
        return bomb;
    }

    public boolean inPortal() {
        int hori = (int) (x / 64);
        int verti = (int) (y / 64);
        int hori2 = (int) ((x + width) / 64);
        int verti2 = (int) ((y + height) / 64);
        if (World.portal[hori][verti] == null && World.portal[hori2][verti2] == null) {
            return false;
        } else {
            return true;
        }
    }

    // This methods implements the effect when the hero gets different gifts
    public void addLife() {

    }

    public void upgradeBomb() {

    }

    public void increase_Num_Bomb() {

    }

    public void freeze() {

    }

}
