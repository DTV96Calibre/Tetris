/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amaingGame;

import amazingGame.world.Tile;
import java.util.HashMap;
import java.util.Map;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.SpriteSheet;

/**
 *
 * @author xizhouli
 */
public class Resources {
    private static Map<String, Image> image;
    private static Map<String, SpriteSheet> sprite;
    private static Map<String, Sound> sounds;

    public Resources() {
        image = new HashMap<String, Image>();
        sprite = new HashMap<String, SpriteSheet>();
        sounds = new HashMap<String, Sound>();
        try {

            sprite.put("tiles", loadSprite(
                       "/Users/xizhouli/slick2D/my asset/gameView.png",
                       Tile.size,
                       Tile.size));

            image.put("soldier", loadImage(
                      "/Users/xizhouli/slick2D/soldier.png"));
            image.put("bomb", loadImage("/Users/xizhouli/slick2D/bomb.png"));
        } catch (SlickException ex) {
            ex.printStackTrace();
        }

    }

    public static Image loadImage(String path) throws SlickException {
        return new Image(path, false, Image.FILTER_NEAREST);
    }

    public static Image getImageFromImage(String getter) {
        return image.get(getter);
    }

    public static SpriteSheet loadSprite(String path, int tw, int th) throws SlickException {
        return new SpriteSheet(loadImage(path), tw, th);

    }

    public static SpriteSheet getSprite(String getter) {
        return sprite.get(getter);
    }

    public static Image getSpriteImage(String getter, int x, int y) {
        return sprite.get(getter).getSubImage(x, y);
    }

    public static Image image(String getter) {
        return sprite.get(getter);
    }

    public static Image getImage(String getter) {
        return sprite.get(getter);
    }

    public static Sound getSound(String getter) {
        return sounds.get(getter);
    }

}
