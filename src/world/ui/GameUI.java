package world.ui;

import core.Main;
import org.newdawn.slick.Graphics;
import world.cards.Card;
import world.managers.CardManager;
import world.managers.EntityManager;

public class GameUI {
    private boolean selected;
    private Card selectedCard;
    private CardManager cardManager;
    private EntityManager entityManager;
    private Zone placementZones;
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
            selectionScreen(g);
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
        if(placementZones != null)
        {
            placementZones.render(g);
        }
    }
    public void setZones(int x, int y)
    {
        if(selectedCard.getCardType().equals("SingleTarget"))
        {
            placementZones = new Zone((Main.getScreenWidth() /4, Main.getScreenHeight() /4, Main.getScreenWidth() /4*3, Main.getScreenHeight() /4*3);
        }
    }

}
