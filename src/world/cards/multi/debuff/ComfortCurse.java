package world.cards.multi.debuff;

import resources.Images;
import world.cards.StatusEffect;
import world.cards.multi.GlobalCard;
import world.effects.debuff.Vulnerable;
import world.entity.Entity;

public class ComfortCurse extends GlobalCard implements StatusEffect {
    public ComfortCurse()
    {
        super();
        energyCost = 2;
        name = "Comfort Curse";
        description = "Adds Vulnerability";
        image = Images.COMFORT_CURSE;
        energyCostImage = Images.ENERGY2;
    }
    @Override
    public void applyEffect(Entity e) {
        e.addEffect(new Vulnerable(e,2, 2));
    }
}
