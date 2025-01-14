package world.enemyMoveset.moves.godzillaMoves;

import world.cards.StatusEffect;
import world.effects.debuff.Mark;
import world.enemyMoveset.moves.AttackMove;
import world.entity.Entity;

public class PlasmaRay extends AttackMove implements StatusEffect{

    @Override
    public void action(Entity entity) {
        entity.takeDamage(30);
    }

    @Override
    public void applyEffect(Entity e) {
        e.addEffect(new Mark(e, 1, 2));
    }
}
