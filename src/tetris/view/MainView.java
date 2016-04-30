/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2016
 *
 * Name: Andre Amirsaleh, Brooke Bullek, Daniel Vasquez, Xizhou Li
 * Date: Apr 10, 2016
 * Time: 11:31:24 PM
 *
 * Project: csci205FinalProject
 * Package: tetris.view
 * File: MainView
 * Description: Contains the necessary methods to launch and run the Tetris
 * application
 * ****************************************
 */
package tetris.view;

import java.util.List;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import tetris.controller.MainController;
import tetris.model.GameBoard;
import tetris.resources.Resources;
import tetris.view.GameStates.GameOverState;
import tetris.view.GameStates.GameState;
import tetris.view.GameStates.HighScoresState;
import tetris.view.GameStates.MenuState;

/**
 * Contains the visual components that must be rendered and everything that's
 * associated with the Tetris GUI.
 *
 * @author Xizhou Li
 */
public class MainView extends StateBasedGame {
    // states
    private GameState gameState;
    private MenuState menuState;
    private GameOverState gameOverState;
    private HighScoresState highScoresState;

    // components
    private GameBoardComponent gameBoardComponent;
    private ScoreBoardComponent scoreBoardComponent;
    private TetriminoComponent tetriminoComponent;

    // TODO: Refactor so MainView doesn't have a dependency on MainController.
    // However, this would require a revamp of the GameState class which is
    // unfortunately integral to the Slick API
    private MainController controller;

    /**
     * Constructs as new <code>MainView</code> instance
     *
     * @param name The <code>GameEngine</code>'s name
     */
    public MainView(String name, MainController mainController) {
        super("Tetris");
        this.controller = mainController;
        initComponents();
    }

    /**
     * Initializes the components of <code>MainView</code>.
     *
     * @author Brooke Bullek
     */
    public void initComponents() {
        gameBoardComponent = new GameBoardComponent();
        scoreBoardComponent = new ScoreBoardComponent();
        tetriminoComponent = new TetriminoComponent();
    }

    /**
     * Initializes <code>MainView</code>
     *
     * @param gc A generic game container that handles the game loop
     * @throws SlickException
     * @author Xizhou Li
     */
    @Override
    public void initStatesList(GameContainer gc) throws SlickException {
        new Resources();
        // The frame will update 60 times a second
        gc.setTargetFrameRate(60);
        // This implements multiwindow rendering
        gc.setAlwaysRender(true);
        // The game will update 60 times a second
        gc.setMaximumLogicUpdateInterval(60);

        // create new game states
        gameState = new GameState();
        menuState = new MenuState();
        gameOverState = new GameOverState();
        // TODO: Make the controller a required parameter to construct a state!!
        // Rather than calling the setController method right after
        // As shown for the HighScoresState constructor below:
        highScoresState = new HighScoresState(controller);

        // associate each State object with the controller (important!)
        gameState.setController(controller);
        menuState.setController(controller);
        gameOverState.setController(controller);

        gc.setVSync(true);
        gc.setShowFPS(false);

        // add states to this MainView
        this.addState(menuState);
        this.addState(gameState);
        this.addState(gameOverState);
        this.addState(highScoresState);
    }

    /* Getters and setters */
    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public MenuState getMenuState() {
        return menuState;
    }

    public void setMenuState(MenuState menuState) {
        this.menuState = menuState;
    }

    public GameOverState getGameOverState() {
        return gameOverState;
    }

    public void setGameOverState(GameOverState gameOverState) {
        this.gameOverState = gameOverState;
    }

    public MainController getMainController() {
        return controller;
    }

    public void setMainController(MainController mainController) {
        this.controller = mainController;
    }

    public GameBoardComponent getGameBoardComponent() {
        return gameBoardComponent;
    }

    public ScoreBoardComponent getScoreBoardComponent() {
        return scoreBoardComponent;
    }

    public TetriminoComponent getTetriminoComponent() {
        return tetriminoComponent;
    }

    public HighScoresState getHighScoresState() {
        return highScoresState;
    }
    /* End of getters and setters */

    /**
     * Renders GUI elements of the Game state. This includes the scoreboard,
     * gameboard, Tetrimino, static blocks, etc.
     *
     * @author Xizhou Li and Brooke Bullek
     * @param gc A generic game container that handles the game loop
     * @param g A graphics context used to render primitives to the canvas
     */
    public void renderGameState(GameContainer gc, Graphics g) {
        // draw the background underneath the game elements
        gameState.getBackground().draw(0, 0,
                                       GameBoard.WIDTH * Window.PIXEL_OFFSET,
                                       GameBoard.HEIGHT * Window.PIXEL_OFFSET);

        scoreBoardComponent.render(gc, g); // draw the ScoreBoard
        tetriminoComponent.render(gc, g); // draw the active Tetrimino
        gameBoardComponent.render(gc, g); // draw the GameBoard
    }

    /**
     * Renders GUI elements of the Menu state. This includes the title logo and
     * various buttons.
     *
     * @author Xizhou Li and Brooke Bullek
     * @param gc A generic game container that handles the game loop
     * @param g A graphics context used to render primitives to the canvas
     */
    public void renderMenuState(GameContainer gc, Graphics g) {
        // draw the menu's background
        menuState.getBackground().draw(0, 0, Window.WIDTH, Window.HEIGHT);

        menuState.getTetrisLogo().draw(
                Window.WIDTH / 2 - (int) (Window.WIDTH / 5.33),
                Window.HEIGHT / 12, 240, 160);
//        menuState.getPlayButton().draw(
//                Window.WIDTH / 2 - (int) (Window.WIDTH / 6.33),
//                Window.HEIGHT / 2, 194, 200);
    }

    /**
     * Renders GUI elements of the Game Over state. This includes a game over
     * animation overlay and the regular GameState elements.
     *
     * @author Brooke Bullek
     * @param gc A generic game container that handles the game loop
     * @param g A graphics context used to render primitives to the canvas
     */
    public void renderGameOverState(GameContainer gc, Graphics g) {
        renderGameState(gc, g); // draw the underlying components first

        // render the GameOver screen components over the gameboard
        int widthOffset = 0;
        int heightOffset = Window.HEIGHT / 3;
        int animationWidth = Window.WIDTH / 2;
        int animationHeight = animationWidth / 4;
        gameOverState.getGameOverAnimation().draw(widthOffset, heightOffset,
                                                  animationWidth,
                                                  animationHeight);
    }

    /**
     * Renders the high scores screen
     *
     * @param gc
     * @param g
     * @author Andre Amirsaleh
     */
    public void renderHighScoresState(GameContainer gc, Graphics g) {
        // Draw title:
        int xTitleLoc = 0;
        int yTitleLoc = 0;
        g.setColor(Color.pink);
        g.drawString("High Scores", xTitleLoc, yTitleLoc);

        // Draw high scores and rankings
        int[] iHighScores = highScoresState.getIHighScores();
        List<String> sHighScores = highScoresState.getSHighScores();
        int rank = 0;
        int yRankLoc = yTitleLoc + 20;
        int xRankLoc = xTitleLoc;
        String sRank;
        for (String sScore : sHighScores) {
            yRankLoc += 20;
            rank++;
            sRank = String.valueOf(rank);
            if (rank < 10) {
                sRank = " " + sRank;
            }
            g.drawString(sRank, xRankLoc, yRankLoc); // Draws rank (integer)

            // Now draw score next to rank:
            g.drawString(sScore, xRankLoc + 40, yRankLoc);
        }
    }
}
