package core;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Main extends StateBasedGame 
{
	public final static int FRAMES_PER_SECOND = 60;
	private static AppGameContainer appgc;

	public static final int MENU_ID = 0;
    public static final int GAME_ID = 1;
	public static final int PAUSE_ID = 2;
	public static final int CARD_SELECTION_ID = 3;

	private BasicGameState menu;
    private BasicGameState game;
	private BasicGameState pause;
	private BasicGameState cardSelection;
    
	public Main(String name) 
	{
		super(name);

		menu = new Menu(MENU_ID);
		game = new Game(GAME_ID);
		pause = new Pause(PAUSE_ID);
		cardSelection = new CardSelection(CARD_SELECTION_ID);

	}

	public static int getScreenWidth()
	{
		return appgc.getScreenWidth();
	}
	
	public static int getScreenHeight()
	{
		return appgc.getScreenHeight();
	}
	

	public void initStatesList(GameContainer gc) throws SlickException 
	{
		addState(menu);
		addState(game);
		addState(pause);
		addState(cardSelection);
	}

	public static void main(String[] args) 
	{
		try 
		{
			appgc = new AppGameContainer(new Main("My First Project"));
			System.setProperty("org.lwjgl.opengl.Window.undecorated", "true");
		
			appgc.setDisplayMode(appgc.getScreenWidth(), appgc.getScreenHeight(), false);
			appgc.setTargetFrameRate(FRAMES_PER_SECOND);
			appgc.setVSync(true);
			appgc.start();

		} 
		catch (SlickException e) 
		{
			e.printStackTrace();
		}

	}
}