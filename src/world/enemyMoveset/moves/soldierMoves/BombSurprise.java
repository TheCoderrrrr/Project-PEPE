package world.enemyMoveset.moves.soldierMoves;

import world.cards.StatusEffect;
import world.effects.debuff.Mark;
import world.effects.debuff.Vulnerable;
import world.enemyMoveset.moves.AttackMove;
import world.entity.Entity;

public class BombSurprise extends AttackMove implements StatusEffect {

    public BombSurprise()
    {
        info = "Does 15 damage and 'Vulnerable' effect is applied";
    }
    @Override
    public void action(Entity entity) {
        entity.takeDamage(15);
    }

    @Override
    public void applyEffect(Entity e) {
        e.addEffect(new Vulnerable(e, 1, 2));
    }
}
