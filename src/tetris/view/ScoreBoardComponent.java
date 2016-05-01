/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2016
 *
 * Name: Andre Amirsaleh, Brooke Bullek, Daniel Vasquez, Xizhou Li
 * Date: Apr 29, 2016
 * Time: 4:25:27 AM
 *
 * Project: csci205FinalProject
 * Package: tetris.view
 * File: ScoreBoardComponent
 * Description: The Component class for ScoreBoard
 *
 * ****************************************
 */
package tetris.view;

import static org.newdawn.slick.Color.white;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import tetris.model.ScoreBoard;

/**
 * Possesses the capability to render a ScoreBoard on the screen.
 *
 * @author Brooke Bullek
 */
public class ScoreBoardComponent {
    /* The ScoreBoard to be rendered by this component */
    private ScoreBoard scoreBoard;

    /**
     * The constructor for the ScoreBoardComponent class.
     */
    public ScoreBoardComponent() {
        scoreBoard = null;
    }

    /* Getters and setters */
    public ScoreBoard getScoreBoard() {
        return scoreBoard;
    }

    public void setScoreBoard(ScoreBoard scoreBoard) {
        this.scoreBoard = scoreBoard;
    }
    /* End of getters and setters */

    /**
     * Renders the ScoreBoard.
     *
     * @author Andre Amirsaleh
     * @param gc A generic game container that handles the game loop
     * @param g A graphics context used to render primitives to the canvas
     * @throws org.newdawn.slick.SlickException
     */
    public void render(GameContainer gc, Graphics g) throws SlickException {
        String points = String.valueOf(scoreBoard.getPoints());
        g.setColor(white);
        g.drawString(points, Window.BLOCK_PIXEL_OFFSET * 14, 30);
    }
}
