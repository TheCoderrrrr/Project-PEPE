package world.cards;

import core.Images;
import org.newdawn.slick.GameContainer;

public class ExampleCard2 extends GlobalCard{

    public ExampleCard2(GameContainer gc){
        super(gc);
        cost = 1;
        rarity = 2;
        image = Images.PLACEHOLDERCARD;
    }

}
