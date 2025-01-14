package world.ui;

import core.Main;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import world.cards.Card;
import world.entity.enemy.EnemyUnit;
import world.entity.Entity;
import world.entity.PlayerUnit;
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
        renderHealthBars(g);
        renderEnergy(g);
        renderEffects(g);
        renderEnemyNextMove(g);
    }
    public void update()
    {
        updateSelected();
        setZones();
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
    public void renderEnergy(Graphics g)
    {
        g.setColor(Color.blue);
        g.drawString("current energy / maximum energy : " + cardManager.getCurEnergy() + " / " + cardManager.getMaximumEnergy(), (float) (Main.getScreenWidth() * 0.05), (float) (Main.getScreenHeight() * 0.9));
    }
    public void renderHealthBars(Graphics g){
        for(Entity e : entityManager.getEntities())
        {
            g.setColor(Color.black);
            g.fillRect((float) e.getX(), (float) (e.getY() + e.getHeight() - Main.getScreenHeight() * 0.01), (float) e.getWidth(), (float) (Main.getScreenHeight() * 0.01));
            g.setColor(Color.red);
            g.fillRect((float) e.getX(), (float) (e.getY() + e.getHeight() - Main.getScreenHeight() * 0.01), (float) e.getWidth() * e.getPercentHealthLeft(), (float) (Main.getScreenHeight() * 0.01));
        }
    }
    public void renderEffects(Graphics g)
    {
        for(Entity e : entityManager.getEntities())
        {
            e.getStatusEffectPanel().render(g);
        }
    }
    public void renderEnemyNextMove(Graphics g) {
        for(Entity e : entityManager.getEntities())
        {
            if(e instanceof EnemyUnit){
                ((EnemyUnit) e).getNextMovePanel().render(g);
            }
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
        if(selectedCard != null)
        {
            if(selectedCard.getCardType().equals("MultiTarget") )
            {
                zones.add(new Zone(Main.getScreenWidth() /5, Main.getScreenHeight() /5, Main.getScreenWidth()/5 * 3, Main.getScreenHeight() /5 * 3));
            }
            else if(selectedCard.getCardType().equals("SingleTarget"))
            {
                for(Entity e : entityManager.getEntities())
                {
                    if(e instanceof EnemyUnit)
                    {
                        zones.add(new Zone(e));
                    }
                }
            }
            else if(selectedCard.getCardType().equals("SelfTarget"))
            {
                for(Entity e : entityManager.getEntities())
                {
                    if(e instanceof PlayerUnit)
                    {
                        zones.add(new Zone(e));
                    }
                }
            }
        }
        if(selectedCard == null)
        {
            zones.clear();
        }
    }
    public void useCard(Card c, int x, int y)
    {
        for(Zone z: zones)
        {
            if(z.isOver(x, y) && cardManager.enoughEnergy(c))
            {
                if(z.getEntity() != null)
                {
                    cardManager.useCard(c, z.getEntity());
                }
                else{
                    cardManager.useCard(c, entityManager.getEntities());
                }
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
        updateSelected();
        setZones();
    }
    public void mousePressed(int button, int x, int y)
    {
        updateSelected();
        setZones();
    }
}
