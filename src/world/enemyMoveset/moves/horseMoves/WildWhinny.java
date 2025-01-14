package world.enemyMoveset.moves.horseMoves;

import world.cards.StatusEffect;
import world.effects.buff.Shield;
import world.effects.debuff.Mark;
import world.enemyMoveset.moves.AttackMove;
import world.entity.Entity;

public class WildWhinny extends AttackMove implements StatusEffect {

    public WildWhinny()
    {
        info = "Does 20 damage and 'Mark' effect is applied";
    }
    @Override
    public void action(Entity entity) {
        entity.takeDamage(20);
    }

    @Override
    public void applyEffect(Entity e) {
        e.addEffect(new Mark(e, 1, 2));
    }
}
