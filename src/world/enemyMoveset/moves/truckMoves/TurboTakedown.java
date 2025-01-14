package world.enemyMoveset.moves.truckMoves;

import world.enemyMoveset.moves.AttackMove;
import world.entity.Entity;

public class TurboTakedown extends AttackMove {
    public TurboTakedown(){
        info = "Does 45 damage";
    }
    @Override
    public void action(Entity entity) {
        entity.takeDamage(45);
    }
}
