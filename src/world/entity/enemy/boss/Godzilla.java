package world.entity.enemy.boss;

import world.entity.enemy.EnemyUnit;

public class Godzilla extends EnemyUnit {
    public Godzilla(int x, int y) {
        super(x, y);
        maxHealth *= 4;
    }
    private void addMoves(){

    }
}
