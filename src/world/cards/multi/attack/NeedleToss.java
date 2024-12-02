package world.cards.multi.attack;

import core.Images;
import world.cards.multi.GlobalCard;
import world.entity.EnemyUnit;
import world.entity.Entity;

import java.util.ArrayList;

public class NeedleToss extends GlobalCard {
    public NeedleToss()
    {
        super();
        energyCost = 2;
        name = "Needle Toss";
        image = Images.NEEDLE_TOSS;
    }

    @Override
    public void action(ArrayList<Entity> entities) {
        for(Entity e : entities)
        {
            if(e instanceof EnemyUnit)
            {
                e.takeDamage(20);
            }
        }
    }
}
