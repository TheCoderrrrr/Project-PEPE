package core;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import world.World;
import world.cards.Card;
import world.cards.ExampleCard;
import world.managers.CardManager;

public class Pause extends BasicGameState
{
    StateBasedGame sbg;
    private int id;
    private World world;
    public Pause(int id)
    {
        this.id = id;
    }

    public int getID()
    {
        return id;
    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
    {
        this.sbg = sbg;
        gc.setShowFPS(true);
        world = new World(gc);
    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
    {
        world.update();
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
    {
        world.render(g);
        g.drawString("PAUSED\nM to go to menu\nP to return to game", (float) Main.getScreenWidth()/2, (float) Main.getScreenHeight()/2);
    }

    public void enter(GameContainer gc, StateBasedGame sbg) throws SlickException
    {
    }

    public void leave(GameContainer gc, StateBasedGame sbg)
    {
    }

    public void keyPressed(int key, char c)
    {
        if (key == Input.KEY_P)
        {
            sbg.enterState(Main.GAME_ID);
        } else if (key == Input.KEY_M){
            sbg.enterState(Main.MENU_ID);
        }
    }

    public void mousePressed(int button, int x, int y)
    {

    }
    public void mouseReleased(int button, int x, int y){

    }



}