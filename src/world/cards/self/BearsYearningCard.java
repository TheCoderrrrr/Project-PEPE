package world.cards.self;

import world.cards.StatusEffect;
import world.effects.buff.Shield;
import world.entity.Entity;

public class BearsYearningCard extends SelfTargetedCard implements StatusEffect {
    public BearsYearningCard() {
        super();
        energyCost = 3;
    }
    @Override
    public void applyEffect(Entity e) {
        e.addEffect(new Shield(e, 4, 1));
    }
}
