package world.enemyMoveset.moves.soldierMoves;

import world.enemyMoveset.moves.AttackMove;
import world.entity.Entity;

public class Strike extends AttackMove {

    @Override
    public void action(Entity entity) {
        entity.takeDamage(10);
    }
}
