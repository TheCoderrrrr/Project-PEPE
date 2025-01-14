package world.enemyMoveset.moves.truckMoves;

import world.enemyMoveset.moves.AttackMove;
import world.entity.Entity;

public class Crush extends AttackMove {

    public Crush()
    {
        info = "Does 25 damage";
    }
    @Override
    public void action(Entity entity) {
        entity.takeDamage(25);
    }
}
