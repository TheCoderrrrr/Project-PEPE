package world.entity;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import world.Player;
import world.effects.Effect;
import world.effects.buff.Shield;
import world.effects.debuff.Mark;
import world.managers.EntityManager;
import world.ui.panel.StatusEffectPanel;

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
    protected Image image;
    protected EntityManager entityManager;
    protected ArrayList<Effect> activeEffects;
    protected StatusEffectPanel statusEffectPanel;

    protected int animationFrame;

    public Entity(int x, int y) {
        activeEffects = new ArrayList<>();
        this.x = x;
        this.y = y;
        width = 100;
        height = 200;
        curHealth = 100;
        maxHealth = curHealth;
        statusEffectPanel = new StatusEffectPanel(x, y + height, 96, 96);
    }

    public boolean completedAnimation() {return animationFrame >= 20;}
    public void continueAnimation() {animationFrame++;}
    public void resetAnimation() {animationFrame = 0;}


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
        System.out.println(amount);
        curHealth += (int) amount;
    }
    public void addEffect(Effect e) {
        boolean hasEffect = false;
        for(Effect usedEffect : activeEffects)
        {
            if(usedEffect.getName().equals(e.getName()))
            {
                hasEffect = true;
                usedEffect.resetDuration();
            }
        }
        if(!hasEffect)
        {
            activeEffects.add(e);
            statusEffectPanel.updateStatusEffects(activeEffects);
        }
    }

    public void render(Graphics g) {
        g.setColor(Color.white);
        g.drawImage(image,x - animationFrame , y);
        g.setColor(Color.blue);
        g.drawString(""+ curHealth, x - animationFrame, y);
        statusEffectPanel.render(g);
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
