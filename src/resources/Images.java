package resources;

import core.Main;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Images {

    public static Image PLACEHOLDERCARD;
    public static Image BACKGROUND;
    public static Image CREEPYBACKGROUND;
    public static Image HAPPYBACKGROUND;
    public static Image BEAR_MOVESET;
    public static SpriteSheet BEAR_MOVES;

    //Bear images
    public static Image EXTRA_STUFFING;
    public static Image SEWING;
    public static Image BEARS_YEARNING;
    public static Image PRIMAL_RAGE;
    public static Image FALLACY_RETURN;
    public static Image WARM_EMBRACE;
    public static Image PLUSH_PERFECTION;
    public static Image CUPIDS_ARROW;
    public static Image STUFFED_SORROW;
    public static Image COMFORT_CURSE;
    public static Image MUFFLED_ROAR;
    public static Image STITCHED_SILENCE;
    public static Image BUTTON_BOMB;
    public static Image CUDDLE_CRUSH;
    public static Image SMASH;
    public static Image THREAD_TORNADO;
    public static Image BEAR_BITE;
    public static Image PAW_PUMMEL;
    public static Image SLAM;
    public static Image NEEDLE_TOSS;
    public static Image BEAR_HUG;
    public static Image PAW_CRUSH;
    public static Image MAUL;
    public static Image CONCEALED_CLAWS;
    public static Image BUTTON_BARRAGE;
    public static Image BEAR_HERO;

    //Enemy Images
    public static Image ENEMY1;
    public static Image ENEMY2;

    //Effect Symbols
    public static Image BURNING;
    public static Image HEALING;
    public static Image MARKED;
    public static Image POISONED;
    public static Image SHIELD;
    public static Image STRENGTH;
    public static Image VULNERABLE;
    public static Image WEAKENED;

    public static void loadImages()
    {
        try
        {
            PLACEHOLDERCARD = new Image("res/images/cards/card_template.png");
            BACKGROUND = new Image("res/images/backgrounds/background.png");
            HAPPYBACKGROUND = new Image("res/images/backgrounds/happyBackground.png").getScaledCopy(Main.getScreenWidth(), Main.getScreenHeight());
            CREEPYBACKGROUND = new Image("res/images/backgrounds/creepyBackground.png").getScaledCopy(Main.getScreenWidth(), Main.getScreenHeight());

            loadBearImages();

            loadSymbols();

            ENEMY1 = new Image("res/images/entity/enemy/Green_Army_Soldier.png");
            ENEMY2 = new Image("res/images/entity/enemy/Rolling_Horse.png");

        }
        catch (SlickException e)
        {
            e.printStackTrace();
        }
    }
    private static void loadBearImages() throws SlickException{
        BEAR_MOVESET = new Image("res/images/cards/bear_sheet.png");
        BEAR_MOVES = new SpriteSheet(BEAR_MOVESET, 200, 300);

        //Bears moves
        EXTRA_STUFFING = BEAR_MOVES.getSubImage(0,0);
        SEWING = BEAR_MOVES.getSubImage(1, 0);
        BEARS_YEARNING = BEAR_MOVES.getSubImage(2, 0);
        PRIMAL_RAGE = BEAR_MOVES.getSubImage(3,0);
        FALLACY_RETURN = BEAR_MOVES.getSubImage(4, 0);
        WARM_EMBRACE = BEAR_MOVES.getSubImage(5, 0);
        PLUSH_PERFECTION = BEAR_MOVES.getSubImage(6,0);
        CUPIDS_ARROW = BEAR_MOVES.getSubImage(7, 0);
        STUFFED_SORROW = BEAR_MOVES.getSubImage(8, 0);
        COMFORT_CURSE = BEAR_MOVES.getSubImage(9, 0);
        MUFFLED_ROAR = BEAR_MOVES.getSubImage(10, 0);
        STITCHED_SILENCE = BEAR_MOVES.getSubImage(11, 0);
        BUTTON_BOMB = BEAR_MOVES.getSubImage(12, 0);
        CUDDLE_CRUSH = BEAR_MOVES.getSubImage(13, 0);
        SMASH = BEAR_MOVES.getSubImage(14, 0);
        THREAD_TORNADO = BEAR_MOVES.getSubImage(15, 0);
        BEAR_BITE = BEAR_MOVES.getSubImage(16, 0);
        PAW_PUMMEL = BEAR_MOVES.getSubImage(17, 0);
        SLAM = BEAR_MOVES.getSubImage(18, 0);
        NEEDLE_TOSS = BEAR_MOVES.getSubImage(19, 0);
        BEAR_HUG = BEAR_MOVES.getSubImage(20, 0);
        PAW_CRUSH = BEAR_MOVES.getSubImage(21, 0);
        MAUL = BEAR_MOVES.getSubImage(22, 0);
        CONCEALED_CLAWS = BEAR_MOVES.getSubImage(23, 0);
        BUTTON_BARRAGE = BEAR_MOVES.getSubImage(24, 0);

        BEAR_HERO = new Image("res/images/entity/hero/Toy_Bear.png");
    }
    public static void loadSymbols() throws SlickException{
        BURNING = new Image("res/images/effects/burning.png").getScaledCopy(32, 32);
        BURNING.setImageColor(255, 0,0);
        HEALING = new Image("res/images/effects/healing.png").getScaledCopy(32, 32);
        HEALING.setImageColor(0, 255, 255);
        MARKED = new Image("res/images/effects/marked.png").getScaledCopy(32, 32);
        POISONED = new Image("res/images/effects/poisoned.png").getScaledCopy(32, 32);
        POISONED.setImageColor	(147,229,30);
        SHIELD = new Image("res/images/effects/shield.png").getScaledCopy(32, 32);
        STRENGTH = new Image("res/images/effects/strength.png").getScaledCopy(32, 32);
        VULNERABLE = new Image("res/images/effects/vulnerable.png").getScaledCopy(32, 32);
        WEAKENED = new Image("res/images/effects/weakened.png").getScaledCopy(32, 32);
    }
}
