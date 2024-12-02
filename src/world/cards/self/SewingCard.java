package world.cards.self;

import world.cards.StatusEffect;
import world.effects.buff.Healing;
import world.entity.Entity;

public class SewingCard extends SelfTargetedCard implements StatusEffect {
    public SewingCard()
    {
        super();
        energyCost = 3;
    }
    @Override
    public void applyEffect(Entity e) {
        e.addEffect(new Healing(e, 5, 1));
    }
}
