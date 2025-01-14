package world.enemyMoveset.moves.stackMoves;

import world.enemyMoveset.moves.AttackMove;
import world.entity.Entity;

public class RingBlaster extends AttackMove {
    @Override
    public void action(Entity entity) {
        entity.takeDamage(30);
    }
}
