package world.cards;

import org.newdawn.slick.GameContainer;
import world.effects.Mark;
import world.entity.Entity;

public class ExampleBuffCard extends TargetedCard implements StatusEffect{

    public ExampleBuffCard(GameContainer gc) {
        super(gc);
    }

    @Override
    public void applyEffect(Entity e) {
        e.addEffect(new Mark(e, 1.5F, 5));
    }
}
