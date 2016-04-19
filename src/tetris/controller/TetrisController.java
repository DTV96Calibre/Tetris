/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2016
 *
 * Name: Andre Amirsaleh, Brooke Bullek, Daniel Vasquez, Xizhou Li
 * Date: Apr 18, 2016
 * Time: 7:51:51 PM
 *
 * Project: csci205FinalProject
 * Package: tetris.controller
 * File: TetrisController
 * Description:
 *
 * ****************************************
 */
package tetris.controller;

import tetris.model.MainModel;
import tetris.view.MainView;

/**
 * The controller of the Tetris program, which syncs the model and view.
 *
 * @author Brooke Bullek
 */
public class TetrisController {
    private MainModel theModel;
    private MainView theView;

    /**
     * Constructor to instantiate a new TetrisController instance.
     *
     * @author Brooke Bullek
     * @param theModel
     * @param theView
     */
    public TetrisController(MainModel theModel, MainView theView) {
        this.theModel = theModel;
        this.theView = theView;

        // immediately update view to reflect initial state
        updateViewFromModel();
    }

    /**
     * Updates various components of theView based on the state of the model.
     *
     * @author Brooke Bullek
     */
    private void updateViewFromModel() {

    }

}
