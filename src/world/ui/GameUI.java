package world.ui;

import core.Main;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import world.cards.Card;
import world.managers.CardManager;
import world.managers.EntityManager;

import java.util.ArrayList;

public class GameUI {
    private boolean selected;
    private Card selectedCard;
    private CardManager cardManager;
    private EntityManager entityManager;
    private Zone placementZones;
    private ArrayList<Zone> zones;
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
        g.setColor(Color.red);
        g.drawRect(100, 100, 200, 200);
    }
    public void update()
    {
        updateSelected();
        setZones();
        System.out.println(selected);
    }
    public void updateSelected()
    {
        if(cardManager.getSelectionMode())
        {
            selected = true;
            for(Card c : cardManager.getHand())
            {
                if(c.selected())
                {
                    selectedCard = c;
                }
            }
        }else{
            selected = false;
            selectedCard = null;
        }
    }
    public void selectionScreen(Graphics g){
        if(placementZones != null)
        {
            placementZones.render(g);
        }
    }
    public void setZones()
    {
        if(selectedCard != null && selectedCard.getCardType().equals("SingleTarget") )
        {
            zones.add(new Zone(Main.getScreenWidth() /5, Main.getScreenHeight() /5, Main.getScreenWidth()/5 * 3, Main.getScreenHeight() /5 * 3));
        }
        if(selectedCard == null)
        {
            zones.removeAll();
        }
    }
    public void useCard(Card c, int x, int y) {
        if(placementZones.isOver(x, y))
        {
            cardManager.useCard(c);
        }
    }
    public void mouseReleased(int button, int x, int y)
    {
        if(selected && button == 0)
        {
            useCard(selectedCard,x , y);
        }
    }
}
