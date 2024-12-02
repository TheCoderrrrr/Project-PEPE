package world.cards.self;

import world.cards.Card;

public abstract class SelfTargetedCard extends Card {
    public SelfTargetedCard()
    {
        super();
        cardType = "SelfTarget";
    }
}
