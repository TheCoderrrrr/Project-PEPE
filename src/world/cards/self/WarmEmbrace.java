package world.cards.self;

import core.Images;
import world.cards.Card;
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
    }
    @Override
    public void applyEffect(Entity e) {
        e.addEffect(new Healing(e, 15, 2));
    }
}
