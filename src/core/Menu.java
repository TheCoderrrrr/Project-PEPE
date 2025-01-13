package core;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import resources.Fonts;

public class Menu extends BasicGameState {
    StateBasedGame sbg;
    private int id;
    private int trans;

    public Menu(int id) {
        this.id = id;
    }

    public int getID() {
        return id;
    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        Fonts.loadFonts();
        this.sbg = sbg;
        gc.setShowFPS(true);
        trans = 255;
    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        trans--;
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
//        g.setColor(new Color(255, 255, 255, trans));
//        Fonts.MATCHA.drawStringCentered(g,"MENU\nSPACE TO ENTER GAME", (float) Main.getScreenWidth()/2, (float) Main.getScreenHeight()/2);
        g.setColor(Color.blue);
        g.fillRect((float) (Main.getScreenWidth() * .25), (float) (Main.getScreenHeight() * .75), 50, Fonts.COFFEEHEALINGITALIC.getHeight(g, "WITH GREAT POWER COMES NO RESPONSIBILITY", 50, 20));
        g.setColor(Color.white);
        Fonts.COFFEEHEALINGITALIC.wrap(g, "WITH GREAT POWER COMES NO RESPONSIBILITY", (float) (Main.getScreenWidth() * .25), (float) (Main.getScreenHeight() * .75), 50, 20);
        Fonts.MATCHA.wrap(g, "WITH GREAT POWER COMES NO RESPONSIBILITY", (float) (Main.getScreenWidth() * .35), (float) (Main.getScreenHeight() * .55), 200, 20);
        Fonts.SAZIGONE.wrap(g, "WITH GREAT POWER COMES NO RESPONSIBILITY", (float) (Main.getScreenWidth() * .45), (float) (Main.getScreenHeight() * .35), 200, 20);
        Fonts.WHETHERS.wrap(g, "WITH GREAT POWER COMES NO RESPONSIBILITY", (float) (Main.getScreenWidth() * .55), (float) (Main.getScreenHeight() * .15), 200, 20);

    }

    public void enter(GameContainer gc, StateBasedGame sbg) throws SlickException {
    }

    public void leave(GameContainer gc, StateBasedGame sbg) {
    }

    public void keyPressed(int key, char c) {
        if (key == Input.KEY_SPACE) {
            sbg.enterState(Main.GAME_ID);
        }
    }

    public void mousePressed(int button, int x, int y) {

    }

    public void mouseReleased(int button, int x, int y) {

    }


}