package world.effects.buff;

import world.effects.Effect;
import world.entity.Entity;

public class Shield extends Effect {
    private int multiplier;
    public Shield(Entity e, int amount, int duration) {
        super(e, duration);
        this.multiplier = amount;
        name = "Shield";
    }
    public float getMultiplier()
    {
        if(multiplier == 1){
            return 1 -.25f;
        }else if(multiplier == 2){
            return 1 -.5f;
        } else if(multiplier == 3){
            return 1 -.75f;
        }
        else {
            return 0;
        }
    }
}
