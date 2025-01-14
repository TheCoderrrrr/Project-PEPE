package world.enemyMoveset.moves.godzillaMoves;

import resources.Sounds;
import world.cards.StatusEffect;
import world.effects.debuff.Mark;
import world.enemyMoveset.moves.AttackMove;
import world.entity.Entity;

public class PlasmaRay extends AttackMove implements StatusEffect{

    public PlasmaRay()
    {
        info = "Does 30 damage and 'Mark' effect is applied";
    }

    @Override
    public void action(Entity entity) {
        entity.takeDamage(30);
        Sounds.MUSICATTACK.play(0.6f, 0.6f);
    }

    @Override
    public void applyEffect(Entity e) {
        e.addEffect(new Mark(e, 1, 2));
    }
}
