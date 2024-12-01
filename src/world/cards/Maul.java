package world.cards;

import org.newdawn.slick.GameContainer;
import world.entity.Entity;

public class Maul extends TargetedCard{
    public Maul() {
        super();
        energyCost = 2;
    }
    public void action(Entity e)
    {
        e.takeDamage(3);
    }

}
