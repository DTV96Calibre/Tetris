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
 * Description: Images, sounds, songs, and animations
 *
 * ****************************************
 */
package tetris.resources;

import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
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
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.util.ResourceLoader;

/**
 * Collects all of the game assets for reference.
 *
 * @author Xizhou Li & Brooke Bullek
 */
public class Resources {

    /**
     * Image files
     */
    private static Map<String, Image> images;

    /**
     * Sounds files
     */
    private static Map<String, Sound> sounds;

    /**
     * Music files
     */
    private static Map<String, Music> musics;

    /**
     * Animation files
     */
    private static Map<String, Animation> animations;

    /**
     * font files
     */
    private static Map<String, TrueTypeFont> fonts;

    /**
     * Constructs a new Resources instance
     */
    public Resources() {
        images = new HashMap<>();
        musics = new HashMap<>();
        sounds = new HashMap<>();
        animations = new HashMap<>();
        fonts = new HashMap<>();
        try {
            collectImages(); // put images into the image hashmap
            collectSounds(); // put sounds into the sound hashmap
            collectMusic(); // put music into the music hashmap
            collectAnimations(); // put animations into the animation hashmap
            collectFonts(); // put fonts into the font hashmap
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

    /* Getters and setters */
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

    public static Map<String, TrueTypeFont> getFonts() {
        return fonts;
    }

    public static Image getImageFromImage(String getter) {
        return images.get(getter);
    }
    /* End of getters and setters */

    /**
     * Loads an image from the directory given a relative path so that it can be
     * used within the game.
     *
     * @author Xizhou Li
     * @param path A relative path from the root of the project directory
     * @return An Image object
     * @throws SlickException
     */
    public static Image loadImage(String path) throws SlickException {
        String abspath = new File(path).getAbsolutePath();
        return new Image(abspath, false, Image.FILTER_NEAREST);
    }

    /**
     * Loads music (as a .wav) from the directory so that it can be used within
     * the game.
     *
     * @author Xizhou Li
     * @param path A relative path from the root of the project directory
     * @return A Music object
     * @throws SlickException
     * @throws UnsupportedAudioFileException
     * @throws IOException
     */
    public static Music loadMusic(String path) throws SlickException, UnsupportedAudioFileException, IOException {
        String abspath = new File(path).getAbsolutePath();
        return new Music(path);
    }

    /**
     * Loads a sound (as a .wav) from the directory so that it can be used
     * within the game.
     *
     * @author Xizhou Li
     * @param path A relative path from the root of the project directory
     * @return A Sound object
     * @throws SlickException
     * @throws UnsupportedAudioFileException
     * @throws IOException
     */
    public static Sound loadSound(String path) throws SlickException, UnsupportedAudioFileException, IOException {
        return new Sound(path);
    }

    /**
     * Loads a custom font from a .ttf file into the game's default font.
     *
     * @author Brooke Bullek
     * @see
     * <a href="http://wiki.lwjgl.org/wiki/Slick-Util_Library_-_Part_3_-_TrueType_Fonts_for_LWJGL">
     * http://wiki.lwjgl.org/wiki/Slick-Util_Library_-_Part_3_-_TrueType_Fonts_for_LWJGL</a>
     * @param path The relative path to the .ttf file
     * @param fontSize the size of the font to create
     * @return A TrueTypeFont object which can be used to set the font of
     * Slick's Graphics object when drawing strings
     */
    public static TrueTypeFont loadFont(String path, float fontSize) {
        TrueTypeFont font = null;
        // load font from a .ttf file
        try {
            InputStream inputStream = ResourceLoader.getResourceAsStream(
                    path);
            Font awtFont = Font.createFont(Font.TRUETYPE_FONT, inputStream);
            awtFont = awtFont.deriveFont(fontSize); // set font size
            font = new TrueTypeFont(awtFont, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return font;
    }

    /**
     * Collects all of the relevant images from the project directory and places
     * them into Resource's image hashmap.
     *
     * @author Xizhou Li & Brooke Bullek
     * @throws org.newdawn.slick.SlickException
     */
    public static void collectImages() throws SlickException {
        // load block graphics
        images.put("red", loadImage("res/red.png"));
        images.put("orange", loadImage("res/orange.png"));
        images.put("green", loadImage("res/green.png"));
        images.put("yellow", loadImage("res/yellow.png"));
        images.put("blue", loadImage("res/blue.png"));
        images.put("cyan", loadImage("res/cyan.png"));
        images.put("magenta", loadImage("res/magenta.png"));

        // load menu backgrounds
        images.put("background", loadImage("res/spaceHalf.png"));
        images.put("menuNoHighlight", loadImage(
                   "res/menu_bg_nohl.png"));
        images.put("menuHighlightPlay", loadImage(
                   "res/menu_bg_hl_play.png"));
        images.put("menuHighlightScores", loadImage(
                   "res/menu_bg_hl_scores.png"));
        images.put("menuHighlightExit", loadImage(
                   "res/menu_bg_hl_exit.png"));

        // load high scores backgrounds
        images.put("backgroundScores", loadImage(
                   "res/high_scores_bg.png"));
        images.put("backgroundScoresHighLight", loadImage(
                   "res/high_scores_bg_hl.png"));

        // load panel component for the game state
        images.put("gameComponent", loadImage(
                   "res/game_component.png"));

        // load Tetris logo
        images.put("menu", loadImage("res/Tetris-logo.png"));
    }

    /**
     * Collects all of the relevant sounds from the project directory and places
     * them into Resource's sound hashmap.
     *
     * @author Xizhou Li
     * @throws SlickException
     * @throws javax.sound.sampled.UnsupportedAudioFileException
     * @throws java.io.IOException
     */
    public static void collectSounds() throws SlickException, UnsupportedAudioFileException, IOException {
        sounds.put("breakSound", loadSound("res/break.wav"));
    }

    /**
     * Collects all of the relevant music from the project directory and places
     * them into Resource's music hashmap.
     *
     * @author Xizhou Li & Brooke Bullek
     * @throws org.newdawn.slick.SlickException
     * @throws javax.sound.sampled.UnsupportedAudioFileException
     * @throws java.io.IOException
     */
    public static void collectMusic() throws SlickException, UnsupportedAudioFileException, IOException {
        musics.put("backgroundMusicRemix", loadMusic(
                   "res/bgremix.wav"));
        musics.put("backgroundMusic2", loadMusic("res/Tetris2.wav"));
        musics.put("backgroundMusic1", loadMusic("res/Tetris1.wav"));
    }

    /**
     * Collects all of the relevant animations from the project directory and
     * places them into Resource's animation hashmap.
     *
     * @author Brooke Bullek
     * @throws SlickException
     */
    public static void collectAnimations() throws SlickException {
        // load the game over animation
        SpriteSheet gameOverSheet = new SpriteSheet(
                "res/gameOverSheet.png", 1800, 400);
        animations.put("gameOverAnimation",
                       new Animation(gameOverSheet, 200));
    }

    /**
     * Collects all of the relevant fonts from the project directory and places
     * them into Resource's font hashmap.
     *
     * @author Brooke Bullek
     */
    public static void collectFonts() {
        // load the font for the active score of the game window
        fonts.put("activeHighScore", loadFont("res/digitalism.ttf", 40f));

        // load the font for the high scores screen
        fonts.put("oldHighScore", loadFont("res/digitalism.ttf", 30f));
        fonts.put("scoreRetro", loadFont("res/prstartk.ttf", 15f));
    }
}
