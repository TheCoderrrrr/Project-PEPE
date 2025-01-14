package world.enemyMoveset.moves.godzillaMoves;

import world.enemyMoveset.moves.AttackMove;
import world.entity.Entity;

public class Slash extends AttackMove {

    @Override
    public void action(Entity entity) {
        entity.takeDamage(20);
    }
}
