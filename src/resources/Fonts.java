package resources;

import org.newdawn.slick.SlickException;

public class Fonts {
    private static final int DEFAULT_FONT_SIZE = 256;
    public static TextFont MATCHA;

    public static void loadFonts(){
        try{
            MATCHA = TextFont.fromTTF("res/fonts/Matcha-EaLge.ttf", false, false);
        }
        catch (SlickException e)
        {
            e.printStackTrace();
        }
    }

}
