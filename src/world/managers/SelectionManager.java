package world.managers;

import core.Main;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;
import resources.Fonts;
import world.cards.*;
import world.cards.multi.attack.ButtonBarrage;
import world.cards.multi.attack.NeedleToss;
import world.cards.multi.attack.ThreadTornado;
import world.cards.multi.debuff.ButtonBomb;
import world.cards.multi.debuff.ComfortCurse;
import world.cards.multi.debuff.StuffedSorrow;
import world.cards.self.*;
import world.cards.single.attack.*;
import world.cards.single.debuff.CuddleCrush;
import world.cards.single.debuff.CupidsArrow;
import world.cards.single.debuff.MuffledRoar;
import world.cards.single.debuff.StitchedSilence;

import java.util.ArrayList;
import java.util.List;

public class SelectionManager {
    private static List<Class<? extends Card>> cards;
    private static List<Card> cardSelection;
    private static GameContainer gc;
    private static StateBasedGame sbg;
    private static boolean selected;

    public SelectionManager(StateBasedGame sbg, GameContainer gc) {
        SelectionManager.gc = gc;
        SelectionManager.sbg = sbg;
        cards = new ArrayList<>();
        cards.add(NeedleToss.class);
        cards.add(ThreadTornado.class);
        cards.add(ButtonBomb.class);
        cards.add(ComfortCurse.class);
        cards.add(StuffedSorrow.class);
        cards.add(BearsYearning.class);
        cards.add(ExtraStuffing.class);
        cards.add(FallacyOfReturn.class);
        cards.add(PlushPerfection.class);
        cards.add(PrimalRage.class);
        cards.add(Sewing.class);
        cards.add(WarmEmbrace.class);
        cards.add(BearBite.class);
        cards.add(BearHug.class);
        cards.add(MaulCard.class);
        cards.add(PawCrush.class);
        cards.add(PawPummel.class);
        cards.add(CuddleCrush.class);
        cards.add(CupidsArrow.class);
        cards.add(MuffledRoar.class);
        cards.add(StitchedSilence.class);

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
        g.drawString("SELECT A CARD", (float) Main.getScreenWidth()/2, (float) Main.getScreenHeight()/8 * 5);
        if(selected)
        {
            g.setColor(Color.green);
        }else{
            g.setColor(Color.white);
        }
        g.drawRect((float) Main.getScreenWidth() / 2 - 50, (float) (Main.getScreenHeight() * 3) /4 - 40, 200, 50);
        Fonts.DOGICAPIXEL.drawString(g, "Continue", (float) Main.getScreenWidth() / 2 - 50, (float) (Main.getScreenHeight() * 3) /4 - 25, 30);
        for(int i = 0; i < cardSelection.size(); i++)
        {
            Card c = cardSelection.get(i);
            c.moveCard(Main.getScreenWidth() / 4 * (i + 1), Main.getScreenHeight() /4);
            c.render(g);
        }

    }

    public static void mousePressed(int button, int x, int y) {
        for(Card c : cardSelection) {
            if(c.isOver(x, y)) {
                for(Card c1 : cardSelection) {
                    c1.unoutline();
                    selected = false;
                }
                c.outline();
                selected = true;
            }
        }
        System.out.println(selected);

        if(x < Main.getScreenWidth()/2 + 150 && x > Main.getScreenWidth()/2 - 50 && y > Main.getScreenHeight()*3/4 - 40 && y < Main.getScreenHeight()*3/4 + 10) {
            //add selected card to deck
            for(Card c : cardSelection) {
                if(c.isOutlined()) {
                    c.unoutline();
                    selected = false;
                    CardManager.addCardToDeck(c);
                    sbg.enterState(Main.GAME_ID);
                }
            }
        }
    }
}
