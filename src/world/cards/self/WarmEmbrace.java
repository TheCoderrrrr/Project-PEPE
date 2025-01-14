package world.cards.self;

import resources.Images;
import world.cards.StatusEffect;
import world.effects.buff.Healing;
import world.entity.Entity;

public class WarmEmbrace extends SelfTargeted implements StatusEffect {
    public WarmEmbrace()
    {
        super();
        image = Images.WARM_EMBRACE;
        energyCost = 1;
        name = "Warm Embrace";
        description = "Heal 15 HP for the next 2 rounds";
        energyCostImage = Images.ENERGY1;
    }
    @Override
    public void applyEffect(Entity e) {
        e.addEffect(new Healing(e, 15, 2));
    }
}
