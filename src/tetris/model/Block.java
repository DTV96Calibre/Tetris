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
    /**
     * The color of the block.
     */
    private Color color;

    /**
     * The color of the block's highlight.
     *
     * null if the block should not be highlighted. Highlighting is used to
     * indicated whether or not the block should be in the foreground or on the
     * same plane as the rest of the board.
     *
     * TODO: Highlighting could be implemented by drawing a block of the
     * highlight color with a slightly larger size behind the block.
     */
    private Color highlight;

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

    public Block() {
        this.color = null;
        this.highlight = null;
    }

    public Block(Color color, Color highlight) {
        this.color = color;
        this.highlight = highlight;
    }
}
