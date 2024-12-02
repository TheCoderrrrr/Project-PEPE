package world.cards.single.debuff;

import core.Images;
import world.cards.StatusEffect;
import world.cards.single.TargetedCard;
import world.effects.debuff.Mark;
import world.entity.Entity;

public class CuddleCrush extends TargetedCard implements StatusEffect {
    public CuddleCrush()
    {
        super();
        energyCost = 1;
        name = "Cuddle Crush";
        image = Images.CUDDLE_CRUSH;
        description = "Applies Mark Effect";
    }

    @Override
    public void applyEffect(Entity e) {
        e.addEffect(new Mark(e, 1, 2));
    }
}
