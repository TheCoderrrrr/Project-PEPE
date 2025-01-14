package world.entity.enemy.miniboss;

import world.entity.enemy.EnemyUnit;

public class Stack extends EnemyUnit {
    public Stack(int x, int y) {
        super(x, y);
        maxHealth *= 2;
    }
}
