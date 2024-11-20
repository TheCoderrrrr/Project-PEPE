package world.ui;

import org.newdawn.slick.Graphics;

public class Zone {
    private int x;
    private int y;
    private int width;
    private int height;
    public Zone(int x, int y, int width, int height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    public void render(Graphics g)
    {
        g.fillRect(x, y, width, height);
    }
    public boolean isOver(int cardX, int cardY)
    {
        return cardX > x && cardX < x + width && cardY > y && cardY < y + height;
    }
}
