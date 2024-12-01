package world.entity;

import world.effects.Effect;

import java.util.ArrayList;

public class PlayerUnit extends Entity{


    public PlayerUnit(int x, int y) {
        super(x, y);
    }
    public ArrayList<Effect> getEffects()
    {
        return activeEffects;
    }
}
