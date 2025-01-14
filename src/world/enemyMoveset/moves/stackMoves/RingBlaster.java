package world.enemyMoveset.moves.stackMoves;

import world.enemyMoveset.moves.AttackMove;
import world.entity.Entity;

public class RingBlaster extends AttackMove {

    public RingBlaster()
    {
        info = "Does 30 damage";
    }
    @Override
    public void action(Entity entity) {
        entity.takeDamage(30);
    }
}
