package world;

import world.effects.Effect;
import world.managers.EntityManager;

import java.util.ArrayList;

//allows us to track the players stats
public class Player {
    private static int health;
    private static float critRate;
    private static int strength;
    private static int sheild;
    private static float critMultiplier;
    private static ArrayList<Effect> effects;
    public Player(EntityManager entityManager)
    {
        //default stats
        health = entityManager.getEntities().getFirst().getCurHealth();
        critRate = 0.05f;
        critMultiplier = 1.5f;
        sheild = 0;
        strength = 1;
    }

    public static void updateEffects(ArrayList<Effect> activeEffects)
    {
        effects = activeEffects;
    }
    public static void updateStats()
    {
        for(Effect e : effects)
        {

        }
    }
    public static int getHealth()
    {
        return health;
    }
    public static int getStrength()
    {
        return strength;
    }
    public static float getCritRate()
    {
        return critRate;
    }
    public static int getSheild()
    {
        return sheild;
    }
    public static float getCritMultiplier()
    {
        return critMultiplier;
    }
}
