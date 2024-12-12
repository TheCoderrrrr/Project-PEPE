package core;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import resources.Fonts;

public class Menu extends BasicGameState
{
    StateBasedGame sbg;
    private int id;
    private int trans;
    private int djnfsbhf;
    public Menu(int id)
    {
        this.id = id;
    }

    public int getID()
    {
        return id;
    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
    {
        Fonts.loadFonts();
        this.sbg = sbg;
        gc.setShowFPS(true);
        trans = 255;
        djnfsbhf = 10;
    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
    {
        if(djnfsbhf > 0)
        {
            djnfsbhf--;
        }else{
            djnfsbhf = 3;
            trans--;
        }
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
    {
        g.setColor(new Color(255, 255, 255, trans));
        Fonts.MATCHA.drawStringCentered(g,"MENU\nSPACE TO ENTER GAME", (float) Main.getScreenWidth()/2, (float) Main.getScreenHeight()/2);
        Fonts.MATCHA.drawStringCentered(g,"MENU\nSPACE TO ENTER GAME", (float) Main.getScreenWidth()/2, (float) Main.getScreenHeight()/2);
        Fonts.MATCHA.drawString(g,"REEEEEE", 0,0, 10);

    }

    public void enter(GameContainer gc, StateBasedGame sbg) throws SlickException
    {
    }

    public void leave(GameContainer gc, StateBasedGame sbg)
    {
    }

    public void keyPressed(int key, char c)
    {
        if (key == Input.KEY_SPACE)
        {
            sbg.enterState(Main.GAME_ID);
        }
    }

    public void mousePressed(int button, int x, int y)
    {

    }
    public void mouseReleased(int button, int x, int y){

    }



}