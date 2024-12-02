package world.cards.single;

import world.entity.Entity;

public class MaulCard extends TargetedCard {
    public MaulCard() {
        super();
        energyCost = 2;
    }
    public void action(Entity e)
    {
        e.takeDamage(30);
    }

}
