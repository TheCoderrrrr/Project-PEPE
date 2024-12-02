package world.cards.multi.attack;

import core.Images;
import world.cards.multi.GlobalCard;
import world.entity.EnemyUnit;
import world.entity.Entity;

import java.util.ArrayList;

public class ThreadTornado extends GlobalCard {
    public ThreadTornado()
    {
        super();
        energyCost = 1;
        name = "Thread Tornado";
        description = "25 dmg to all enemies";
        image = Images.THREAD_TORNADO;
    }

    @Override
    public void action(ArrayList<Entity> entities) {
        for(Entity e : entities)
        {
            if(e instanceof EnemyUnit)
            {
                e.takeDamage(25);
            }
        }
    }
}
