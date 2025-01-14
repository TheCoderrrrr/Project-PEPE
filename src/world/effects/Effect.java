package world.effects;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import world.entity.Entity;
import world.ui.panel.Tooltip;

abstract public class Effect {
    protected Entity target;
    protected int duration;
    protected String name;
    protected int maxDuration;
    protected Image symbol;
    protected String info;

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
    public Image getSymbol(){
        return symbol;
    }
    public void resetDuration()
    {
        duration = maxDuration;
    }
    public String getInfo(){
        return info;
    }
    public void updateInfo(){
        info = info;
    }

}
