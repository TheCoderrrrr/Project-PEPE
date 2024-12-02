package world.cards.single;

import org.newdawn.slick.GameContainer;
import world.cards.Card;
import world.entity.Entity;

public abstract class TargetedCard extends Card {
    public TargetedCard() {
        super();
        cardType = "SingleTarget";
    }

}
