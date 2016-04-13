/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amazingGame.world;

import amaingGame.Resources;
import amaingGame.Window;
import java.awt.geom.Ellipse2D;
import java.io.FileReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.newdawn.slick.Image;
import org.newdawn.slick.SpriteSheet;

/**
 *
 * @author xizhouli
 */
public class World {
    public static Image[][] solids;
    public static Image[][] portal;
    public static Ellipse2D[] collision = new Ellipse2D[4];
    public static int WIDTH;
    public static int HEIGHT;

    public static void render(float xRender, float yRender) {
        int offset = 2;
        int xStart = 0;
        int yStart = 0;
        int xEnd = Window.WIDTH / Tile.size + xStart + offset * 2;
        int yEnd = Window.HEIGHT / Tile.size + yStart + offset * 2;;

        for (int x = xStart; x < xEnd; x++) {
            for (int y = yStart; y < yEnd; y++) {
                if (solidTile(x, y)) {
                    solids[x][y].draw(x * Tile.size, y * Tile.size, Tile.size,
                                      Tile.size);
                }
                if (portalTile(x, y)) {
                    portal[x][y].draw(x * Tile.size, y * Tile.size, Tile.size,
                                      Tile.size);
                }

            }
        }
    }

    public static void load(String path) throws Exception {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader(path));
        JSONObject jsonObj = (JSONObject) obj;
        JSONArray layers = (JSONArray) jsonObj.get("layers");
        int amount = layers.size();

        for (int i = 0; i < amount; i++) {
            JSONObject layer = (JSONObject) layers.get(i);
            String type = (String) layer.get("name");
            if (type.equals("Collision")) {
                JSONArray sublayers = (JSONArray) layer.get("objects");
                int size = sublayers.size();
                for (int j = 0; j < size; j++) {
                    JSONObject sublayer = (JSONObject) sublayers.get(j);
                    if ((boolean) sublayer.get("ellipse")) {
                        WIDTH = (int) (long) sublayer.get("width");
                        HEIGHT = (int) (long) sublayer.get("height");
                        int x = (int) (long) sublayer.get("x");
                        int y = (int) (long) sublayer.get("y");
                        System.out.println(
                                WIDTH + " " + HEIGHT + " " + x + " " + y);
                        System.out.println(j);
                        Ellipse2D ellipse = new Ellipse2D.Double((double) x,
                                                                 (double) y,
                                                                 (double) WIDTH,
                                                                 (double) HEIGHT);
//                        System.out.println(ellipse == null);
                        collision[j] = ellipse;
                    }
                }

            } else if (type.equals("solids")) {
                WIDTH = (int) (long) layer.get("width");
                HEIGHT = (int) (long) layer.get("height");
                solids = parse((JSONArray) layer.get("data"));

            } else if (type.equals("portal")) {
                WIDTH = (int) (long) layer.get("width");
                HEIGHT = (int) (long) layer.get("height");
                portal = parse((JSONArray) layer.get("data"));
            }

        }

    }

    private static Image[][] parse(JSONArray arr) {
        Image[][] layer = new Image[WIDTH][HEIGHT];
        int index;
        for (int y = 0; y < WIDTH; y++) {
            for (int x = 0; x < HEIGHT; x++) {
                layer[x][y] = getSpriteImage(x, y);
            }

        }
        return layer;
    }

    private static Image getSpriteImage(int x, int y) {
        SpriteSheet sheet = Resources.getSprite(
                "tiles");
        return sheet.getSprite(x, y);
    }

    public static boolean inBounds(int x, int y) {
        return (x >= 0 && y >= 0 && x < WIDTH && y < HEIGHT);
    }

    public static boolean solidTile(int x, int y) {
        return (inBounds(x, y) && solids[x][y] != null);
    }

    public static boolean portalTile(int x, int y) {
        return (inBounds(x, y) && portal[x][y] != null);
    }

//    public static boolean hitTest(float x, float y) {
//        int xPoint = (int) ((x / Tile.scale) % Tile.small_size);
//        int yPoint = (int) ((y / Tile.scale) % Tile.small_size);
//        int x_tile = (int) (x / Tile.size);
//        int y_tile = (int) (y / Tile.size);
//        if (solidTile(x_tile, y_tile)) {
//            return solids[x_tile][y_tile].getColor(xPoint, yPoint).a > 0;
//        }
//        return false;
//    }
}
