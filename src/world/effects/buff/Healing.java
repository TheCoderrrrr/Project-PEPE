package world.effects.buff;

import world.effects.Effect;
import world.entity.Entity;

public class Healing extends Effect {
    private int intensity;
    private float healingAmount;
    public Healing(Entity e, float intensity, int duration) {
        super(e, duration);
        healingAmount *= intensity;
        name = "Healing";
    }

    @Override
    public void action() {
        target.heal(healingAmount);
        super.action();
    }
}
