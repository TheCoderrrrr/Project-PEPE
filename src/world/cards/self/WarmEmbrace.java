package world.cards.self;

import world.cards.Card;
import world.cards.StatusEffect;
import world.effects.buff.Healing;
import world.entity.Entity;

public class WarmEmbrace extends Card implements StatusEffect {
    public WarmEmbrace()
    {
        super();
        energyCost = 1;
    }
    @Override
    public void applyEffect(Entity e) {
        e.addEffect(new Healing(e, 1.5f, 2));
    }
}
