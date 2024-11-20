package world.ui;

import org.newdawn.slick.Graphics;
import world.cards.Card;
import world.managers.CardManager;
import world.managers.EntityManager;

public class GameUI {
    private boolean selected;
    private Card selectedCard;
    private CardManager cardManager;
    private EntityManager entityManager;
    public GameUI(CardManager cardManager, EntityManager entityManager)
    {
        selected = false;
        this.cardManager = cardManager;
        this.entityManager = entityManager;
    }
    public void render(Graphics g)
    {
        if(selected)
        {

        }
    }
    public void update()
    {
        updateSelected();
    }
    public void updateSelected()
    {
        for(Card c : cardManager.getHand())
        {
            if(c.selected())
            {
                selected = true;
                selectedCard = c;
            }
        }
    }
    public void selectionScreen(Graphics g){

    }
}
