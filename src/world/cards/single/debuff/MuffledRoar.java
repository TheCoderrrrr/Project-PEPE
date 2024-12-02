package world.cards.single.debuff;

import core.Images;
import world.cards.StatusEffect;
import world.cards.single.TargetedCard;
import world.effects.debuff.Vulnerable;
import world.entity.Entity;

import java.lang.annotation.Target;

public class MuffledRoar extends TargetedCard implements StatusEffect {
    public MuffledRoar()
    {
        super();
        energyCost = 1;
        name = "Muffled Roar";
        image = Images.MUFFLED_ROAR;
    }
    @Override
    public void applyEffect(Entity e) {
        e.addEffect(new Vulnerable(e, 2, 2));
    }
}
