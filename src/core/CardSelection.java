package core;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import world.World;
import world.cards.Card;
import world.managers.CardManager;
import world.managers.SelectionManager;

import java.util.ArrayList;

public class CardSelection extends BasicGameState
{
    StateBasedGame sbg;
    private int id;
    ArrayList<Card> cards;
    public CardSelection(int id)
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
    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
    {
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
    {
        SelectionManager.render(g);
    }

    public void enter(GameContainer gc, StateBasedGame sbg) throws SlickException
    {
        SelectionManager.generateSelections();
    }

    public void leave(GameContainer gc, StateBasedGame sbg)
    {

    }

    public void keyPressed(int key, char c)
    {

    }

    public void mousePressed(int button, int x, int y)
    {
        SelectionManager.mousePressed(button, x, y);
    }
    public void mouseReleased(int button, int x, int y){

    }



}