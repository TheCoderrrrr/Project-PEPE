package core;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import world.World;
import world.cards.Card;
import world.cards.ExampleCard;
import world.managers.CardManager;

public class Game extends BasicGameState 
{
	StateBasedGame sbg;
	private int id;
	private World world;
	public Game(int id) 
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
			sbg.enterState(Main.PAUSE_ID);
		}
	}
	
	public void mousePressed(int button, int x, int y)
	{
		world.mousePressed(button, x, y);
		System.out.println(button + " : " + x + " : " + y);
	}
	public void mouseReleased(int button, int x, int y){
		world.mouseReleased(button, x, y);
		System.out.println(button + " : " + x + " : " + y);
	}
	


}
