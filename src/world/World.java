package world;

import core.Game;
import core.Main;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;
import world.cards.Card;
import world.managers.CardManager;
import world.managers.EntityManager;
import world.managers.SelectionManager;

public class World {
    private static CardManager cardManager;
    private static SelectionManager selectionManager;
    public static EntityManager entityManager;
    private GameContainer gc;
    private StateBasedGame sbg;
    private int turn = 0;
    private static boolean playerTurn;
    private static String mode;

    public World(StateBasedGame sbg, GameContainer gc, CardManager cardManager, EntityManager entityManager) {
        this.sbg = sbg;
        this.gc = gc;
        Card.setgc(gc);
        playerTurn = true;
        selectionManager = new SelectionManager(sbg, gc);
        World.cardManager = cardManager;
        World.entityManager = entityManager;
        mode = "Game";
    }

    public void render(Graphics g) {
        g.drawString(" " + turn, 100, 100);
        CardManager.render(g);
        entityManager.render(g);
    }

    public void update(int delta) {
        CardManager.update();
        entityManager.update();
        Player.updateEffects(entityManager.getEntities().getFirst().getActiveEffects());
        Player.updateStats();
        if(!playerTurn)
        {
            entityManager.enemyTurn();
            endEnemyTurn();
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
    public void endPlayerTurn()
    {
        CardManager.endTurn();
    }
    public void endEnemyTurn()
    {
        entityManager.endTurn();
        nextTurn();
    }

    public void nextTurn() {
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
    public static void setPlayerTurn(boolean playerTurn1) {
        playerTurn = playerTurn1;
    }

    public static SelectionManager getSelectionManager() {
        return selectionManager;
    }
}
