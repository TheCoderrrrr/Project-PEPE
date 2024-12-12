package world.cards.self;

import resources.Images;
import world.cards.StatusEffect;
import world.effects.buff.Shield;
import world.entity.Entity;

public class BearsYearning extends SelfTargeted implements StatusEffect {
    public BearsYearning() {
        super();
        energyCost = 3;
        name = "Bear's Yearning";
        description = "Completely block next attack";
        image = Images.BEARS_YEARNING;
    }
    @Override
    public void applyEffect(Entity e) {
        e.addEffect(new Shield(e, 4, 1));
    }
}
