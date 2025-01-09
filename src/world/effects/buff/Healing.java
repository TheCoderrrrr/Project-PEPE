package world.effects.buff;

import resources.Images;
import world.effects.Effect;
import world.entity.Entity;

public class Healing extends Effect {
    private float healingAmount = 1;
    public Healing(Entity e, float intensity, int duration) {
        super(e, duration);
        healingAmount *= intensity;
        name = "Healing";
        symbol = Images.HEALING;
    }

    @Override
    public void action() {
        target.heal(healingAmount);
        super.action();
    }
}
