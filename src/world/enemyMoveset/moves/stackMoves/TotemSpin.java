package world.enemyMoveset.moves.stackMoves;

import world.enemyMoveset.moves.AttackMove;
import world.entity.Entity;

public class TotemSpin extends AttackMove {

    public TotemSpin()
    {
        info = "Does 15 damage";
    }
    @Override
    public void action(Entity entity) {
        entity.takeDamage(15);
    }
}
