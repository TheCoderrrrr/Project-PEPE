package world.cards.single.debuff;

import resources.Images;
import world.cards.StatusEffect;
import world.cards.single.TargetedCard;
import world.effects.debuff.Weaken;
import world.entity.Entity;

public class CupidsArrow extends TargetedCard implements StatusEffect {
    public CupidsArrow()
    {
        super();
        energyCost = 3;
        name = "Cupid's Arrow";
        image = Images.CUPIDS_ARROW;
        description = "Decrease Enemy Attack by 10%";
        energyCostImage = Images.ENERGY3;
    }

    @Override
    public void applyEffect(Entity e) {
        e.addEffect(new Weaken(e, 1, 3));
    }
}
