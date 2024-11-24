package world.ui;

import core.Main;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import world.cards.Card;
import world.entity.EnemyUnit;
import world.entity.Entity;
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
        zones = new ArrayList<>();
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
        if(!zones.isEmpty())
        {
            for(Zone z : zones)
            {
                z.render(g);
            }
        }
    }
    public void setZones()
    {
        if(selectedCard != null && selectedCard.getCardType().equals("SingleTarget") )
        {
            zones.add(new Zone(Main.getScreenWidth() /5, Main.getScreenHeight() /5, Main.getScreenWidth()/5 * 3, Main.getScreenHeight() /5 * 3));
        }
        else if(selectedCard != null && selectedCard.getCardType().equals("MultiTarget"))
        {
            for(Entity e : entityManager.getEntities())
            {
                if(e instanceof EnemyUnit)
                {
                    zones.add(new Zone(e));
                }
            }
        }
        if(selectedCard == null)
        {
            for(int i = zones.size(); i > 0; i--)
            {
                zones.remove(i - 1);
            }
        }
    }
    public void useCard(Card c, int x, int y) {
        for(Zone z: zones)
        {
            if(z.isOver(x, y))
            {
                cardManager.useCard(c);
            }
            else {
                c.moveCard((int)c.originalPos().x, (int)c.originalPos().y);
            }
        }

    }
    public void useCard(Card c,Entity e, int x, int y)
    {
        for(Zone z: zones)
        {
            if(z.isOver(x, y))
            {
                cardManager.useCard(c);
            }
            else {
                c.moveCard((int)c.originalPos().x, (int)c.originalPos().y);
            }
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
