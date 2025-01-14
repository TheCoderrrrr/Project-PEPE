package world.enemyMoveset.moves.godzillaMoves;

import resources.Sounds;
import world.enemyMoveset.moves.AttackMove;
import world.entity.Entity;

public class Slash extends AttackMove {

    public Slash()
    {
        info = "Does 20 damage";
    }

    @Override
    public void action(Entity entity) {
        entity.takeDamage(20);
        Sounds.SLASH.play(1, 0.6f);
    }
}
