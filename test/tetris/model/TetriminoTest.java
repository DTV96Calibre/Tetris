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
     * @author Brooke Bullek and Xizhou Li
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

        factor = -1; // J-Block with CCW rotation
        instance = new Tetrimino(TShape.J_BLOCK);
        instance.rotate(factor);
        result = instance.getBlockArray();
        Block[] expResult0 = {new Block(TShape.J_BLOCK.getColor(),
                                        new Point(0, 0)),
                              new Block(TShape.J_BLOCK.getColor(),
                                        new Point(0, -1)),
                              new Block(TShape.J_BLOCK.getColor(),
                                        new Point(-1, -1)),
                              new Block(TShape.J_BLOCK.getColor(),
                                        new Point(0, 1))};
        assertEquals(result, expResult0);

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

        //Test L-Blcok CCW and CW rotate
        factor = -1; // CCW
        instance = new Tetrimino(TShape.L_BLOCK);
        instance.rotate(factor);
        result = instance.getBlockArray();
        Block[] expResult5 = {new Block(TShape.L_BLOCK.getColor(),
                                        new Point(0, 0)),
                              new Block(TShape.L_BLOCK.getColor(),
                                        new Point(0, -1)),
                              new Block(TShape.L_BLOCK.getColor(),
                                        new Point(0, 1)),
                              new Block(TShape.L_BLOCK.getColor(),
                                        new Point(-1, 1))};
        assertEquals(result, expResult5);

        factor = 1;

        instance.rotate(factor);
        instance.rotate(factor);
        result = instance.getBlockArray();
        Block[] expResult6 = {new Block(TShape.L_BLOCK.getColor(),
                                        new Point(0, 0)),
                              new Block(TShape.L_BLOCK.getColor(),
                                        new Point(0, 1)),
                              new Block(TShape.L_BLOCK.getColor(),
                                        new Point(0, -1)),
                              new Block(TShape.L_BLOCK.getColor(),
                                        new Point(1, -1))};
        assertEquals(result, expResult6);

        //Test L-Blcok CCW and CW rotate
        factor = -1; // CCW
        instance = new Tetrimino(TShape.T_BLOCK);
        instance.rotate(factor);
        result = instance.getBlockArray();
        Block[] expResult7 = {new Block(TShape.T_BLOCK.getColor(),
                                        new Point(0, 0)),
                              new Block(TShape.T_BLOCK.getColor(),
                                        new Point(0, -1)),
                              new Block(TShape.T_BLOCK.getColor(),
                                        new Point(0, 1)),
                              new Block(TShape.T_BLOCK.getColor(),
                                        new Point(-1, 0))};
        assertEquals(result, expResult7);

        factor = 1;

        instance.rotate(factor);
        instance.rotate(factor);
        result = instance.getBlockArray();
        Block[] expResult8 = {new Block(TShape.T_BLOCK.getColor(),
                                        new Point(0, 0)),
                              new Block(TShape.T_BLOCK.getColor(),
                                        new Point(0, 1)),
                              new Block(TShape.T_BLOCK.getColor(),
                                        new Point(0, -1)),
                              new Block(TShape.T_BLOCK.getColor(),
                                        new Point(1, 0))};
        assertEquals(result, expResult8);

        //Test L-Blcok CCW and CW rotate
        factor = -1; // CCW
        instance = new Tetrimino(TShape.Z_BLOCK);
        instance.rotate(factor);
        result = instance.getBlockArray();
        Block[] expResult9 = {new Block(TShape.Z_BLOCK.getColor(),
                                        new Point(0, 0)),
                              new Block(TShape.Z_BLOCK.getColor(),
                                        new Point(-1, 0)),
                              new Block(TShape.Z_BLOCK.getColor(),
                                        new Point(0, 1)),
                              new Block(TShape.Z_BLOCK.getColor(),
                                        new Point(-1, -1))};
        assertEquals(result, expResult9);

        factor = 1;

        instance.rotate(factor);
        instance.rotate(factor);
        result = instance.getBlockArray();
        Block[] expResult_10 = {new Block(TShape.Z_BLOCK.getColor(),
                                          new Point(0, 0)),
                                new Block(TShape.Z_BLOCK.getColor(),
                                          new Point(1, 0)),
                                new Block(TShape.Z_BLOCK.getColor(),
                                          new Point(0, -1)),
                                new Block(TShape.Z_BLOCK.getColor(),
                                          new Point(1, 1))};
        assertEquals(result, expResult_10);

    }

    /**
     * Helpful method for debugging (prints the x, y values of points)
     *
     * @param result
     * @param expResult
     */
    public void checkPoints(Block[] result, Block[] expResult) {
        for (int i = 0; i < Tetrimino.NUM_BLOCKS; i++) {
            System.out.printf("EXPECTED: (%f, %f), ",
                              expResult[i].getLocation().getX(),
                              expResult[i].getLocation().getY());
            System.out.printf("GOT: (%f, %f).\n",
                              result[i].getLocation().getX(),
                              result[i].getLocation().getY());
        }
    }

    /**
     * check instance drop, game over together
     *
     * @author Xizhou Li
     */
    @Test
    public void checkGameOver() {
        System.out.println("Game Over");
        MainModel model = new MainModel();
        GameBoard board = model.getMyBoard();
        // drop 4 vertical I shape Tetrimino has not reached Game Over
        int loop = 0;
        while (loop < 4) {
            model.setActiveTetrimino(new Tetrimino(TShape.I_BLOCK));
            model.getActiveTetrimino().rotate(-1);// rotate the L-shape Tetrimino so that it is vertical.
            model.instantDropTetrimino();
            loop++;
        }
        Boolean result = model.checkGameOver();
        Boolean expResult = false;
        assertEquals(result, expResult);
        // add another loop
        // drop 5 vertical I shape Tetrimino has reached Game Over
        model.setActiveTetrimino(new Tetrimino(TShape.I_BLOCK));
        model.getActiveTetrimino().rotate(-1);// rotate the L-shape Tetrimino so that it is vertical.
        model.instantDropTetrimino();
        result = model.checkGameOver();
        expResult = true;
        assertEquals(result, expResult);

    }

    /**
     * check if a TetriMino is still movable to the left and right
     *
     * @author Xizhou Li
     */
    @Test
    public void TestMove() {
        System.out.println("Movable");
        MainModel model = new MainModel();
        GameBoard board = model.getMyBoard();
        Tetrimino active = new Tetrimino(TShape.S_BLOCK);
        model.setActiveTetrimino(active);
        model.setActiveTetriminoLocation(new Point(1, 0));
        // If a S-Shape Tetrimino is initialized on the most left side of the board
        // it would not be able to move left
        Boolean result = model.moveActiveTetrimino(Direction.LEFT);
        Boolean expResult = false;
        assertEquals(result, expResult);

        model.instantDropTetrimino();
        active = new Tetrimino(TShape.T_BLOCK);
        // A new T-Block will not be able to move left if there's a new S-Block on his left.
        model.setActiveTetrimino(active);
        model.setActiveTetriminoLocation(new Point(3, 18));
        expResult = false;
        result = model.moveActiveTetrimino(Direction.LEFT);
        assertEquals(result, expResult);

    }
}
