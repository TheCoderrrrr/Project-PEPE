package world.cards.self;

import core.Images;
import world.cards.StatusEffect;
import world.effects.buff.StrengthBoost;
import world.entity.Entity;

public class FallacyOfReturn extends SelfTargeted implements StatusEffect {
    public FallacyOfReturn() {
        super();
        image = Images.FALLACY_RETURN;
        energyCost = 0;
        name = "Fallacy of Return";
    }

    @Override
    public void applyEffect(Entity e) {
        e.addEffect(new StrengthBoost(e, 1, 3));
    }

}
