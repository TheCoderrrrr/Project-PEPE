package world.cards;

import core.Images;
import world.cards.multi.GlobalCard;
import world.entity.EnemyUnit;
import world.entity.Entity;

import java.util.ArrayList;

public class ExampleCard2 extends GlobalCard {

    public ExampleCard2(){
        super();
        cost = 1;
        rarity = 2;
        image = Images.PLACEHOLDERCARD;
    }

    @Override
    public void action(ArrayList<Entity> entities) {
        for(Entity e : entities)
        {
            if(e instanceof EnemyUnit)
            {
                e.takeDamage(10);
            }
        }
    }
}
