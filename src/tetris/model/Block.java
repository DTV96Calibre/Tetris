/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.model;

import java.awt.Color;
import java.awt.Point;

/**
 * A block used in the construction of Tetriminos and other Tetris pieces.
 *
 * @author Daniel Vasquez & Brooke Bullek
 */
public class Block {
    /**
     * The color of the block.
     */
    private Color color;

    /**
     * The representation of the block's location relative to its Tetrimino.
     * This is independent from the Gameboard class(es). Every Tetrimino is
     * rotated around a center square and held within a "bounding box," and its
     * shape can be uniquely identified by a set of four points where (0, 0) is
     * the center.
     */
    private Point location;

    /**
     * The default constructor for the Block class.
     *
     * @author Daniel Vasquez
     */
    public Block() {
        this.color = null;
        this.location = null;
    }

    /**
     * The explicit constructor for the Block class. Instantiates a Block with
     * specific attributes.
     *
     * @param color the color of this block
     * @param location A Point (tuple) that stores x- and y-coordinates
     *
     * @author Daniel Vasquez & Brooke Bullek
     */
    public Block(Color color, Point location) {
        this.color = color;
        this.location = location;
    }

    /* Getters and setters */
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }
    /* End of getters and setters */
}
