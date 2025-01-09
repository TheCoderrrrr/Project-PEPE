package world.effects.debuff;

import resources.Images;
import world.effects.Effect;
import world.entity.Entity;

public class Poison extends Effect {
    private int intensity;
    private static final int POISON_DAMAGE = 5;
    public Poison(Entity e, int intensity, int duration) {
        super(e, duration);
        this.intensity = intensity;
        name = "Poisoned";
        symbol = Images.POISONED;
    }

    @Override
    public void action() {
        target.takeDamage(POISON_DAMAGE);
        super.action();
    }
}
