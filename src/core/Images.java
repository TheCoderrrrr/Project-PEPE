package core;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Images {

    public static Image PLACEHOLDERCARD;
    public static void loadImages()
    {
        try
        {
            PLACEHOLDERCARD = new Image("res/images/cards/card_template.png");

        }
        catch (SlickException e)
        {
            e.printStackTrace();
        }
    }

}
