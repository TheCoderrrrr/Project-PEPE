package world.entity.enemy.miniboss;

import world.entity.enemy.EnemyUnit;

public class Truck extends EnemyUnit {
    public Truck(int x, int y) {
        super(x, y);
        maxHealth *= 2;
    }
}
