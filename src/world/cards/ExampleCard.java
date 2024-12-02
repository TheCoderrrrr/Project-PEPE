package world.cards;

import world.cards.single.TargetedCard;
import world.entity.Entity;

public class ExampleCard extends TargetedCard {

    public ExampleCard(){
        super();
        cost = 1;
        rarity = 2;
    }

    public void action(Entity e)
    {
        e.takeDamage(10);
    }

}
