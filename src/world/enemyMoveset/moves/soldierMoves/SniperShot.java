package world.enemyMoveset.moves.soldierMoves;

import world.effects.debuff.Mark;
import world.enemyMoveset.moves.AttackMove;
import world.entity.Entity;

public class SniperShot extends AttackMove {

    public SniperShot()
    {
        info = "Does 25 damage";
    }
    @Override
    public void action(Entity entity) {
        entity.takeDamage(25);
    }
}
