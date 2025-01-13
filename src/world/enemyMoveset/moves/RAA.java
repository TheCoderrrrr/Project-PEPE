package world.enemyMoveset.moves;

import world.cards.StatusEffect;
import world.effects.debuff.Mark;
import world.entity.Entity;

public class RAA extends Move implements StatusEffect {
    @Override
    public void applyEffect(Entity e) {
        e.addEffect(new Mark(e, 1, 3));
    }

    @Override
    public void action(Entity entity) {
        entity.takeDamage(2);
    }
}
