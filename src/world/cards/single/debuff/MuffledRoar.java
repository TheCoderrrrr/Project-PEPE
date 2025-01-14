package world.cards.single.debuff;

import resources.Images;
import world.cards.StatusEffect;
import world.cards.single.TargetedCard;
import world.effects.debuff.Vulnerable;
import world.entity.Entity;

public class MuffledRoar extends TargetedCard implements StatusEffect {
    public MuffledRoar()
    {
        super();
        energyCost = 1;
        name = "Muffled Roar";
        image = Images.MUFFLED_ROAR;
        description = "Applies Vulnerability";
        energyCostImage = Images.ENERGY1;
    }
    @Override
    public void applyEffect(Entity e) {
        e.addEffect(new Vulnerable(e, 2, 2));
    }
}
