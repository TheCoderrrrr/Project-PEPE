package core;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import resources.Fonts;

public class Menu extends BasicGameState {
    StateBasedGame sbg;
    private int id;
    private int trans;
    private Image background;

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
        background = new Image("res/images/backgrounds/TitleScreen.png").getScaledCopy(Main.getScreenWidth(), Main.getScreenHeight());
    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        trans--;
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        g.drawImage(background,0, 0);
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