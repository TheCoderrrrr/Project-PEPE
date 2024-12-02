package world.cards.single.attack;

import core.Images;
import world.cards.single.TargetedCard;
import world.entity.Entity;

import java.lang.annotation.Target;

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
