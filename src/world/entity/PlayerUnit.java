package world.entity;

import resources.Images;
import world.effects.Effect;
import world.effects.buff.Healing;
import world.effects.buff.Shield;
import world.effects.buff.StrengthBoost;
import world.effects.debuff.*;

import java.util.ArrayList;

public class PlayerUnit extends Entity{


    public PlayerUnit(int x, int y) {
        super(x, y);
        image = Images.BEAR_HERO;
//        addEffect(new Burn(this, 10));
//        addEffect(new Healing(this, 10, 10));
//        addEffect(new Shield(this, 10, 10));
//        addEffect(new Mark(this, 10, 10));
//        addEffect(new Poison(this, 10, 10));
//        addEffect(new StrengthBoost(this, 10, 10));
//        addEffect(new Weaken(this, 10, 10));
//        addEffect(new Vulnerable(this, 10, 10));

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
