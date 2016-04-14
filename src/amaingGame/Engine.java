/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amaingGame;

import amaingGame.states.GameStates;
import amaingGame.states.MenuState;
import amazingGame.world.World;
import java.io.File;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author xizhouli
 */
public class Engine extends StateBasedGame {

    /**
     * @param args the command line arguments
     */
    public static boolean _APPLET = true;

    public static void main(String[] args) {
        // TODO code application logic here
        _APPLET = false;
        // set native folder
        File file = new File("natives");
        if (file.exists()) {
            System.setProperty("org.lwjgl.librarypath", file.getAbsolutePath());
        }
        try {
            AppGameContainer game = new AppGameContainer(new Engine());
            game.setDisplayMode(Window.WIDTH, Window.HEIGHT, false);
            game.start();
        } catch (SlickException ex) {
            ex.printStackTrace();
        }
    }

    public Engine() {
        super("Amazing game");
    }

    @Override
    public void initStatesList(GameContainer gc) throws SlickException {
        // The frame will update 60 time a second
        gc.setTargetFrameRate(60);
        // This implements multiwindow rendering
        gc.setAlwaysRender(true);
        // The game will update 60 times a second
        gc.setMaximumLogicUpdateInterval(60);
        //
        gc.setVSync(true);
        gc.setShowFPS(false);

        new Resources();
        try {
            World.load(
                    "/Users/xizhouli/slick2D/my asset/gameView.json");
        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println("map does not exist");
            System.exit(0);
        }
        this.addState(new GameStates());
        this.addState(new MenuState());

    }

}
