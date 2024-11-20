package world.entity;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import world.managers.EntityManager;

public abstract class Entity {
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected String name;
    protected int health;
    protected int position;
    protected EntityManager entityManager;

    public Entity(int x, int y, EntityManager entityManager)
    {
        this.x = x;
        this.y = y;
        width = 100;
        height = 200;
        this.entityManager = entityManager;
    }

    public int getX() {
        return x;
    }
    public int getY()
    {
        return y;
    }
    public String getName()
    {
        return name;
    }
    public int getHealth()
    {
        return health;
    }
    public void render(Graphics g)
    {
        g.setColor(Color.white);
        g.fillRect(x, y, width, height);
    }
    public void die()
    {
        if(health <= 0)
        {
            entityManager.getEntities().remove(this);
        }
    }
}
