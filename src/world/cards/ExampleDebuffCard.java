package world.cards;

import world.cards.single.TargetedCard;
import world.effects.debuff.Poison;
import world.entity.Entity;

public class ExampleDebuffCard extends TargetedCard implements StatusEffect{

    public ExampleDebuffCard() {
        super();
    }

    public void action(Entity e) {

    }

    @Override
    public void applyEffect(Entity e) {
        e.addEffect(new Poison(e, 10, 5));
    }
}
