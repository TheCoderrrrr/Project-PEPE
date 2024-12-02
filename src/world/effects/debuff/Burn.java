package world.effects.debuff;

import world.effects.Effect;
import world.entity.Entity;

public class Burn extends Effect {
    private static final int BURN_DAMAGE = 3;
    public Burn(Entity e, int duration) {
        super(e, duration);
        name = "Burning";
    }

    @Override
    public void action() {
        target.takeDamage(BURN_DAMAGE);
        super.action();
    }
}
