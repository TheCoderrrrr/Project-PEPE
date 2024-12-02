package world.cards.self;

import world.cards.StatusEffect;
import world.effects.buff.StrengthBoost;
import world.entity.Entity;

public class FallacyOfReturn extends SelfTargetedCard implements StatusEffect {
    public FallacyOfReturn() {
        super();
        energyCost = 0;
    }

    @Override
    public void applyEffect(Entity e) {
        e.addEffect(new StrengthBoost(e, 1, 3));
    }

}
