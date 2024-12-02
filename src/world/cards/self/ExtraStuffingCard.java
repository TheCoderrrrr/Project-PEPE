package world.cards.self;

import world.cards.StatusEffect;
import world.effects.buff.Shield;
import world.entity.Entity;

public class ExtraStuffingCard extends SelfTargetedCard implements StatusEffect {
    public ExtraStuffingCard() {
        super();
        energyCost = 0;
    }
    @Override
    public void applyEffect(Entity e) {
        e.addEffect(new Shield(e, 1, 3));
    }
}
