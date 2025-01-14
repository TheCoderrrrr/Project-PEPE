package world.enemyMoveset.moves.soldierMoves;

import world.effects.debuff.Mark;
import world.enemyMoveset.moves.AttackMove;
import world.entity.Entity;

public class VolleyFire extends AttackMove {
    @Override
    public void action(Entity entity) {
        entity.takeDamage(20);
    }
}
