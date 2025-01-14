package world.cards.self;

import resources.Images;
import world.cards.StatusEffect;
import world.effects.buff.Healing;
import world.entity.Entity;

public class PlushPerfection extends SelfTargeted implements StatusEffect {
    public PlushPerfection()
    {
        super();
        image = Images.PLUSH_PERFECTION;
        energyCost = 2;
        name = "Plush Perfection";
        description = "Heal 30 HP";
        energyCostImage = Images.ENERGY2;
    }
    @Override
    public void applyEffect(Entity e) {
        e.addEffect(new Healing(e, 30, 1));
    }
}
