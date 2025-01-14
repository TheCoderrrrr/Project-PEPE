package world.entity.enemy;

import resources.Images;

public class Horse extends EnemyUnit{
    public Horse(int x, int y) {
        super(x, y);
        image = Images.ENEMY1;
    }
}
