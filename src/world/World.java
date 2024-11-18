package world;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import world.cards.Card;
import world.managers.CardManager;
import world.managers.EntityManager;

public class World {
    CardManager cardManager;
    EntityManager entityManager;
    GameContainer gc;
    public World(GameContainer gc) {
        this.gc = gc;
        cardManager = new CardManager(gc);
        entityManager = new EntityManager();
    }
    public void render(Graphics g){
        cardManager.render(g);
        entityManager.render(g);
    }
    public void update(){

    }
    public void mousePressed(int button, int x, int y)
    {
        cardManager.mousePressed(button,x , y);
    }
    public void mouseReleased(int button, int x, int y)
    {
        cardManager.mouseReleased(button, x, y);
    }
}
