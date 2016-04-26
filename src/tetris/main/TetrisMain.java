/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.main;

import java.io.File;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;
import tetris.controller.MainController;
import tetris.model.MainModel;
import tetris.view.MainView;
import tetris.view.Window;

/**
 * Contains the necessary methods to launch and run the Tetris application
 *
 * @author Xizhou Li
 */
public class TetrisMain {
    public static boolean _APPLET = true;

    /**
     * Main method to run the Tetris application
     *
     * @param args Command line arguments
     * @author Xizhou Li
     */
    public static void main(String[] args) {
        _APPLET = false;
        File file = new File("natives");
        if (file.exists()) {
            System.setProperty("org.lwjgl.librarypath", file.getAbsolutePath());
        }
        try {

            // instantiate the model, view & controller
            MainModel theModel = new MainModel();
            MainView theView = new MainView("Tetris", null);
            MainController theController = new MainController(theModel, theView);
            theView.setMainController(theController);

            AppGameContainer game = new AppGameContainer(theView);
            game.setDisplayMode(Window.getWIDTH(), Window.getHEIGHT(), false);
            game.start();
        } catch (SlickException ex) {
            ex.printStackTrace();
        }
    }
}
