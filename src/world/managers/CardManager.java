package world.managers;

import core.Main;
import resources.Sounds;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import world.World;
import world.cards.*;
import world.cards.self.ExtraStuffing;
import world.cards.self.FallacyOfReturn;
import world.cards.self.WarmEmbrace;
import world.cards.single.attack.BearHug;
import world.cards.single.attack.MaulCard;
import world.cards.single.attack.Slam;
import world.entity.Entity;

import java.util.ArrayList;

public class CardManager {
    private static final int HAND_SIZE = 5;
    private static ArrayList<Card> hand;
    private static ArrayList<Card> deck;
    private static ArrayList<Card> discard;
    private static boolean selectionMode;
    private static int totalCardWidth;
    private static GameContainer gc;
    private static int totalEnergy;
    private static int maximumEnergy;

    public CardManager(GameContainer gc) {
        CardManager.gc = gc;
        deck = new ArrayList<>();
        hand = new ArrayList<>();
        discard = new ArrayList<>();
        updateTotalCardWidth();
        updateCardPositions();
        selectionMode = false;
        totalEnergy = 4;
        maximumEnergy = totalEnergy;

        //populate deck with starter cards
        deck.add(new MaulCard());
        deck.add(new BearHug());
        deck.add(new Slam());
        deck.add(new WarmEmbrace());
        deck.add(new FallacyOfReturn());
        deck.add(new ExtraStuffing());
        //populate hand
        resetHand();
    }


    public static void update(int delta) {
        overCard();
    }

    public static void addCardToDeck(Card c) {
        deck.add(c);
    }


    //call when the enemy ends their turn
    public static void resetHand() {
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

    public static void resetEnergy() {
        totalEnergy = maximumEnergy;
    }


    public static void render(Graphics g) {
        for (Card c : hand) {
            c.render(g);
        }
    }

    public static void updateTotalCardWidth() {
        totalCardWidth = Card.getWidth() * hand.size();
    }

    public static void updateCardPositions() {
        int zeroPos = Main.getScreenWidth() / 2;
        int firstCardX = zeroPos - totalCardWidth / 2;
        for (int i = 0; i < hand.size(); i++) {
            hand.get(i).moveCard(firstCardX + i * Card.getWidth(), (int) (Main.getScreenHeight() - Card.getHeight() * 0.6));
        }
    }

    public static ArrayList<Card> getHand() {
        return hand;
    }

//    public static void updateRotation(Card c) {
//        double cardX = c.getCenterX();
//        double cardY = c.getCenterY();
//        double zeroX = (double) Main.getScreenWidth() / 2;
//        double zeroY = Main.getScreenHeight() * 2;
//
//        cardX = zeroX + cardX;
//        cardY = zeroY + cardY;
//
//        float rotation = (float) (Math.atan2(cardX, cardY) * 180 / Math.PI);
//        c.setRotation(rotation);
//    }

    public static void mousePressed(int button, int x, int y) {
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

    public static void removeCard(int x, int y) {
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

    public static void useCard(Card c, Entity e) {
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

    public static void useCard(Card c, ArrayList<Entity> entities) {
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

    public static void overCard() {
        for (Card c : hand) {
            if (c.isOver(gc.getInput().getMouseX(), gc.getInput().getMouseY())) {
                c.hoveredPos();
            } else {
                c.defaultPos();
            }
        }
    }

    public static void mouseReleased(int button, int x, int y) {
        for (Card c : hand) {
            if (c.selected() && button == 0) {
                c.unselect(x, y);
                selectionMode = false;
            }
        }
    }

    public static boolean getSelectionMode() {
        return selectionMode;
    }

    public static int getCurEnergy() {
        return totalEnergy;
    }

    public static int getMaximumEnergy() {
        return maximumEnergy;
    }

    public static boolean enoughEnergy(Card c) {
        return !(totalEnergy - c.getEnergyCost() < 0);
    }
}
