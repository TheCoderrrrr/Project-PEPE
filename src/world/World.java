package world;

import org.newdawn.slick.Graphics;
import world.cards.Card;
import world.managers.CardManager;

public class World {
    CardManager cardManager;
    public World() {
        cardManager = new CardManager();
    }
    public void render(Graphics g){
        cardManager.render(g);

    }
    public void update(){

    }
    public void mousePressed(int button, int x, int y)
    {
        cardManager.mousePressed(button,x , y);
    }
}
