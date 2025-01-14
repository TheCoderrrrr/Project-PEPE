package world.enemyMoveset.moves;

import world.cards.StatusEffect;
import world.entity.Entity;

public class IDEK extends BuffMove{

    @Override
    public void action(Entity entity) {
        entity.takeDamage(0);
    }
}
