package world.enemyMoveset.moves.horseMoves;

import world.enemyMoveset.moves.AttackMove;
import world.entity.Entity;

public class NeighQuake extends AttackMove {

    public NeighQuake()
    {
        info = "Does 10 damage";
    }
    @Override
    public void action(Entity entity) {
        entity.takeDamage(10);
    }
}
