package world.effects.debuff;

import resources.Images;
import world.cards.Card;
import world.cards.StatusEffect;
import world.effects.Effect;
import world.entity.Entity;

public class Weaken extends Effect {
    private float multiplier;
    public Weaken(Entity e, float multiplier, int duration) {
        super(e, duration);
        this.multiplier = multiplier;
        name = "Weakened";
        symbol = Images.WEAKENED;
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
