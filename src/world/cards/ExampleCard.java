package world.cards;

import org.newdawn.slick.GameContainer;

public class ExampleCard extends Card{

    public ExampleCard(GameContainer gc, int x, int y, int rotation){
        super(gc, x, y, rotation);
        cost = 1;
        rarity = 2;
    }
    @Override
    public void action() {

    }
}
