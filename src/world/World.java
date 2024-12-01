package world;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import world.cards.Card;
import world.managers.CardManager;
import world.managers.EntityManager;

public class World {
    private CardManager cardManager;
    public EntityManager entityManager;
    private GameContainer gc;
    private int turn = 0;
    private static boolean playerTurn;
    private static String mode;

    public World(GameContainer gc, CardManager cardManager, EntityManager entityManager) {
        this.gc = gc;
        playerTurn = true;
        this.cardManager = cardManager;
        this.entityManager = entityManager;
        mode = "Round";
    }

    public void render(Graphics g) {
        g.drawString(" " + turn, 100, 100);
        cardManager.render(g);
        entityManager.render(g);
    }

    public void update(int delta) {
        cardManager.update();
        entityManager.update();
        if(!playerTurn)
        {
            entityManager.enemyTurn();
            endEnemyTurn();
        }
        if(entityManager.enemiesKilled() && !mode.equals("Select")) {
            mode = "Select";
            cardManager.newRound();
        }
    }
    public void endPlayerTurn()
    {
        cardManager.endTurn();
    }
    public void endEnemyTurn()
    {
        entityManager.endTurn();
        nextTurn();
    }

    public void nextTurn() {
        turn++;
        cardManager.resetHand();
        cardManager.resetEnergy();
    }
    public void mousePressed(int button, int x, int y) {
        if (playerTurn) {
            cardManager.mousePressed(button, x, y);
        }
    }

    public void mouseReleased(int button, int x, int y) {
        if (playerTurn) {
            cardManager.mouseReleased(button, x, y);
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
}
