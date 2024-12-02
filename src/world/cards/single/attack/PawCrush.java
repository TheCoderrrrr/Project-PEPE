package world.cards.single.attack;

import core.Images;
import world.cards.StatusEffect;
import world.cards.single.TargetedCard;
import world.effects.debuff.Burn;
import world.entity.Entity;

public class PawCrush extends TargetedCard implements StatusEffect {
    public PawCrush()
    {
        super();
        energyCost = 2;
        name = "Paw Crush";
        image = Images.PAW_CRUSH;
    }

    @Override
    public void action(Entity e) {
        e.takeDamage(50);
    }

    @Override
    public void applyEffect(Entity e) {
        e.addEffect(new Burn(e, 5));
    }
}
