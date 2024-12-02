package world.effects;

import world.entity.Entity;

abstract public class Effect {
    protected Entity target;
    protected int duration;
    protected String name;

    public Effect(Entity e, int duration) {;
        target = e;
        this.duration = duration;
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
}
