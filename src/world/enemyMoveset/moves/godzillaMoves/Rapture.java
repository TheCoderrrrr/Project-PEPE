package world.enemyMoveset.moves.godzillaMoves;

import world.cards.StatusEffect;
import world.effects.debuff.Vulnerable;
import world.enemyMoveset.moves.AttackMove;
import world.entity.Entity;

public class Rapture extends AttackMove implements StatusEffect {
    @Override
    public void action(Entity entity) {
        entity.takeDamage(20);
    }

    @Override
    public void applyEffect(Entity e) {
        e.addEffect(new Vulnerable(e, 1, 2));
    }
}
