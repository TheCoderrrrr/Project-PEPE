package world.enemyMoveset.moves.stackMoves;

import world.enemyMoveset.moves.AttackMove;
import world.entity.Entity;

public class StackSlam extends AttackMove {

    public StackSlam()
    {
        info = "Does 25 damage";
    }

    @Override
    public void action(Entity entity) {
        entity.takeDamage(25);
    }
}
