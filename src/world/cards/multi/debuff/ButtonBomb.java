package world.cards.multi.debuff;

import core.Images;
import world.cards.Card;
import world.cards.StatusEffect;
import world.cards.multi.GlobalCard;
import world.effects.debuff.Mark;
import world.entity.Entity;

public class ButtonBomb extends GlobalCard implements StatusEffect {
    public ButtonBomb()
    {
        super();
        energyCost = 2;
        name = "Button Bomb";
        description = "Adds Mark Effect";
        image = Images.BUTTON_BOMB;
    }

    @Override
    public void applyEffect(Entity e) {
        e.addEffect(new Mark(e, 1, 2));
    }
}
