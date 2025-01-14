package world.cards.single.debuff;

import resources.Images;
import world.cards.StatusEffect;
import world.cards.single.TargetedCard;
import world.effects.debuff.Weaken;
import world.entity.Entity;

public class StitchedSilence extends TargetedCard implements StatusEffect {
    public StitchedSilence()
    {
        super();
        energyCost = 1;
        name = "Stitched Silence";
        image = Images.STITCHED_SILENCE;
        description = "Decrease enemy attack by 10%";
        energyCostImage = Images.ENERGY1;
    }

    @Override
    public void applyEffect(Entity e) {
        e.addEffect(new Weaken(e, 1, 1));
    }
}
