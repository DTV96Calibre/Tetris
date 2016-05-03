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
import java.util.ArrayList;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
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
     *
     * @author Brooke Bullek
     */
    @Test
    public void testInitializeBag() {
        System.out.println("initializeBag");
        MainModel model = new MainModel();
        ArrayList<TShape> instance = model.getBag();

        // verify each TShape is present within the bag
        for (TShape shape : TShape.values()) {
            assertTrue(instance.contains(shape));
        }
    }

    /**
     * Test of lockActiveTetrimino method, of class MainModel.
     *
     * @author Brooke Bullek
     */
    @Test
    public void testLockActiveTetrimino() {
        System.out.println("lockActiveTetrimino");
        MainModel instance = new MainModel();
        instance.setActiveTetrimino(TShape.I_BLOCK);
        instance.instantDropTetrimino();
        instance.lockActiveTetrimino();

        // verify the I-Block's locked position in the gameboard
        Point[] positions = {new Point(4, 19), new Point(5, 19), new Point(6, 19), new Point(
                             7, 19)};
        for (Point point : positions) {
            // assert there is a block here
            assertTrue(instance.getMyBoard().getTheBoard() != null);
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
     * Test of moveActiveTetrimino method, of class MainModel.
     *
     * @author Brooke Bullek & Xizhou Li
     */
    @Test
    public void testMoveActiveTetrimino() {
        System.out.println("moveActiveTetrimino");
        Direction d = Direction.DOWN;
        MainModel instance = new MainModel();

        // put blocks in the gameboard so the path is obstructed
        GameBoard instanceBoard = new GameBoard();
        for (int i = 0; i < GameBoard.WIDTH; i++) {
            for (int j = 2; i < GameBoard.HEIGHT; i++) {
                // all but the first two rows have blocks
                instanceBoard.setBlock(j, j, new Block("red", new Point(0, 0)));
            }
        }
        instance.setMyBoard(instanceBoard);

        boolean expResult = true;
        boolean result = instance.moveActiveTetrimino(d); // move down
        assertEquals(expResult, result);

        MainModel model = new MainModel();
        GameBoard board = model.getMyBoard();
        Tetrimino active = new Tetrimino(TShape.S_BLOCK);
        model.setActiveTetrimino(active);
        model.setActiveTetriminoLocation(new Point(1, 0));
        // If a S-Shape Tetrimino is initialized on the most left side of the board
        // it would not be able to move left
        result = model.moveActiveTetrimino(Direction.LEFT);
        expResult = false;
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

    /**
     * Test of instantDropTetrimino method, of class MainModel.
     *
     * @author Xizhou Li
     */
    @Test
    public void testInstantDropTetrimino() {
        System.out.println("instantDropTetrimino");
        MainModel model = new MainModel();
        GameBoard board = model.getMyBoard();
        Tetrimino active = new Tetrimino(TShape.S_BLOCK);
        model.setActiveTetrimino(active);
        model.setActiveTetriminoLocation(new Point(1, 0));
        model.instantDropTetrimino();
        active = new Tetrimino(TShape.T_BLOCK);
        // A new T-Block will not be able to move left if there's a new S-Block on his left.
        model.setActiveTetrimino(active);
        model.setActiveTetriminoLocation(new Point(3, 18));
        boolean expResult = false;
        boolean result = model.moveActiveTetrimino(Direction.LEFT);
        assertEquals(result, expResult);
    }
}
