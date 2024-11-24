package world.cards;

import org.newdawn.slick.GameContainer;
import world.entity.Entity;

public class ExampleCard extends TargetedCard {

    public ExampleCard(GameContainer gc){
        super(gc);
        cost = 1;
        rarity = 2;
    }

    public void action(Entity e)
    {
        e.takeDamage(10);
    }

}
