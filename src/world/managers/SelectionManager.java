package world.managers;

import core.Main;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;
import world.cards.*;
import world.cards.self.ExtraStuffingCard;
import world.cards.self.SewingCard;
import world.cards.single.MaulCard;

import java.util.ArrayList;
import java.util.List;

public class SelectionManager {
    private static List<Class<? extends Card>> cards;
    private static List<Card> cardSelection;
    private static GameContainer gc;
    private static StateBasedGame sbg;

    public SelectionManager(StateBasedGame sbg, GameContainer gc) {
        SelectionManager.gc = gc;
        SelectionManager.sbg = sbg;
        cards = new ArrayList<>();
        cards.add(SewingCard.class);
        cards.add(MaulCard.class);
        cards.add(ExtraStuffingCard.class);
    }

    //call this method when all enemies have been defeated
    public static void generateSelections() {
        cardSelection = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            try {
                cardSelection.add(cards.get((int) (Math.random() * cards.size())).getDeclaredConstructor().newInstance());
                cardSelection.getLast().moveCard(250 + i * Main.getScreenWidth() / 3, Main.getScreenHeight() / 2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void update() {

    }

    public static void render(Graphics g) {
        g.setColor(Color.white);
        g.drawString("SELECT A CARD", (float) Main.getScreenWidth()/2, (float) Main.getScreenHeight()/2);
        g.drawRect((float) Main.getScreenWidth() /2 - 25, (float) (Main.getScreenHeight() * 3) /4 - 25, 50, 50);
        g.drawString("Continue", (float) Main.getScreenWidth() /2, (float) (Main.getScreenHeight() * 3) /4);
        for(Card c : cardSelection) {
            c.render(g);
        }
    }

    public static void mousePressed(int button, int x, int y) {
        for(Card c : cardSelection) {
            if(c.isOver(x, y)) {
                for(Card c1 : cardSelection) {
                    c1.unoutline();
                }
                c.outline();
            }
        }

        if(x < Main.getScreenWidth()/2 + 25 && x > Main.getScreenWidth()/2 - 25 && y > Main.getScreenHeight()*3/4 - 25 && y < Main.getScreenHeight()*3/4 + 25) {
            //add selected card to deck
            for(Card c : cardSelection) {
                if(c.isOutlined()) {
                    CardManager.addCardToDeck(c);
                    sbg.enterState(Main.GAME_ID);
                }
            }
        }
    }
}
