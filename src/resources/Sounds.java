package resources;

import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

public class Sounds {
    public static Music BGMUSIC1;
    public static Sound REEEEEEEEE;
    public static void loadSounds()
    {
        try {
            REEEEEEEEE = new Sound("res/sounds/playcard.wav");
        }
        catch (SlickException e)
        {
            e.printStackTrace();
        }
    }
    public static void loadMusic()
    {
        try{
            BGMUSIC1 = new Music("res/music/bgmusic1.ogg");
        }
        catch (SlickException e)
        {
            e.printStackTrace();
        }
    }
}
