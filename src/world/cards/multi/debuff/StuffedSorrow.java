package world.cards.multi.debuff;

import resources.Images;
import world.cards.StatusEffect;
import world.cards.multi.GlobalCard;
import world.effects.debuff.Weaken;
import world.entity.Entity;

public class StuffedSorrow extends GlobalCard implements StatusEffect {
    public StuffedSorrow()
    {
        super();
        energyCost = 3;
        name = "Stuffed Sorrow";
        description = "Decrease Enemy Attack by 20% for 1 round";
        image = Images.STUFFED_SORROW;
        energyCostImage = Images.ENERGY3;
    }

    @Override
    public void applyEffect(Entity e) {
        e.addEffect(new Weaken(e, 2, 1));
    }
}
