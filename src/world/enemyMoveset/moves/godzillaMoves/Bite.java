package world.enemyMoveset.moves.godzillaMoves;

import world.effects.debuff.Burn;
import world.enemyMoveset.moves.AttackMove;
import world.entity.Entity;

public class Bite extends AttackMove {
    public Bite(){
        info = "Does 15 damage";
    }
    @Override
    public void action(Entity entity) {
        entity.takeDamage(15);

    }
}
