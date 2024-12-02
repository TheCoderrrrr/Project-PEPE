package world.cards.self;

import world.cards.StatusEffect;
import world.effects.buff.Healing;
import world.entity.Entity;

public class PlushPerfection extends SelfTargetedCard implements StatusEffect {
    public PlushPerfection()
    {
        super();
        energyCost = 2;
    }
    @Override
    public void applyEffect(Entity e) {
        e.addEffect(new Healing(e, 3, 1));
    }
}
