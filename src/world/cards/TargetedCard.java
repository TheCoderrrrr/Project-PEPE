package world.cards;

import org.newdawn.slick.GameContainer;
import world.entity.Entity;

public abstract class TargetedCard extends Card{
    public TargetedCard(GameContainer gc) {
        super(gc);
        cardType = "SingleTarget";
    }

}
