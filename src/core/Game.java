package core;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import resources.Fonts;
import resources.Images;
import resources.Sounds;
import world.Player;
import world.World;
import world.entity.PlayerUnit;
import world.managers.CardManager;
import world.managers.EntityManager;
import world.ui.GameUI;

public class Game extends BasicGameState 
{
	private StateBasedGame sbg;
	private int id;
	private CardManager cardManager;
	private EntityManager entityManager;
	private static World world;
	private GameUI ui;
	private static Player player;
	private static boolean lose;
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
		lose = false;
		gc.setShowFPS(true);
		Images.loadImages();
		Sounds.loadSounds();
		Sounds.loadMusic();
		Fonts.loadFonts();
		cardManager = new CardManager(gc);
		entityManager = new EntityManager();
		player = new Player((PlayerUnit) entityManager.getEntities().getFirst());
		world = new World(sbg, gc, cardManager, entityManager);
		ui = new GameUI(cardManager, entityManager);
 		Sounds.BGMUSIC1.loop(1F, .2F);
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
	{
		world.update(delta);
		if(lose){
			sbg.enterState(Main.LOSE_ID);
		}
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException 
	{
		g.drawImage(Images.BACKGROUND.getScaledCopy(Main.getScreenWidth(), Main.getScreenHeight()), 0, 0);
		world.render(g);
		ui.render(g);
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
		if(key == Input.KEY_SPACE)
		{
			if(World.isPlayerTurn())
			{
				world.endPlayerTurn();
			}
		}
		if(key == Input.KEY_Q) {
			world.entityManager.getEntities().removeIf(entity -> !(entity instanceof PlayerUnit));
		}
	}
	
	public void mousePressed(int button, int x, int y)
	{
		world.mousePressed(button, x, y);
		ui.mousePressed(button,x , y);

	}
	public void mouseReleased(int button, int x, int y){
		world.mouseReleased(button, x, y);
		ui.mouseReleased(button, x, y);
	}
	public static void lose(){
		lose = true;
	}
}
