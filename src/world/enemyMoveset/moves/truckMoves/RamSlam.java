package world.enemyMoveset.moves.truckMoves;

import world.enemyMoveset.moves.AttackMove;
import world.entity.Entity;

public class RamSlam extends AttackMove {
    @Override
    public void action(Entity entity) {
        entity.takeDamage(20);
    }
}
