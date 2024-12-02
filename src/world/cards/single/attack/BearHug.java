package world.cards.single.attack;

import core.Images;
import world.cards.StatusEffect;
import world.cards.single.TargetedCard;
import world.effects.debuff.Vulnerable;
import world.entity.Entity;

public class BearHug extends TargetedCard implements StatusEffect {
    public BearHug()
    {
        super();
        energyCost = 2;
        name = "Bear Hug";
        image = Images.BEAR_HUG;
        description = "20 dmg to selected target and applies vulnerable effect";
    }

    @Override
    public void action(Entity e) {
        e.takeDamage(20);
    }

    @Override
    public void applyEffect(Entity e) {
        e.addEffect(new Vulnerable(e, 2, 2));
    }
}
