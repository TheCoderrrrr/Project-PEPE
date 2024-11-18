package world.cards;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public abstract class Card {
    protected int cost;
    protected int rarity;
    protected final static int width = 200;
    protected final static int height = 300;
    protected int x;
    protected int y;
    protected int centerX;
    protected int centerY;
    protected float rotation;
    protected boolean selected;
    protected GameContainer gc;
    public Card(GameContainer gc, int x, int y, float rotation)
    {
        this.x = x;
        this.y = y;
        centerX = x + width/2;
        centerY = y + height /2;
        this.rotation = rotation;
        this.gc = gc;
        selected = false;
    }
    public abstract void action();
    public void render(Graphics g)
    {
        if(!selected)
        {
            g.rotate(centerX, centerY, rotation);
            g.drawRect(x, y, width, height);
        }
        else {
            g.drawRect(gc.getInput().getMouseX(), gc.getInput().getMouseY(), width, height);
        }
    }
    public static int getWidth()
    {
        return width;
    }
    public void select()
    {
        selected = true;
    }
    public void unselect()
    {
        selected = false;
    }
    public boolean selected()
    {
        return selected;
    }
    public static int getHeight()
    {
        return height;
    }
    public int getCost()
    {
        return cost;
    }
    public int getRarity()
    {
        return rarity;
    }
    public void moveCard(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    public boolean isOver(int mX, int mY) {
        return x <= mX && x + width > mX && y <= mY && y + height > mY;
    }
    public void setRotation(float degree){
        rotation = degree;
    }
    public float getRotation()
    {
        return rotation;
    }
    public int getCenterX()
    {
        return centerX;
    }
    public int getCenterY()
    {
        return centerY;
    }
}
