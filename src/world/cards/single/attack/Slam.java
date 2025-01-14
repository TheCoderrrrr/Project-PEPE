package world.cards.single.attack;

import resources.Images;
import world.cards.StatusEffect;
import world.cards.single.TargetedCard;
import world.effects.debuff.Mark;
import world.entity.Entity;

public class Slam extends TargetedCard implements StatusEffect {
    public Slam()
    {
        super();
        energyCost = 1;
        name = "Slam";
        image = Images.SLAM;
        description = "20 dmg to selected target and mark effect";
        energyCostImage = Images.ENERGY1;
    }

    @Override
    public void action(Entity e) {
        e.takeDamage(20);
    }

    @Override
    public void applyEffect(Entity e) {
        e.addEffect(new Mark(e, 1, 2));
    }
}
