package world.enemyMoveset;

import world.cards.StatusEffect;
import world.effects.debuff.Burn;
import world.entity.Entity;

public class BABA extends Move implements StatusEffect {

    @Override
    public void action(Entity entity) {
        entity.takeDamage(10);
    }

    @Override
    public void applyEffect(Entity e) {
        e.addEffect(new Burn(e, 5));
    }
}
