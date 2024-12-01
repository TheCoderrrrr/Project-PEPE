package world.cards;

import org.newdawn.slick.GameContainer;

abstract public class GlobalCard extends Card {
    public GlobalCard() {
        super();
        //Multitarget is for player buffing cards as well for now can separate this future
        cardType = "MultiTarget";
    }
}
