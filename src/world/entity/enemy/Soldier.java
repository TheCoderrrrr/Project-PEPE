package world.entity.enemy;

import resources.Images;

public class Soldier extends EnemyUnit{
    public Soldier(int x, int y) {
        super(x, y);
        image = Images.ENEMY2;
    }
}
