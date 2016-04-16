/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2016
 *
 * Name: Andre Amirsaleh, Brooke Bullek, Daniel Vasquez, Xizhou Li
 * Date: Apr 10, 2016
 * Time: 11:31:09 PM
 *
 * Project: csci205FinalProject
 * Package: tetris.view
 * File: Window
 * Description:
 *
 * ****************************************
 */
package tetris.view;

/**
 *
 * @author xizhouli
 */
public class Window {
    private static int WIDTH = 640;
    private static int HEIGHT = 640;
    private static final int PIXEL_OFFSET = 32;

    public static int getWIDTH() {
        return WIDTH;
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }

    public static int getPIXEL_OFFSET() {
        return PIXEL_OFFSET;
    }

}
