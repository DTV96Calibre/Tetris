/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2016
 *
 * Name: Andre Amirsaleh, Brooke Bullek, Daniel Vasquez, Xizhou Li
 * Date: May 1, 2016
 * Time: 11:15:17 PM
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
 * @author xizhouli
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
