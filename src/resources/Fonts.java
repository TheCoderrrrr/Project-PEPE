package resources;

import org.newdawn.slick.SlickException;

public class Fonts {
    private static final int DEFAULT_FONT_SIZE = 256;
    public static TextFont MATCHA;
    public static TextFont SAZIGONE;
    public static TextFont WHETHERS;
    public static TextFont COFFEEHEALINGITALIC;
    public static TextFont DOGICAPIXEL;
    public static TextFont RETROGAMING;

    public static void loadFonts(){
        try{
            MATCHA = TextFont.fromTTF("res/fonts/Matcha.ttf", false, false);
            SAZIGONE = TextFont.fromTTF("res/fonts/Sazigone.otf", false, false);
            WHETHERS = TextFont.fromTTF("res/fonts/Whethers.ttf", false, false);
            COFFEEHEALINGITALIC = TextFont.fromTTF("res/fonts/CoffeeHealingItalic.ttf", false, false);
            RETROGAMING = TextFont.fromTTF("res/fonts/RetroGaming.ttf", false, false);
            DOGICAPIXEL = TextFont.fromTTF("res/fonts/dogicapixel.ttf", false, false);
        }
        catch (SlickException e)
        {
            e.printStackTrace();
        }
    }

}
