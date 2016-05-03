/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2016
 *
 * Name: Andre Amirsaleh, Brooke Bullek, Daniel Vasquez, Xizhou Li
 * Date: May 2, 2016
 * Time: 10:20:33 PM
 *
 * Project: csci205FinalProject
 * Package: tetris.model
 * File: MainModelTest
 * Description:
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
public class MainModelTest {

    public MainModelTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of initializeBag method, of class MainModel.
     */
    @Test
    public void testInitializeBag() {
        System.out.println("initializeBag");
        MainModel instance = new MainModel();
        instance.initializeBag();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of lockActiveTetrimino method, of class MainModel.
     */
    @Test
    public void testLockActiveTetrimino() {
        System.out.println("lockActiveTetrimino");
        MainModel instance = new MainModel();
        instance.lockActiveTetrimino();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of increaseDifficulty method, of class MainModel.
     */
    @Test
    public void testIncreaseDifficulty() {
        System.out.println("increaseDifficulty");
        int lines = 0;
        MainModel instance = new MainModel();
        instance.increaseDifficulty(lines);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of holdActiveTetrimino method, of class MainModel.
     */
    @Test
    public void testHoldActiveTetrimino() {
        System.out.println("holdActiveTetrimino");
        MainModel instance = new MainModel();
        instance.holdActiveTetrimino();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculateNewBlockPositions method, of class MainModel.
     */
    @Test
    public void testCalculateNewBlockPositions() {
        System.out.println("calculateNewBlockPositions");
        int shiftAmountX = 0;
        int shiftAmountY = 0;
        MainModel instance = new MainModel();
        Point[] expResult = null;
        Point[] result = instance.calculateNewBlockPositions(shiftAmountX,
                                                             shiftAmountY);
        assertArrayEquals(expResult, result);
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
     * Test of moveActiveTetrimino method, of class MainModel.
     */
    @Test
    public void testMoveActiveTetrimino() {
        System.out.println("moveActiveTetrimino");
        Direction d = null;
        MainModel instance = new MainModel();
        boolean expResult = false;
        boolean result = instance.moveActiveTetrimino(d);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of instantDropTetrimino method, of class MainModel.
     */
    @Test
    public void testInstantDropTetrimino() {
        System.out.println("instantDropTetrimino");
        MainModel instance = new MainModel();
        instance.instantDropTetrimino();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
