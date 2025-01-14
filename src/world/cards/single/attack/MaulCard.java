package world.cards.single.attack;

import resources.Images;
import world.cards.single.TargetedCard;
import world.entity.Entity;

public class MaulCard extends TargetedCard {
    public MaulCard() {
        super();
        energyCost = 2;
        name = "Maul";
        image = Images.MAUL;
        description = "30 dmg to selected target";
        energyCostImage = Images.ENERGY2;
    }
    public void action(Entity e)
    {
        e.takeDamage(30);
    }

}
