package world.enemyMoveset.moves.truckMoves;

import world.cards.StatusEffect;
import world.effects.buff.Shield;
import world.effects.debuff.Poison;
import world.enemyMoveset.moves.AttackMove;
import world.entity.Entity;

public class CargoCover extends AttackMove implements StatusEffect {

    public CargoCover()
    {
        info = "Does 15 damage and 'Shield' effect is applied";
    }

    @Override
    public void action(Entity entity) {
        entity.takeDamage(15);
    }

    @Override
    public void applyEffect(Entity e) {
        e.addEffect(new Shield(e, 1, 2));
    }
}
