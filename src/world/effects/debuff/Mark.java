package world.effects.debuff;

import resources.Images;
import world.effects.Effect;
import world.entity.Entity;

public class Mark extends Effect {
    private float multiplier;

    public Mark(Entity e, float multiplier, int duration) {
        super(e, duration);
        this.multiplier = multiplier;
        name = "Marked";
        symbol = Images.MARKED;
        info = "Makes the affected enemy take additional damage when attacked.";
    }

    public float getMultiplier() {
        if (multiplier == 1) {
            return .1f;
        } else if (multiplier == 2) {
            return .2f;
        } else if (multiplier == 3) {
            return .4f;
        } else {
            return .5f;
        }
    }
}
