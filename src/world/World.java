package world;

import core.Game;
import core.Main;
import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Music;
import org.newdawn.slick.state.StateBasedGame;
import resources.Images;
import resources.Sounds;
import world.cards.Card;
import world.managers.CardManager;
import world.managers.EntityManager;
import world.managers.SelectionManager;
import world.ui.FloatText;
import world.ui.panel.Panel;

import java.util.ArrayList;

public class World {
    private static CardManager cardManager;
    private static SelectionManager selectionManager;
    public static EntityManager entityManager;
    private GameContainer gc;
    private StateBasedGame sbg;
    private static int turn = 1;
    private static boolean playerTurn;
    private static String mode;
    private static ArrayList<FloatText> text;

    public World(StateBasedGame sbg, GameContainer gc, CardManager cardManager, EntityManager entityManager) {
        this.sbg = sbg;
        this.gc = gc;
        Card.setgc(gc);
        Panel.setGC(gc);
        playerTurn = true;
        selectionManager = new SelectionManager(sbg, gc);
        text = new ArrayList<>();
        World.cardManager = cardManager;
        World.entityManager = entityManager;
        mode = "Game";
    }

    public void render(Graphics g) {
        g.drawString(" " + turn, 100, 100);
        if(World.entityManager.getRound() % 10 == 0)
        {
            Game.changeBackground(Images.CREEPYBACKGROUND);
            if(Sounds.BGMUSIC1.playing())
            {
                Sounds.BGMUSIC1.stop();
            }else if(Sounds.BGMUSIC2.playing()){
                Sounds.BGMUSIC2.stop();
            }
            Sounds.BOSSMUSIC.loop(1, 0.2f);
        }
        else{
            Game.changeBackground(Images.HAPPYBACKGROUND);
            if(Sounds.BOSSMUSIC.playing())
            {
                Sounds.BOSSMUSIC.stop();
                if(Math.random() < 0.5){
                    Sounds.BGMUSIC2.play(1, 0.2f);
                }else{
                    Sounds.BGMUSIC1.play(1, 0.2f);
                }
            }
        }
        entityManager.render(g);
        CardManager.render(g);


        for(FloatText t : text) {
            t.render(g);
        }
    }

    public void update(int delta) {


        if(!playerTurn && !entityManager.isAnimating())
        {
            entityManager.enemyTurn();
        }

        CardManager.update(delta);
        entityManager.update();
        Player.updateEffects(entityManager.getEntities().getFirst().getActiveEffects());
        Player.updateStats();


        for(int i=0; i<text.size(); i++) {
            text.get(i).update();
            if(text.get(i).expired()) {
                text.remove(i);
                i--;
            }
        }


        if(entityManager.enemiesKilled()) {
            if(mode.equals("Select")) {
                mode = "Game";
                entityManager.newRound();
                CardManager.resetHand();
            } else {
                mode = "Select";
                sbg.enterState(Main.CARD_SELECTION_ID);
                CardManager.resetHand();
            }
        }
        if(entityManager.getEntities().getFirst().getCurHealth() <= 0)
        {
            Game.lose();
        }
    }
    public static void endPlayerTurn()
    {
        World.setPlayerTurn(false);
    }


    public static void nextTurn() {
        turn++;
        CardManager.resetHand();
        CardManager.resetEnergy();
    }
    public void mousePressed(int button, int x, int y) {
        if (playerTurn) {
            CardManager.mousePressed(button, x, y);
        }
    }

    public void mouseReleased(int button, int x, int y) {
        if (playerTurn) {
            CardManager.mouseReleased(button, x, y);
        }
    }

    public int getTurn() {
        return turn;
    }

    public static boolean isPlayerTurn()
    {
        return playerTurn;
    }
    public static void setPlayerTurn(boolean playerTurn) {
        World.playerTurn = playerTurn;
    }

    public static SelectionManager getSelectionManager() {
        return selectionManager;
    }

    public static void addText(int x, int y, int size, String s, Font f) {
        text.add(new FloatText(x, y, size, s, f));
    }

}
