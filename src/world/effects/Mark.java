package world.effects;

import world.entity.Entity;

public class Mark extends Effect {
    private float multiplier;

    public Mark(Entity e, float multiplier, int duration) {
        super(e, duration);
        this.multiplier = multiplier;
    }

    public float getMultiplier() {
        return multiplier - 1;
    }
}
