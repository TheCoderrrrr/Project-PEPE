package world.effects.buff;

import world.effects.Effect;
import world.entity.Entity;

public class StrengthBoost extends Effect {
    private int multiplier;
    public StrengthBoost(Entity e, int amount, int duration) {
        super(e, duration);
        this.multiplier = amount;
        name = "StrengthBoost";
    }
    public float getMultiplier()
    {
        if(multiplier == 1){
            return .2f;
        }else if(multiplier == 2){
            return .3f;
        } else if(multiplier == 3){
            return .4f;
        }
        else {
            return .5f;
        }
    }
}
