package world.managers;

import core.Main;
import org.newdawn.slick.Graphics;
import world.cards.Card;
import world.cards.ExampleCard;

import java.util.ArrayList;

public class CardManager {
    private ArrayList<Card> hand;
    private ArrayList<Card> discardPile;
    private ArrayList<Card> Deck;
    private int totalCardWidth;
    public CardManager()
    {
        hand = new ArrayList<>();
        hand.add(new ExampleCard(Main.getScreenWidth()/2, (int) (Main.getScreenHeight()-Card.getLength()*0.6)));
        updateTotalCardWidth();
        updateCardPositions();
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
            hand.get(i).moveCard(firstCardX + i * Card.getWidth());
        }
    }
    public void mousePressed(int button, int x, int y)
    {
        if(button == 0)
        {
            addCard();
        }else if(button == 1)
        {
            removeCard(x, y);
        }
    }
    public void addCard()
    {
        hand.add(new ExampleCard(Main.getScreenWidth()/2, (int) (Main.getScreenHeight()-Card.getLength()*0.6)));
        updateTotalCardWidth();
        updateCardPositions();
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
                return;
            }
        }
    }
}
