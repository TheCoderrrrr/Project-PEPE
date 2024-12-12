package world.cards.single.attack;

import resources.Images;
import world.cards.single.TargetedCard;
import world.entity.Entity;

public class Smash extends TargetedCard {
    public Smash()
    {
        super();
        energyCost = 1;
        name = "Smash";
        image = Images.SMASH;
        description = "25 dmg to selected target";
    }
    public void action(Entity e) {
        e.takeDamage(25);
    }
}
