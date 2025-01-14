package world.enemyMoveset.moves.soldierMoves;

import world.effects.debuff.Mark;
import world.enemyMoveset.moves.AttackMove;
import world.entity.Entity;

public class VolleyFire extends AttackMove {

    public VolleyFire()
    {
        info = "Does 20 damage";
    }
    @Override
    public void action(Entity entity) {
        entity.takeDamage(20);
    }
}
