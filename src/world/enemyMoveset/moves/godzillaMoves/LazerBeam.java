package world.enemyMoveset.moves.godzillaMoves;

import world.cards.StatusEffect;
import world.effects.debuff.Burn;
import world.enemyMoveset.moves.AttackMove;
import world.entity.Entity;

public class LazerBeam extends AttackMove implements StatusEffect {
    @Override
    public void action(Entity entity) {
        entity.takeDamage(30);
    }

    @Override
    public void applyEffect(Entity e) {
        e.addEffect(new Burn(e, 2));
    }
}
