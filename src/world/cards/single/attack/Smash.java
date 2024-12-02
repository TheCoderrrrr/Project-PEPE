package world.cards.single.attack;

import core.Images;
import world.cards.single.TargetedCard;
import world.entity.Entity;

public class Smash extends TargetedCard {
    public Smash()
    {
        super();
        energyCost = 1;
        name = "Smash";
        image = Images.SMASH;
    }
    public void action(Entity e) {
        e.takeDamage(25);
    }
}
