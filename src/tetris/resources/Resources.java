/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Spring 2016
 *
 * Name: Andre Amirsaleh, Brooke Bullek, Daniel Vasquez, Xizhou Li
 * Date: Apr 23, 2016
 * Time: 4:36:27 PM
 *
 * Project: csci205FinalProject
 * Package: tetris.resources
 * File: Resources
 * Description:
 *
 * ****************************************
 */
package tetris.resources;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.UnsupportedAudioFileException;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.SpriteSheet;

/**
 *
 * @author xizhouli
 */
public class Resources {
    private static Map<String, Image> images;
    private static Map<String, Sound> sounds;
    private static Map<String, Music> musics;
    private static Map<String, Animation> animations;

    public Resources() {
        images = new HashMap<>();
        musics = new HashMap<>();
        sounds = new HashMap<>();
        animations = new HashMap<>();
        try {
            // load block assets into the resource hash maps
            images.put("red", loadImage("color blocks/red.png"));
            images.put("orange", loadImage("color blocks/orange.png"));
            images.put("green", loadImage("color blocks/green.png"));
            images.put("yellow", loadImage("color blocks/yellow.png"));
            images.put("blue", loadImage("color blocks/blue.png"));
            images.put("cyan", loadImage("color blocks/cyan.png"));
            images.put("magenta", loadImage("color blocks/magenta.png"));

            // other assets
            images.put("background", loadImage("color blocks/spaceHalf.png"));
            images.put("menuNoHighlightPlay", loadImage(
                       "color blocks/menu_bg_nohl.jpg"));
            images.put("menuHighlightPlay", loadImage(
                       "color blocks/menu_bg_hl.jpg"));
            images.put("menu", loadImage("color blocks/Tetris-logo.png"));
            images.put("play", loadImage("color blocks/play.png"));
            musics.put("backgroundMusicRemix", loadMusic(
                       "color blocks/bgremix.wav"));
            musics.put("backgroundMusic2", loadMusic("color blocks/Tetris2.wav"));
            musics.put("backgroundMusic1", loadMusic("color blocks/Tetris1.wav"));
            sounds.put("breakSound", loadSound("color blocks/break.wav"));

            // load the game over animation
            SpriteSheet gameOverSheet = new SpriteSheet(
                    "color blocks/gameOverSheet.png", 1800, 400);
            animations.put("gameOverAnimation",
                           new Animation(gameOverSheet, 200));
        } catch (SlickException ex) {
            ex.printStackTrace();
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(Resources.class.getName()).log(Level.SEVERE, null,
                                                            ex);
        } catch (IOException ex) {
            Logger.getLogger(Resources.class.getName()).log(Level.SEVERE, null,
                                                            ex);
        }
    }

    public static Map<String, Sound> getSounds() {
        return sounds;
    }

    public static Map<String, Music> getMusics() {
        return musics;
    }

    public static Map<String, Image> getImages() {
        return images;
    }

    public static Map<String, Animation> getAnimations() {
        return animations;
    }

    public static Image loadImage(String path) throws SlickException {
        String abspath = new File(path).getAbsolutePath();
        return new Image(abspath, false, Image.FILTER_NEAREST);
    }

    public static Music loadMusic(String path) throws SlickException, UnsupportedAudioFileException, IOException {
        String abspath = new File(path).getAbsolutePath();
        return new Music(path);
    }

    public static Sound loadSound(String path) throws SlickException, UnsupportedAudioFileException, IOException {
//        File file = new File(path);
//        AudioInputStream stream = AudioSystem.getAudioInputStream(
//                file.getAbsoluteFile());
//        String abspath = new File(path).getAbsolutePath();
        return new Sound(path);
    }

    public static Image getImageFromImage(String getter) {
        return images.get(getter);
    }
}
