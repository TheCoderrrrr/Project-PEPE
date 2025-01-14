package world.enemyMoveset.moves.godzillaMoves;

import world.cards.StatusEffect;
import world.effects.debuff.Poison;
import world.enemyMoveset.moves.AttackMove;
import world.entity.Entity;

public class PoisonousBreath extends AttackMove implements StatusEffect {

    @Override
    public void action(Entity entity) {
        entity.takeDamage(15);
    }

    @Override
    public void applyEffect(Entity e) {
        e.addEffect(new Poison(e, 2, 2 ));
    }
}
