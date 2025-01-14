package world.enemyMoveset.moves.horseMoves;

import world.enemyMoveset.moves.AttackMove;
import world.entity.Entity;

public class ManeDash extends AttackMove {

    public ManeDash()
    {
        info = "Does 25 damage";
    }
    @Override
    public void action(Entity entity) {
        entity.takeDamage(25);
    }
}
