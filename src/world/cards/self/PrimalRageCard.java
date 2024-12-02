package world.cards.self;

import world.cards.StatusEffect;
import world.effects.buff.StrengthBoost;
import world.entity.Entity;

public class PrimalRageCard extends SelfTargetedCard implements StatusEffect {
    public PrimalRageCard()
    {
        super();
        energyCost = 1;
    }
    @Override
    public void applyEffect(Entity e) {
        e.addEffect(new StrengthBoost(e, 2, 2));
    }
}
