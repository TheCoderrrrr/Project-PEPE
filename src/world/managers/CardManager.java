package world.managers;

import core.Game;
import core.Main;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import world.cards.*;
import world.entity.Entity;

import java.util.ArrayList;

public class CardManager {
    private static final int HAND_SIZE = 5;
    private ArrayList<Card> hand;
    private ArrayList<Card> deck;
    private ArrayList<Card> discard;
    private boolean selectionMode;
    private int totalCardWidth;
    private GameContainer gc;
    public CardManager(GameContainer gc)
    {
        this.gc = gc;
        deck = new ArrayList<>();
        hand = new ArrayList<>();
        discard = new ArrayList<>();
        updateTotalCardWidth();
        updateCardPositions();
        selectionMode = false;

        //populate deck

        for(int i=0; i<30; i++)
        {
            if(Math.random() < 0.5) {
                deck.add(new ExampleCard2(gc));
            } else {
                deck.add(new ExampleDebuffCard(gc));
            }
        }

        //populate hand
        endTurn();
    }
    public GameContainer getGC()
    {
        return gc;
    }

    public void update()
    {
//        overCard();
    }

    public void endTurn()
    {
        //add all unused cards back to deck
        deck.addAll(hand);
        hand.clear();

        //randomly pick cards from deck
        for(int i=0; i<HAND_SIZE; i++)
        {
            hand.add(deck.remove((int) (Math.random() * deck.size())));
        }
        updateTotalCardWidth();
        updateCardPositions();
    }
    public void render(Graphics g)
    {
        for(Card c: hand)
        {
            c.render(g);
        }
    }
    public void updateTotalCardWidth()
    {
        totalCardWidth = Card.getWidth() * hand.size();
    }
    public void updateCardPositions()
    {
        int zeroPos = Main.getScreenWidth()/2;
        int firstCardX = zeroPos - totalCardWidth/2;
        for(int i = 0; i < hand.size(); i++)
        {
            hand.get(i).moveCard(firstCardX + i * Card.getWidth(), (int) (Main.getScreenHeight()-Card.getHeight()*0.6));
        }
    }
    public ArrayList<Card> getHand()
    {
        return hand;
    }
    public void updateRotation(Card c)
    {
        double cardX = c.getCenterX();
        double cardY = c.getCenterY();
        double zeroX = (double) Main.getScreenWidth() /2;
        double zeroY = Main.getScreenHeight() * 2;

        cardX = zeroX + cardX;
        cardY = zeroY + cardY;

        float rotation = (float) (Math.atan2(cardX, cardY) * 180 / Math.PI);
        c.setRotation(rotation);
    }
    public void mousePressed(int button, int x, int y)
    {
        if(button == 1)
        {
            removeCard(x, y);
        }
        else if(button == 0)
        {
            for(Card c : hand)
            {
                if(c.isOver(x, y))
                {
                    c.select(x, y);
                    selectionMode = true;
                }
            }
        }
    }

    public void removeCard(int x, int y)
    {
        for(int i = 0; i < hand.size(); i++)
        {
            if(hand.get(i).isOver(x, y))
            {
                //
                deck.add(hand.remove(i));
                //

                updateTotalCardWidth();
                updateCardPositions();
//                for(Card c: hand)
//                {
//                    updateRotation(c);
//                }
                return;
            }
        }
    }
    public void useCard(Card c, Entity e)
    {
        c.action(e);
        if(c instanceof StatusEffect) {
            ((StatusEffect) c).applyEffect(e);
        }
        hand.remove(c);
        updateTotalCardWidth();
        updateCardPositions();
    }
//    public void overCard()
//    {
//        for(Card c : hand)
//        {
//            if(c.isOver(gc.getInput().getMouseX(), gc.getInput().getMouseY()))
//            {
//                c.moveCard(c.getX(), c.getY() - 100);
//            }
//            else {
//                c.originalPos();
//            }
//        }
//    }
    public void mouseReleased(int button, int x, int y)
    {
        for(Card c : hand)
        {
            if(c.selected() && button == 0)
            {
                c.unselect(x, y);
                selectionMode = false;
            }
        }
    }
    public boolean getSelectionMode()
    {
        return selectionMode;
    }
}
