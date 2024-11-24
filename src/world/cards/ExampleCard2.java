package world.cards;

import org.newdawn.slick.GameContainer;

public class ExampleCard2 extends Card{

    public ExampleCard2(GameContainer gc, int x, int y, int rotation){
        super(gc, x, y, rotation);
        cost = 1;
        rarity = 2;
        cardType = "MultiTarget";
    }
    @Override
    public void action() {

    }
}
