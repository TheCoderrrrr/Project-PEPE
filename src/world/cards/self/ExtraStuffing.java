package world.cards.self;

import resources.Images;
import world.cards.StatusEffect;
import world.effects.buff.Shield;
import world.entity.Entity;

public class ExtraStuffing extends SelfTargeted implements StatusEffect {
    public ExtraStuffing() {
        super();
        image = Images.EXTRA_STUFFING;
        energyCost = 0;
        name = "Extra Stuffing";
        description = "Reduce incoming dmg by 25%";
    }
    @Override
    public void applyEffect(Entity e) {
        e.addEffect(new Shield(e, 1, 3));
    }
}
