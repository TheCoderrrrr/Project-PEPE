package world.cards;

import org.newdawn.slick.Graphics;

public abstract class Card {
    protected int cost;
    protected int rarity;
    protected final static int width = 200;
    protected final static int length = 300;
    protected int x;
    protected int y;
    public Card(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    public abstract void action();
    public void render(Graphics g)
    {
        g.drawRect(x, y, width, length);
    }
    public static int getWidth()
    {
        return width;
    }
    public static int getLength()
    {
        return length;
    }
    public int getCost()
    {
        return cost;
    }
    public int getRarity()
    {
        return rarity;
    }
    public void moveCard(int x)
    {
        this.x = x;
    }
    public boolean isOver(int mX, int mY) {
        return x < mX && x + width > mX && y < mY && y + length > mY;
    }
}
