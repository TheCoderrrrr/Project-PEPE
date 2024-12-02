package world.cards.single.attack;

import core.Images;
import world.cards.single.TargetedCard;
import world.entity.Entity;

public class PawPummel extends TargetedCard {
    public PawPummel()
    {
        super();
        energyCost = 1;
        name = "Paw Pummel";
        image = Images.PAW_PUMMEL;
        description = "25 dmg to selected target";
    }
    public void action(Entity e) {
        e.takeDamage(25);
    }
}
