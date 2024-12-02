package world.cards.self;

import core.Images;
import world.cards.StatusEffect;
import world.effects.buff.StrengthBoost;
import world.entity.Entity;

public class PrimalRage extends SelfTargeted implements StatusEffect {
    public PrimalRage()
    {
        super();
        image = Images.PRIMAL_RAGE;
        energyCost = 1;
        name = "Primal Rage";
        description = "Increase Dmg by 30% for a round";
    }
    @Override
    public void applyEffect(Entity e) {
        e.addEffect(new StrengthBoost(e, 2, 2));
    }
}
