package world;

import world.effects.Effect;
import world.effects.buff.StrengthBoost;
import world.entity.PlayerUnit;
import world.managers.EntityManager;

import java.util.ArrayList;

//allows us to track the players stats
public class Player {
    private PlayerUnit playerUnit;
    private static int health;
    private static float critRate;
    private static float critMultiplier;
    private static float attackMultiplier;
    private static ArrayList<Effect> effects;

    public Player(PlayerUnit playerUnit)
    {
        //default stats
        this.playerUnit = playerUnit;
        health = playerUnit.getCurHealth();
        critRate = 0.05f;
        critMultiplier = 1.5f;
        attackMultiplier = 0;
    }

    public static void updateEffects(ArrayList<Effect> activeEffects)
    {
        effects = activeEffects;
    }
    public static void updateStats()
    {
        attackMultiplier = 0;
        for(Effect e :effects)
        {
            if(e instanceof StrengthBoost)
            {
                attackMultiplier += ((StrengthBoost) e).getMultiplier();
            }
        }
    }
    public static int getHealth()
    {
        return health;
    }

    public static float getCritRate()
    {
        return critRate;
    }
    public static float getCritMultiplier()
    {
        return critMultiplier;
    }
    public static float getAttackMultiplier()
    {
        return attackMultiplier;
    }
}
