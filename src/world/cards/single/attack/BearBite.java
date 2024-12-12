package world.cards.single.attack;

import resources.Images;
import world.cards.single.TargetedCard;
import world.entity.Entity;

public class BearBite extends TargetedCard {
    public BearBite()
    {
        super();
        energyCost = 1;
        name = "Bear Bite";
        image = Images.BEAR_BITE;
        description = "25 dmg to selected target";
    }
    public void action(Entity e) {
        e.takeDamage(25);
    }
}
