package world.cards;

import org.newdawn.slick.GameContainer;
import world.effects.Poison;
import world.entity.Entity;

public class ExampleDebuffCard extends TargetedCard implements StatusEffect{

    public ExampleDebuffCard(GameContainer gc) {
        super(gc);
    }

    public void action(Entity e) {

    }

    @Override
    public void applyEffect(Entity e) {
        e.addEffect(new Poison(e, 10, 5));
    }
}
