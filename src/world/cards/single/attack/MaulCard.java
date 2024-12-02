package world.cards.single.attack;

import core.Images;
import world.cards.single.TargetedCard;
import world.entity.Entity;

public class MaulCard extends TargetedCard {
    public MaulCard() {
        super();
        energyCost = 2;
        name = "Maul";
        image = Images.MAUL;
    }
    public void action(Entity e)
    {
        e.takeDamage(30);
    }

}
