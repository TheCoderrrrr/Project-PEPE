package world.managers;

import core.Game;
import core.Main;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import world.cards.Card;
import world.cards.ExampleCard;

import java.util.ArrayList;

public class CardManager {
    private ArrayList<Card> hand;
    private ArrayList<Card> discardPile;
    private ArrayList<Card> Deck;
    private int totalCardWidth;
    private GameContainer gc;
    public CardManager(GameContainer gc)
    {
        this.gc = gc;
        hand = new ArrayList<>();
        hand.add(new ExampleCard(gc, Main.getScreenWidth()/2, (int) (Main.getScreenHeight()-Card.getHeight()*0.6),0));
        updateTotalCardWidth();
        updateCardPositions();
//        for(Card c: hand)
//        {
//            updateRotation(c);
//        }
    }
    public GameContainer getGC()
    {
        return gc;
    }

    public void update()
    {

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
        if(button == 2)
        {
            addCard();
        }else if(button == 1)
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
                }
            }
        }
    }
    public void addCard()
    {
//        int i = 0;
        hand.add(new ExampleCard(gc, Main.getScreenWidth()/2, (int) (Main.getScreenHeight()-Card.getHeight()*0.6), 0));
        updateTotalCardWidth();
        updateCardPositions();
//        for(Card c: hand)
//        {
//            updateRotation(c);
//            i++;
//            System.out.println("number card : " + i + " , rotation : " + c.getRotation());
//        }
//        i = 0;
    }
    public void removeCard(int x, int y)
    {
        for(int i = 0; i < hand.size(); i++)
        {
            if(hand.get(i).isOver(x, y))
            {
                hand.remove(i);
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
    public void mouseReleased(int button, int x, int y)
    {
        for(Card c : hand)
        {
            if(c.selected() && button == 0)
            {
                c.unselect(x, y);
            }
        }
    }
}
