package world.managers;

import core.Game;
import core.Main;
import core.Sounds;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import world.World;
import world.cards.*;
import world.entity.Entity;

import java.util.ArrayList;

public class CardManager {
    private final ArrayList<Class<? extends Card>> cards;
    private static final int HAND_SIZE = 5;
    private ArrayList<Card> hand;
    private ArrayList<Card> deck;
    private ArrayList<Card> discard;
    private ArrayList<Card> selection;
    private boolean selectionMode;
    private int totalCardWidth;
    private GameContainer gc;
    private int totalEnergy;
    private int maximumEnergy;

    public CardManager(GameContainer gc) {
        this.gc = gc;
        deck = new ArrayList<>();
        hand = new ArrayList<>();
        discard = new ArrayList<>();
        selection = new ArrayList<>();
        updateTotalCardWidth();
        updateCardPositions();
        selectionMode = false;
        totalEnergy = 4;
        maximumEnergy = totalEnergy;

        //populate deck
        cards = new ArrayList<>();
        cards.add(ExampleBuffCard.class);
        cards.add(ExampleCard.class);
        cards.add(ExampleCard2.class);
        cards.add(ExampleDebuffCard.class);


        for (int i = 0; i < 30; i++) {
            if (Math.random() < 0.5) {
                deck.add(new ExampleCard2(gc));
            } else {
                deck.add(new ExampleDebuffCard(gc));
            }
        }

        //populate hand
        resetHand();
    }

    public GameContainer getGC() {
        return gc;
    }

    public void update() {
        overCard();
    }

    public void endTurn() {
        World.setPlayerTurn(false);
    }

    //call when the enemy ends their turn
    public void resetHand() {
        //add all unused cards back to deck
        deck.addAll(hand);
        hand.clear();

        //randomly pick cards from deck
        for (int i = 0; i < HAND_SIZE; i++) {
            hand.add(deck.remove((int) (Math.random() * deck.size())));
        }
        updateTotalCardWidth();
        updateCardPositions();
    }
    public void resetEnergy()
    {
        totalEnergy = maximumEnergy;
    }

    //call this method when all enemies have been defeated
    public void newRound() {
        resetHand();
        selection = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            try {
                selection.add(cards.get((int) (Math.random() * selection.size())).getDeclaredConstructor(GameContainer.class).newInstance(gc));
                selection.getLast().moveCard(i * Main.getScreenWidth() / 3, Main.getScreenHeight() / 2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void render(Graphics g) {
        for (Card c : hand) {
            c.render(g);
        }
    }

    public void updateTotalCardWidth() {
        totalCardWidth = Card.getWidth() * hand.size();
    }

    public void updateCardPositions() {
        int zeroPos = Main.getScreenWidth() / 2;
        int firstCardX = zeroPos - totalCardWidth / 2;
        for (int i = 0; i < hand.size(); i++) {
            hand.get(i).moveCard(firstCardX + i * Card.getWidth(), (int) (Main.getScreenHeight() - Card.getHeight() * 0.6));
        }
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void updateRotation(Card c) {
        double cardX = c.getCenterX();
        double cardY = c.getCenterY();
        double zeroX = (double) Main.getScreenWidth() / 2;
        double zeroY = Main.getScreenHeight() * 2;

        cardX = zeroX + cardX;
        cardY = zeroY + cardY;

        float rotation = (float) (Math.atan2(cardX, cardY) * 180 / Math.PI);
        c.setRotation(rotation);
    }

    public void mousePressed(int button, int x, int y) {
        if (button == 1) {
            removeCard(x, y);
        } else if (button == 0) {
            for (Card c : hand) {
                if (c.isOver(x, y)) {
                    c.select(x, y);
                    selectionMode = true;
                }
            }
        }
    }

    public void removeCard(int x, int y) {
        for (int i = 0; i < hand.size(); i++) {
            if (hand.get(i).isOver(x, y)) {
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

    public void useCard(Card c, Entity e) {
        c.action(e);
        if (c instanceof StatusEffect) {
            ((StatusEffect) c).applyEffect(e);
        }
        hand.remove(c);
        deck.add(c);
        updateTotalCardWidth();
        updateCardPositions();
        Sounds.REEEEEEEEE.play();
        totalEnergy -= c.getEnergyCost();

    }

    public void useCard(Card c, ArrayList<Entity> entities) {

        c.action(entities);
        if (c instanceof StatusEffect) {
            for (Entity e : entities)
                ((StatusEffect) c).applyEffect(e);
        }
        hand.remove(c);
        deck.add(c);
        updateTotalCardWidth();
        updateCardPositions();
        Sounds.REEEEEEEEE.play();
        totalEnergy -= c.getEnergyCost();
    }

    public void overCard() {
        for (Card c : hand) {
            if (c.isOver(gc.getInput().getMouseX(), gc.getInput().getMouseY())) {
                c.hoveredPos();
            } else {
                c.defaultPos();
            }
        }
    }

    public void mouseReleased(int button, int x, int y) {
        for (Card c : hand) {
            if (c.selected() && button == 0) {
                c.unselect(x, y);
                selectionMode = false;
            }
        }
    }

    public boolean getSelectionMode() {
        return selectionMode;
    }

    public int getCurEnergy() {
        return totalEnergy;
    }

    public int getMaximumEnergy() {
        return maximumEnergy;
    }

    public boolean enoughEnergy(Card c) {
        return !(totalEnergy - c.getEnergyCost() < 0);
    }
}
