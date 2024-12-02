package world.entity;

import core.Images;
import world.effects.Effect;
import world.effects.buff.Shield;
import world.effects.debuff.Mark;
import world.effects.debuff.Vulnerable;

import java.util.ArrayList;

public class PlayerUnit extends Entity{


    public PlayerUnit(int x, int y) {
        super(x, y);
        image = Images.BEAR_HERO;
    }
    public ArrayList<Effect> getEffects()
    {
        return activeEffects;
    }
    public void takeDamage(int damage)
    {
        float multiplier = 1;
        for(Effect e : activeEffects) {
            if(e instanceof Mark) {
                multiplier += ((Mark) e).getMultiplier();
            }
            if(e instanceof Vulnerable)
            {
                multiplier +=((Vulnerable) e).getMultiplier();
            }
            if(e instanceof Shield)
            {
                multiplier *= ((Shield) e).getMultiplier();
            }
        }
        curHealth = Math.max(0, curHealth - Math.round(damage * multiplier));
    }
}
