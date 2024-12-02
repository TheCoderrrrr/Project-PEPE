package world.cards;

import world.cards.single.TargetedCard;
import world.effects.debuff.Mark;
import world.entity.Entity;

public class ExampleBuffCard extends TargetedCard implements StatusEffect{

    public ExampleBuffCard() {
        super();
    }

    @Override
    public void applyEffect(Entity e) {
        e.addEffect(new Mark(e, 1.5F, 5));
    }
}
