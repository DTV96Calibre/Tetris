/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2016
 *
 * Name: Andre Amirsaleh, Brooke Bullek, Daniel Vasquez, Xizhou Li
 * Date: Apr 13, 2016
 * Time: 12:15:47 AM
 *
 * Project: csci205FinalProject
 * Package: tetris.model
 * File: TShape
 * Description:
 *
 * ****************************************
 */
package tetris.model;

import java.awt.Color;
import java.awt.Point;

/* An enumerated class to store the seven possible arrangements of a
 * Tetrimino. These reflect the initial state of the Tetrimino upon being
 * loaded into the game as well as the Tetrimino's official color.
 *
 * @author Brooke Bullek
 */
public enum TShape {
    I_BLOCK(new Point[]{new Point(0, 0), new Point(-1, 0), new Point(1, 0),
                        new Point(2, 0)}, Color.CYAN),
    J_BLOCK(new Point[]{new Point(0, 0), new Point(-1, 0), new Point(-1, 1),
                        new Point(1, 0)}, Color.BLUE),
    L_BLOCK(new Point[]{new Point(0, 0), new Point(-1, 0), new Point(1, 0),
                        new Point(1, 1)}, Color.ORANGE),
    O_BLOCK(new Point[]{new Point(0, 0), new Point(1, 0), new Point(0, -1),
                        new Point(1, -1)}, Color.YELLOW),
    S_BLOCK(new Point[]{new Point(0, 0), new Point(-1, 0), new Point(0, 1),
                        new Point(1, 1)}, Color.GREEN),
    T_BLOCK(new Point[]{new Point(0, 0), new Point(-1, 0), new Point(1, 0),
                        new Point(0, 1)}, Color.MAGENTA),
    Z_BLOCK(new Point[]{new Point(0, 0), new Point(0, 1), new Point(1, 0),
                        new Point(-1, 1)}, Color.RED);

    // array of Points rather than array of Blocks (to reduce dependencies)
    private final Point[] minoLocations;
    // the color of this type of Tetrimino
    private final Color color;

    TShape(Point[] minoLocations, Color color) {
        this.color = color;
        this.minoLocations = minoLocations;
    }

    /* Getters and setters */
    public Point[] getMinoLocations() {
        return minoLocations;
    }

    public Color getColor() {
        return color;
    }
    /* End of getters and setters */
}
