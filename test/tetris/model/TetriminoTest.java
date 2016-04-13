/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2016
 *
 * Name: Andre Amirsaleh, Brooke Bullek, Daniel Vasquez, Xizhou Li
 * Date: Apr 13, 2016
 * Time: 1:23:34 AM
 *
 * Project: csci205FinalProject
 * Package: tetris.model
 * File: TetriminoTest
 * Description: JUnit tests to test the functionality of methods of the
 * Tetrimino class
 *
 * ****************************************
 */
package tetris.model;

import java.awt.Point;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author btb004
 */
public class TetriminoTest {

    public TetriminoTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of rotate method, of class Tetrimino. Verifies that the rotate
     * method works both clockwise and counter-clockwise, on various Tetrimino
     * shapes, and through multiple consecutive rotations.
     *
     * @author Brooke Bullek
     */
    @Test
    public void testRotate() {
        System.out.println("rotate");

        // test a clockwise rotation on a default J-Block
        int factor = 1; // CW rotation
        Tetrimino instance = new Tetrimino(TShape.J_BLOCK);
        instance.rotate(factor);
        Block[] result = instance.getBlockArray();
        Block[] expResult = {new Block(TShape.J_BLOCK.getColor(),
                                       new Point(0, 0)),
                             new Block(TShape.J_BLOCK.getColor(),
                                       new Point(0, 1)),
                             new Block(TShape.J_BLOCK.getColor(),
                                       new Point(1, 1)),
                             new Block(TShape.J_BLOCK.getColor(),
                                       new Point(0, -1))};
        assertEquals(result, expResult);

        // test two counterclockwise rotations on a default S-block
        factor = -1; // CCW rotation
        instance = new Tetrimino(TShape.S_BLOCK);
        instance.rotate(factor);
        instance.rotate(factor);
        result = instance.getBlockArray();
        Block[] expResult1 = {new Block(TShape.S_BLOCK.getColor(),
                                        new Point(0, 0)),
                              new Block(TShape.S_BLOCK.getColor(),
                                        new Point(1, 0)),
                              new Block(TShape.S_BLOCK.getColor(),
                                        new Point(0, -1)),
                              new Block(TShape.S_BLOCK.getColor(),
                                        new Point(-1, -1))};
        assertEquals(result, expResult1);

        // test another (CW) rotation on S-block
        factor = 1;
        instance.rotate(factor);
        result = instance.getBlockArray();
        Block[] expResult2 = {new Block(TShape.S_BLOCK.getColor(),
                                        new Point(0, 0)),
                              new Block(TShape.S_BLOCK.getColor(),
                                        new Point(0, -1)),
                              new Block(TShape.S_BLOCK.getColor(),
                                        new Point(-1, 0)),
                              new Block(TShape.S_BLOCK.getColor(),
                                        new Point(-1, 1))};
        assertEquals(result, expResult2);

        // test one CCW rotation on I-block
        factor = -1;
        instance = new Tetrimino(TShape.I_BLOCK);
        instance.rotate(factor);
        result = instance.getBlockArray();
        Block[] expResult3 = {new Block(TShape.I_BLOCK.getColor(),
                                        new Point(0, 0)),
                              new Block(TShape.I_BLOCK.getColor(),
                                        new Point(0, -1)),
                              new Block(TShape.I_BLOCK.getColor(),
                                        new Point(0, 1)),
                              new Block(TShape.I_BLOCK.getColor(),
                                        new Point(0, 2))};
        assertEquals(result, expResult3);

        // now rotate I-block CW five times -- should be the same as original
        factor = 1;
        for (int i = 0; i < 5; i++) {
            instance.rotate(factor);
        }
        result = instance.getBlockArray();
        Block[] expResult4 = {new Block(TShape.I_BLOCK.getColor(),
                                        new Point(0, 0)),
                              new Block(TShape.I_BLOCK.getColor(),
                                        new Point(-1, 0)),
                              new Block(TShape.I_BLOCK.getColor(),
                                        new Point(1, 0)),
                              new Block(TShape.I_BLOCK.getColor(),
                                        new Point(2, 0))};
        assertEquals(result, expResult4);
    }

    /**
     * Helpful method for debugging (prints the x, y values of points)
     *
     * @param result
     * @param expResult
     */
    public void checkPoints(Block[] result, Block[] expResult) {
        for (int i = 0; i < Tetrimino.TETRIMINO_ARRAY_WIDTH; i++) {
            System.out.printf("EXPECTED: (%f, %f), ",
                              expResult[i].getLocation().getX(),
                              expResult[i].getLocation().getY());
            System.out.printf("GOT: (%f, %f).\n",
                              result[i].getLocation().getX(),
                              result[i].getLocation().getY());
        }
    }

}
