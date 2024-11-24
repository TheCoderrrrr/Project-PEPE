package world.effects;

import world.entity.Entity;

abstract public class Effect {
    protected Entity target;
    protected int duration;

    public Effect(Entity e, int duration) {;
        target = e;
    }

    public void action() {
        duration--;
    }

    public boolean isExpired() {
        return duration <= 0;
    }

}
