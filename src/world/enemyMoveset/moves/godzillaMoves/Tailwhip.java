package world.enemyMoveset.moves.godzillaMoves;

import world.enemyMoveset.moves.AttackMove;
import world.entity.Entity;

public class Tailwhip extends AttackMove {

    public Tailwhip()
    {
        info = "Does 15 damage";
    }

    @Override
    public void action(Entity entity) {
        entity.takeDamage(15);
    }
}
