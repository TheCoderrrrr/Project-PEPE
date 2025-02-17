package world.cards.multi.attack;

import resources.Images;
import world.cards.multi.GlobalCard;
import world.entity.enemy.EnemyUnit;
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
        energyCostImage = Images.ENERGY1;
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
