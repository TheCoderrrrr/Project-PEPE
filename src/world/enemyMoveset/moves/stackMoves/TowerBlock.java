package world.enemyMoveset.moves.stackMoves;

import world.cards.StatusEffect;
import world.effects.buff.Shield;
import world.enemyMoveset.moves.AttackMove;
import world.entity.Entity;

public class TowerBlock extends AttackMove implements StatusEffect {

    public TowerBlock()
    {
        info = "Does 10 damage and 'Shield' effect is applied";
    }
    @Override
    public void action(Entity entity) {
        entity.takeDamage(10);
    }

    @Override
    public void applyEffect(Entity e) {
        e.addEffect(new Shield(e, 1, 3));
    }

}
