/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.model;

import java.awt.Color;

/**
 * A block used in the construction of tetriminos and other Tetris pieces.
 *
 * @author Daniel Vasquez
 */
public class Block {
    private Color color;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getHighlight() {
        return highlight;
    }

    public void setHighlight(Color highlight) {
        this.highlight = highlight;
    }
    private Color highlight;

    public Block() {
        this.color = null;
        this.highlight = null;
    }

    public Block(Color color, Color highlight) {
        this.color = color;
        this.highlight = highlight;
    }
}
