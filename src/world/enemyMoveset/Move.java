package world.enemyMoveset;

import world.entity.EnemyUnit;

public abstract class Move {
    private int damage;

    public Move() {

    }
    public abstract void action();


    public int getDamage() {
        return damage;
    }
}
