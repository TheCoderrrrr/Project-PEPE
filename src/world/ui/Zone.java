package world.ui;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import world.entity.Entity;

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
    public Zone(Entity entity)
    {
        x = entity.getX() - 100;
        y = entity.getY() - 100;
        width = 200;
        height = 300;

    }
    public void render(Graphics g)
    {
        g.setColor(Color.red);
        g.drawRect(x, y, width, height);
    }
    public boolean isOver(int cardX, int cardY)
    {
        return cardX > x && cardX < x + width && cardY > y && cardY < y + height;
    }
}
