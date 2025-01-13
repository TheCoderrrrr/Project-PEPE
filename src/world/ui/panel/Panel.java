package world.ui.panel;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import javax.tools.Tool;

public class Panel {
    protected int x;
    protected int y;
    protected int height;
    protected int width;
    protected final int DEFAULT_WIDTH = 200;
    protected final int DEFAULT_HEIGHT = 100;
    protected Tooltip tooltip;
    protected static GameContainer gc;
    public Panel(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }
    public Panel(int x, int y){
        this.x = x;
        this.y = y;
        height = DEFAULT_HEIGHT;
        width = DEFAULT_WIDTH;
    }
    public static void setGC(GameContainer gc){
        Panel.gc = gc;
    }
    public void render(Graphics g){
        g.drawRect(x, y, width, height);
    }
}
