package world.cards.self;

import core.Images;
import world.cards.StatusEffect;
import world.effects.buff.Healing;
import world.entity.Entity;

public class Sewing extends SelfTargeted implements StatusEffect {
    public Sewing()
    {
        super();
        image = Images.SEWING;
        energyCost = 3;
        name = "Sewing";
    }
    @Override
    public void applyEffect(Entity e) {
        e.addEffect(new Healing(e, 50, 1));
    }
}
