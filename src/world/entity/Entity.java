package world.entity;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import world.Player;
import world.effects.Effect;
import world.effects.buff.Shield;
import world.effects.debuff.Mark;
import world.managers.EntityManager;

import java.util.ArrayList;

public abstract class Entity {
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected int critRate;
    protected int critMultiplier;
    protected String name;
    protected int maxHealth;
    protected int curHealth;
    protected int position;
    protected EntityManager entityManager;
    protected ArrayList<Effect> activeEffects;

    public Entity(int x, int y) {
        activeEffects = new ArrayList<>();
        this.x = x;
        this.y = y;
        width = 100;
        height = 200;
        curHealth = 100;
        maxHealth = curHealth;
    }

    public void newRound() {
        curHealth = maxHealth;
    }

    public void endTurn() {
        for(Effect e : activeEffects) {
            e.action();
        }
        for(int i=0; i< activeEffects.size(); i++) {
            if(activeEffects.get(i).isExpired()) {
                activeEffects.remove(i);
                i--;
            }
        }
    }
    public ArrayList<Effect> getActiveEffects()
    {
        return activeEffects;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getName() {
        return name;
    }

    public int getMaxHealth()
    {
        return maxHealth;
    }
    public float getPercentHealthLeft()
    {
        return (float) curHealth / (float) maxHealth;
    }
    public int getCurHealth() {
        return curHealth;
    }
    public abstract void takeDamage(int damage);
    public void heal(float amount)
    {
        curHealth = (int) Math.min(maxHealth, curHealth + amount);
    }
    public void addEffect(Effect e) {activeEffects.add(e);}

    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(x, y, width, height);
        g.setColor(Color.blue);
        g.drawString(""+ curHealth, x, y);
    }
    public int getWidth()
    {
        return width;
    }
    public int getHeight()
    {
        return height;
    }
}
