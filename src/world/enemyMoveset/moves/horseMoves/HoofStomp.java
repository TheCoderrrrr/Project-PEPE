package world.enemyMoveset.moves.horseMoves;

import world.enemyMoveset.moves.AttackMove;
import world.entity.Entity;

public class HoofStomp extends AttackMove {

    public HoofStomp()
    {
        info = "Does 20 damage";
    }

    @Override
    public void action(Entity entity) {
        entity.takeDamage(20);
    }
}
