package world.enemyMoveset.moves.horseMoves;

import world.enemyMoveset.moves.AttackMove;
import world.entity.Entity;

public class ManeDash extends AttackMove {
    @Override
    public void action(Entity entity) {
        entity.takeDamage(25);
    }
}
