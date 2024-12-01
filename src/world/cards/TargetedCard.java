package world.cards;

import org.newdawn.slick.GameContainer;
import world.entity.Entity;

public abstract class TargetedCard extends Card{
    public TargetedCard() {
        super();
        cardType = "SingleTarget";
    }

}
