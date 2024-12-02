package world.ui;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import world.entity.Entity;

public class Zone {
    private int x;
    private int y;
    private int width;
    private int height;
    private Entity entity;
    public Zone(int x, int y, int width, int height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    public Zone(Entity entity)
    {
        this.entity = entity;
        x = (int) (entity.getX() - entity.getWidth() * 0.25);
        y = (int) (entity.getY() - entity.getHeight() * 0.25);
        width = (int) (entity.getWidth() + entity.getWidth() * 0.5);
        height = (int) (entity.getHeight() + entity.getHeight() * 0.5);

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
    public Entity getEntity()
    {
        return entity;
    }
}
