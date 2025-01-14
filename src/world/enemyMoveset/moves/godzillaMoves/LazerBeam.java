package world.enemyMoveset.moves.godzillaMoves;

import resources.Sounds;
import world.cards.StatusEffect;
import world.effects.debuff.Burn;
import world.enemyMoveset.moves.AttackMove;
import world.entity.Entity;

public class LazerBeam extends AttackMove implements StatusEffect {
    @Override
    public void action(Entity entity) {
        entity.takeDamage(30);
        Sounds.GOOFY.play(1, 0.6f);
    }

    @Override
    public void applyEffect(Entity e) {
        e.addEffect(new Burn(e, 2));
    }
}
