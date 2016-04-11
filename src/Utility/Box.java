/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

/**
 *
 * @author xizhouli
 */
public class Box {
    public float x, y, width, height;

    public Box() {

    }

    public Box(float x, float y, float height, float width) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public float getEndX() {
        return x + width;

    }

    public float getEndY() {
        return y + height;
    }

    public float getHalfHeight() {
        return height / 2;
    }

    public float getHalfWidth() {
        return width / 2;

    }

    public float getCenterX() {
        return x + getHalfWidth();
    }

    public float getCenterY() {
        return y + getHalfHeight();
    }

    public boolean hitBox(Box b) {
        return b.getEndX() >= x && b.getEndY() >= y && this.getEndX() >= b.x && this.getEndY() >= b.y;
    }
}
