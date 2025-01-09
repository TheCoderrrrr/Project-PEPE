package world.effects;

import org.newdawn.slick.Image;
import world.entity.Entity;

abstract public class Effect {
    protected Entity target;
    protected int duration;
    protected String name;
    protected int maxDuration;
    protected Image symbol;

    public Effect(Entity e, int duration) {;
        target = e;
        this.duration = duration;
        maxDuration = duration;
    }

    public void action() {
        duration--;
    }

    public boolean isExpired() {
        return duration <= 0;
    }
    public int getDuration()
    {
        return duration;
    }
    public String getName()
    {
        return name;
    }
    public void resetDuration()
    {
        duration = maxDuration;
    }
    public Image getSymbol(){
        return symbol;
    }
}
