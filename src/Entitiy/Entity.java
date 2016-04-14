/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitiy;

import Utility.Box;
import amaingGame.Window;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

/**
 *
 * @author xizhouli
 */
public abstract class Entity extends Box {
    public Image image;
    public Color color;

    public Entity() {
        init();

    }

    public abstract void init();

    public void render(GameContainer gc, Graphics g) {

        if (image != null) {
            image.draw(x, y, width, height, color);
        }
    }

    public abstract void update(GameContainer gc, int delta);

    public boolean testLeft() {
        return x <= 0;

    }

    public boolean testRight() {
        return x >= Window.WIDTH - 30;

    }

    public boolean testUp() {
        return y <= 0;

    }

    public boolean testDown() {
        return y >= Window.HEIGHT - 45;

    }

}
