package world.enemyMoveset.moves;

import world.cards.StatusEffect;
import world.effects.debuff.Vulnerable;
import world.entity.Entity;

public class BasicAttack extends AttackMove implements StatusEffect {
    private int damage;

    public BasicAttack() {
        super();
    }
    public void action(Entity entity)
    {
        entity.takeDamage(1);
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public void applyEffect(Entity e) {
        e.addEffect(new Vulnerable(e, 2, 5));
    }
}
