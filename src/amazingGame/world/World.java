/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amazingGame.world;

import amaingGame.Resources;
import amaingGame.Window;
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
            if (type.equals("spawns")) {

            } else if (type.equals("solids")) {
                WIDTH = (int) (long) layer.get("width");
                HEIGHT = (int) (long) layer.get("height");
                solids = parse((JSONArray) layer.get("data"));

            } else if (type.equals("monsters")) {

            }

        }

    }

    private static Image[][] parse(JSONArray arr) {
        Image[][] layer = new Image[WIDTH][HEIGHT];
        int index;
        for (int y = 0; y < WIDTH; y++) {
            for (int x = 0; x < HEIGHT; x++) {
                index = (int) (long) arr.get((y * WIDTH) + x);
                layer[x][y] = getSpriteImage(index);

            }

        }
        return layer;
    }

    private static Image getSpriteImage(int index) {
        if (index == 0) {
            return null;
        }
        index -= 1;
        SpriteSheet sheet = Resources.getSprite(
                "tiles");
        int vertical = sheet.getVerticalCount();
        int horizontal = sheet.getHorizontalCount();
        int y = (index / vertical);
        int x = (index & horizontal);
        return sheet.getSubImage(x, y);

    }

    public static boolean inBounds(int x, int y) {
        return (x >= 0 && y >= 0 && x < WIDTH && y < WIDTH);
    }

    public static boolean solidTile(int x, int y) {
        return (inBounds(x, y) && solids[x][y] != null);
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
