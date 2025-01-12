package world.enemyMoveset;

import world.entity.EnemyUnit;
import world.entity.Entity;

public abstract class Move {
    private int damage;

    public Move() {

    }
    public abstract void action(Entity entity);


    public int getDamage() {
        return damage;
    }
}
